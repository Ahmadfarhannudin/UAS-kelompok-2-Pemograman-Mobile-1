package com.ispmanagement.app.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PelangganDao {
    @Insert
    suspend fun insert(pelanggan: Pelanggan): Long

    @Update
    suspend fun update(pelanggan: Pelanggan)

    @Query("SELECT * FROM pelanggan WHERE nomorLayanan = :nomorLayanan LIMIT 1")
    suspend fun getByNomorLayanan(nomorLayanan: String): Pelanggan?

    @Query("SELECT * FROM pelanggan WHERE username = :username AND password = :password LIMIT 1")
    suspend fun login(username: String, password: String): Pelanggan?

    @Query("SELECT * FROM pelanggan WHERE id = :id")
    suspend fun getById(id: Long): Pelanggan?

    @Query("SELECT * FROM pelanggan ORDER BY nama ASC")
    fun getAll(): LiveData<List<Pelanggan>>

    @Query("SELECT COUNT(*) FROM pelanggan")
    suspend fun count(): Int

    // 👇 INI ADALAH TAMBAHAN BARU UNTUK NOMOR LAYANAN OTOMATIS
    @Query("SELECT * FROM pelanggan ORDER BY id DESC LIMIT 1")
    suspend fun getLastPelanggan(): Pelanggan?
}

@Dao
interface TagihanDao {
    @Insert
    suspend fun insert(tagihan: Tagihan): Long

    @Update
    suspend fun update(tagihan: Tagihan)

    @Query("SELECT * FROM tagihan WHERE pelangganId = :pelangganId ORDER BY id DESC")
    fun getByPelanggan(pelangganId: Long): LiveData<List<Tagihan>>

    @Query("SELECT * FROM tagihan WHERE pelangganId = :pelangganId ORDER BY id DESC")
    suspend fun getByPelangganSync(pelangganId: Long): List<Tagihan>

    @Query("SELECT * FROM tagihan WHERE id = :id")
    suspend fun getById(id: Long): Tagihan?

    @Query("SELECT * FROM tagihan WHERE status = 'Belum Bayar' AND jatuhTempo < :today")
    suspend fun getOverdue(today: String): List<Tagihan>

    @Query("SELECT COUNT(*) FROM tagihan WHERE status = 'Belum Bayar'")
    suspend fun countUnpaid(): Int

    @Query("SELECT * FROM tagihan ORDER BY id DESC")
    fun getAllTagihan(): LiveData<List<Tagihan>>
}

@Dao
interface KonfirmasiPembayaranDao {
    @Insert
    suspend fun insert(konfirmasi: KonfirmasiPembayaran): Long

    @Update
    suspend fun update(konfirmasi: KonfirmasiPembayaran)

    @Query("SELECT * FROM konfirmasi_pembayaran ORDER BY id DESC")
    fun getAll(): LiveData<List<KonfirmasiPembayaran>>

    // 👇 TAMBAHKAN BARIS INI:
    @Query("SELECT * FROM konfirmasi_pembayaran")
    suspend fun getAllKonfirmasiSync(): List<KonfirmasiPembayaran>

    @Query("SELECT * FROM konfirmasi_pembayaran WHERE status = 'Pending' ORDER BY id DESC")
    fun getPending(): LiveData<List<KonfirmasiPembayaran>>

    @Query("SELECT * FROM konfirmasi_pembayaran WHERE id = :id")
    suspend fun getById(id: Long): KonfirmasiPembayaran?
}

@Dao
interface TiketKomplainDao {
    @Insert
    suspend fun insert(tiket: TiketKomplain): Long

    @Update
    suspend fun update(tiket: TiketKomplain)

    @Query("SELECT * FROM tiket_komplain ORDER BY id DESC")
    fun getAll(): LiveData<List<TiketKomplain>>

    @Query("SELECT * FROM tiket_komplain WHERE pelangganId = :pelangganId ORDER BY id DESC")
    fun getByPelanggan(pelangganId: Long): LiveData<List<TiketKomplain>>

    @Query("SELECT * FROM tiket_komplain WHERE id = :id")
    suspend fun getById(id: Long): TiketKomplain?

    @Query("SELECT COUNT(*) FROM tiket_komplain")
    suspend fun count(): Int
}

@Dao
interface OdpDao {
    @Insert
    suspend fun insert(odp: Odp): Long

    @Update
    suspend fun update(odp: Odp)

    @Delete
    suspend fun delete(odp: Odp)

    @Query("SELECT * FROM odp ORDER BY id DESC")
    fun getAll(): LiveData<List<Odp>>
}

@Dao
interface CsUserDao {
    @Insert
    suspend fun insert(user: CsUser): Long

    @Query("SELECT * FROM cs_user WHERE username = :username AND password = :password LIMIT 1")
    suspend fun login(username: String, password: String): CsUser?

    @Query("SELECT COUNT(*) FROM cs_user")
    suspend fun count(): Int
}