package com.ispmanagement.app.data

import android.content.Context
import androidx.lifecycle.LiveData

/**
 * Repository tunggal yang menjadi satu pintu akses ke seluruh tabel database.
 * Membuat penggunaan database "mudah" dari sisi UI/ViewModel karena semua
 * operasi CRUD dikumpulkan di satu tempat.
 */
class Repository(context: Context) {

    private val db = AppDatabase.getInstance(context)

    private val pelangganDao = db.pelangganDao()
    private val tagihanDao = db.tagihanDao()
    private val konfirmasiDao = db.konfirmasiDao()
    private val tiketDao = db.tiketDao()
    private val odpDao = db.odpDao()
    private val csUserDao = db.csUserDao()

    // ---------- Pelanggan ----------
    suspend fun registrasiPelanggan(p: Pelanggan) = pelangganDao.insert(p)
    suspend fun updatePelanggan(p: Pelanggan) = pelangganDao.update(p)
    suspend fun cekTagihanByNomorLayanan(nomor: String) = pelangganDao.getByNomorLayanan(nomor)
    suspend fun loginPelanggan(username: String, password: String) = pelangganDao.login(username, password)
    suspend fun getPelangganById(id: Long) = pelangganDao.getById(id)
    fun getAllPelanggan(): LiveData<List<Pelanggan>> = pelangganDao.getAll()

    // 👇 INI TAMBAHANNYA: Meneruskan panggilan getLastPelanggan ke DAO
    suspend fun getLastPelanggan() = pelangganDao.getLastPelanggan()

    // ---------- Tagihan ----------
    suspend fun tambahTagihan(t: Tagihan) = tagihanDao.insert(t)
    suspend fun updateTagihan(t: Tagihan) = tagihanDao.update(t)
    fun getTagihanByPelanggan(pelangganId: Long): LiveData<List<Tagihan>> = tagihanDao.getByPelanggan(pelangganId)
    suspend fun getTagihanByPelangganSync(pelangganId: Long) = tagihanDao.getByPelangganSync(pelangganId)
    suspend fun getTagihanById(id: Long) = tagihanDao.getById(id)
    fun getAllTagihan(): LiveData<List<Tagihan>> = tagihanDao.getAllTagihan()

    /** Cek jatuh tempo lebih dari 30 hari -> ubah status pelanggan jadi Terisolir (manajemen status manual). */
    suspend fun cekDanUpdateIsolir(todayStr: String, batasHariString: String) {
        val overdue = tagihanDao.getOverdue(batasHariString)
        val pelangganIds = overdue.map { it.pelangganId }.distinct()
        for (id in pelangganIds) {
            val p = pelangganDao.getById(id) ?: continue
            if (p.statusLayanan != "Terisolir") {
                pelangganDao.update(p.copy(statusLayanan = "Terisolir"))
            }
        }
    }

    // ---------- Konfirmasi Pembayaran ----------
    suspend fun kirimKonfirmasiPembayaran(k: KonfirmasiPembayaran) = konfirmasiDao.insert(k)
    fun getAllKonfirmasi(): LiveData<List<KonfirmasiPembayaran>> = konfirmasiDao.getAll()
    fun getKonfirmasiPending(): LiveData<List<KonfirmasiPembayaran>> = konfirmasiDao.getPending()

    /** CS menerima pembayaran -> update status konfirmasi & tagihan menjadi Paid. */
    suspend fun terimaPembayaran(konfirmasi: KonfirmasiPembayaran) {
        konfirmasiDao.update(konfirmasi.copy(status = "Diterima"))
        val tagihan = tagihanDao.getById(konfirmasi.tagihanId)
        if (tagihan != null) {
            tagihanDao.update(tagihan.copy(status = "Paid"))
        }
        // jika pelanggan sebelumnya terisolir dan sekarang lunas, aktifkan kembali (manual oleh CS)
    }

    suspend fun tolakPembayaran(konfirmasi: KonfirmasiPembayaran, catatan: String) {
        konfirmasiDao.update(konfirmasi.copy(status = "Ditolak", catatanCS = catatan))
        val tagihan = tagihanDao.getById(konfirmasi.tagihanId)
        if (tagihan != null) {
            tagihanDao.update(tagihan.copy(status = "Belum Bayar"))
        }
    }

    // ---------- Tiket Komplain ----------
    suspend fun buatTiket(t: TiketKomplain) = tiketDao.insert(t)
    suspend fun updateTiket(t: TiketKomplain) = tiketDao.update(t)
    fun getAllTiket(): LiveData<List<TiketKomplain>> = tiketDao.getAll()
    fun getTiketByPelanggan(pelangganId: Long): LiveData<List<TiketKomplain>> = tiketDao.getByPelanggan(pelangganId)
    suspend fun getTiketById(id: Long) = tiketDao.getById(id)
    suspend fun jumlahTiket() = tiketDao.count()

    // ---------- ODP ----------
    suspend fun tambahOdp(o: Odp) = odpDao.insert(o)
    suspend fun updateOdp(o: Odp) = odpDao.update(o)
    suspend fun hapusOdp(o: Odp) = odpDao.delete(o)
    fun getAllOdp(): LiveData<List<Odp>> = odpDao.getAll()
    // Di dalam class Repository
    // Di dalam class Repository
    suspend fun getAllKonfirmasiSync(): List<KonfirmasiPembayaran> {
        return konfirmasiDao.getAllKonfirmasiSync()
    }
    // ---------- CS User ----------
    suspend fun loginCs(username: String, password: String) = csUserDao.login(username, password)
}