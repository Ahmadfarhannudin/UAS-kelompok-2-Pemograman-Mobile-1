package com.ispmanagement.app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Pelanggan::class, Tagihan::class, KonfirmasiPembayaran::class,
        TiketKomplain::class, Odp::class, CsUser::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pelangganDao(): PelangganDao
    abstract fun tagihanDao(): TagihanDao
    abstract fun konfirmasiDao(): KonfirmasiPembayaranDao
    abstract fun tiketDao(): TiketKomplainDao
    abstract fun odpDao(): OdpDao
    abstract fun csUserDao(): CsUserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Migration dari version 1 ke 2:

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "ALTER TABLE pelanggan ADD COLUMN odp TEXT NOT NULL DEFAULT ''"
                )
            }
        }

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "isp_management.db"
                )
                    .addMigrations(MIGRATION_1_2)
                    .build()

                INSTANCE = instance
                seedIfEmpty(instance)
                instance
            }
        }

        /** Mengisi data awal (akun CS default + contoh pelanggan) agar aplikasi langsung bisa dicoba. */
        private fun seedIfEmpty(db: AppDatabase) {
            CoroutineScope(Dispatchers.IO).launch {
                if (db.csUserDao().count() == 0) {
                    db.csUserDao().insert(CsUser(username = "admin", password = "admin123", nama = "Admin CS"))
                }
                if (db.pelangganDao().count() == 0) {
                    val idA = db.pelangganDao().insert(
                        Pelanggan(
                            nomorLayanan = "ISP0001",
                            nama = "Budi Santoso",
                            alamat = "Jl. Merdeka No. 10, Bandung",
                            noHp = "081234567890",
                            paket = "20 Mbps",
                            hargaPaket = 250000,
                            odp = "ODP-01",
                            tanggalDaftar = "2026-01-10",
                            username = "budi",
                            password = "budi123"
                        )
                    )
                    db.tagihanDao().insert(
                        Tagihan(pelangganId = idA, periode = "Juni 2026", jumlah = 250000, jatuhTempo = "2026-06-25", status = "Belum Bayar")
                    )
                    db.tagihanDao().insert(
                        Tagihan(pelangganId = idA, periode = "Juli 2026", jumlah = 250000, jatuhTempo = "2026-07-25", status = "Belum Bayar")
                    )
                }
            }
        }
    }
}