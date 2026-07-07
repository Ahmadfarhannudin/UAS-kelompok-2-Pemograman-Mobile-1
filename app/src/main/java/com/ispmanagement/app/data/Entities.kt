package com.ispmanagement.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.Ignore
// ================== PELANGGAN ==================
@Entity(tableName = "pelanggan")
data class Pelanggan(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nomorLayanan: String,          // dipakai untuk cek tagihan tanpa login
    val nama: String,
    val alamat: String,
    val noHp: String,
    val paket: String,                 // paket internet, misal 20Mbps
    val hargaPaket: Long,

    @ColumnInfo(name = "odp")          //  KOLOM ODP
    val odp: String = "",

    val tanggalDaftar: String,
    var statusLayanan: String = "Aktif",   // Aktif / Terisolir
    val username: String,              // login untuk fitur komplain
    val password: String
)

// ================== TAGIHAN ==================
@Entity(tableName = "tagihan")
data class Tagihan(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val pelangganId: Long,
    val periode: String,
    val jumlah: Long,
    val jatuhTempo: String,
    var status: String = "Belum Bayar"
) {
    @Ignore
    var fotoPath: String? = null

    @Ignore
    var tanggalBayar: String? = null

    @Ignore
    var caraBayar: String? = null
}

// ================== KONFIRMASI PEMBAYARAN ==================
@Entity(tableName = "konfirmasi_pembayaran")
data class KonfirmasiPembayaran(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val tagihanId: Long,
    val pelangganId: Long,
    val tanggalBayar: String,
    val caraBayar: String,             // ATM / M-Banking / dst
    val fotoPath: String,              // path file bukti transfer
    var status: String = "Pending",    // Pending / Diterima / Ditolak
    var catatanCS: String = ""

)

// ================== TIKET KOMPLAIN ==================
@Entity(tableName = "tiket_komplain")
data class TiketKomplain(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nomorAntrean: String,
    val pelangganId: Long,
    val judul: String,
    val deskripsi: String,
    var status: String = "Baru",       // Baru / Diproses / Selesai
    var balasanCS: String = "",
    val tanggalDibuat: String
)

// ================== ODP ==================
@Entity(tableName = "odp")
data class Odp(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val namaOdp: String,
    val alamat: String,
    val latitude: Double,
    val longitude: Double,
    val totalPort: Int,
    val portTerpakai: Int
)

// ================== CS / ADMIN USER ==================
@Entity(tableName = "cs_user")
data class CsUser(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val username: String,
    val password: String,
    val nama: String
)
