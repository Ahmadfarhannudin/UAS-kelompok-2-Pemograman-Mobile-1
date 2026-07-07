package com.ispmanagement.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.ispmanagement.app.data.*
import kotlinx.coroutines.launch

class AppViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(application)
    val session = SessionManager(application)

    // ---------------- LiveData sumber data ----------------
    val semuaPelanggan: LiveData<List<Pelanggan>> = repository.getAllPelanggan()
    val semuaKonfirmasi: LiveData<List<KonfirmasiPembayaran>> = repository.getAllKonfirmasi()
    val semuaTagihan: LiveData<List<Tagihan>> = repository.getAllTagihan()
    val konfirmasiPending: LiveData<List<KonfirmasiPembayaran>> = repository.getKonfirmasiPending()
    val semuaTiket: LiveData<List<TiketKomplain>> = repository.getAllTiket()
    val semuaOdp: LiveData<List<Odp>> = repository.getAllOdp()

    // Deklarasi MediatorLiveData (Hanya satu kali)
    val tagihanLengkap = MediatorLiveData<List<Tagihan>>()

    init {
        // Gabungkan data saat ada perubahan di Tagihan
        tagihanLengkap.addSource(repository.getAllTagihan()) { listTagihan ->
            viewModelScope.launch {
                val listKonfirmasi = repository.getAllKonfirmasiSync()
                gabungkanData(listTagihan, listKonfirmasi)
            }
        }

        // Gabungkan data saat ada perubahan di Konfirmasi
        tagihanLengkap.addSource(repository.getAllKonfirmasi()) { listKonfirmasi ->
            viewModelScope.launch {
                val listTagihan = repository.getAllTagihan().value
                gabungkanData(listTagihan, listKonfirmasi)
            }
        }
    }

    private fun gabungkanData(listTagihan: List<Tagihan>?, listKonfirmasi: List<KonfirmasiPembayaran>?) {
        if (listTagihan == null) return

        val dataGabungan = listTagihan.map { t ->
            val k = listKonfirmasi?.find { it.tagihanId == t.id }
            t.apply {
                fotoPath = k?.fotoPath
                tanggalBayar = k?.tanggalBayar
                caraBayar = k?.caraBayar
            }
        }
        tagihanLengkap.postValue(dataGabungan)
    }

    // ---------------- Fungsi lainnya (Login, Konfirmasi, Registrasi, dll) ----------------
    fun tagihanByPelanggan(pelangganId: Long): LiveData<List<Tagihan>> = repository.getTagihanByPelanggan(pelangganId)
    fun tiketByPelanggan(pelangganId: Long): LiveData<List<TiketKomplain>> = repository.getTiketByPelanggan(pelangganId)

    fun cekTagihan(nomorLayanan: String, onResult: (Pelanggan?, List<Tagihan>) -> Unit) {
        viewModelScope.launch {
            val pelanggan = repository.cekTagihanByNomorLayanan(nomorLayanan)
            if (pelanggan != null) {
                val tagihan = repository.getTagihanByPelangganSync(pelanggan.id)
                onResult(pelanggan, tagihan)
            } else {
                onResult(null, emptyList())
            }
        }
    }

    fun loginPelanggan(username: String, password: String, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            val p = repository.loginPelanggan(username, password)
            if (p != null) {
                session.loginPelanggan(p.id, p.nama)
                onResult(true, "Login berhasil")
            } else {
                onResult(false, "Username atau password salah")
            }
        }
    }

    fun loginCs(username: String, password: String, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            val user = repository.loginCs(username, password)
            if (user != null) {
                session.loginCs(user.id, user.nama)
                onResult(true, "Login berhasil")
            } else {
                onResult(false, "Username atau password salah")
            }
        }
    }

    fun kirimKonfirmasi(tagihanId: Long, pelangganId: Long, tanggalBayar: String, caraBayar: String, fotoPath: String, onDone: () -> Unit) {
        viewModelScope.launch {
            repository.kirimKonfirmasiPembayaran(KonfirmasiPembayaran(
                tagihanId = tagihanId, pelangganId = pelangganId, tanggalBayar = tanggalBayar,
                caraBayar = caraBayar, fotoPath = fotoPath, status = "Pending"
            ))
            val tagihan = repository.getTagihanById(tagihanId)
            if (tagihan != null) {
                repository.updateTagihan(tagihan.copy(status = "Pending"))
            }
            onDone()
        }
    }

    fun terimaPembayaran(k: KonfirmasiPembayaran, onDone: () -> Unit) {
        viewModelScope.launch { repository.terimaPembayaran(k); onDone() }
    }

    fun tolakPembayaran(k: KonfirmasiPembayaran, catatan: String, onDone: () -> Unit) {
        viewModelScope.launch { repository.tolakPembayaran(k, catatan); onDone() }
    }

    fun getLastPelanggan(onResult: (Pelanggan?) -> Unit) {
        viewModelScope.launch { onResult(repository.getLastPelanggan()) }
    }

    fun registrasiPelanggan(p: Pelanggan, onDone: (Long) -> Unit) {
        viewModelScope.launch { onDone(repository.registrasiPelanggan(p)) }
    }

    fun tambahTagihan(t: Tagihan, onDone: () -> Unit) {
        viewModelScope.launch { repository.tambahTagihan(t); onDone() }
    }

    fun updateTagihan(t: Tagihan, onDone: () -> Unit) {
        viewModelScope.launch { repository.updateTagihan(t); onDone() }
    }

    fun updatePelangganStatus(p: Pelanggan, statusBaru: String, onDone: () -> Unit) {
        viewModelScope.launch { repository.updatePelanggan(p.copy(statusLayanan = statusBaru)); onDone() }
    }

    fun cekJatuhTempoBerkala(todayStr: String, batasStr: String, onDone: (Unit) -> Unit) {
        viewModelScope.launch { repository.cekDanUpdateIsolir(todayStr, batasStr); onDone(Unit) }
    }

    fun buatTiket(t: TiketKomplain, onDone: () -> Unit) {
        viewModelScope.launch { repository.buatTiket(t); onDone() }
    }

    fun balasTiket(t: TiketKomplain, balasan: String, statusBaru: String, onDone: () -> Unit) {
        viewModelScope.launch { repository.updateTiket(t.copy(balasanCS = balasan, status = statusBaru)); onDone() }
    }

    suspend fun jumlahTiketSaatIni(): Int = repository.jumlahTiket()

    suspend fun getTiketByIdSuspend(id: Long): TiketKomplain? = repository.getTiketById(id)

    fun tambahOdp(o: Odp, onDone: () -> Unit) { viewModelScope.launch { repository.tambahOdp(o); onDone() } }
    fun hapusOdp(o: Odp, onDone: () -> Unit) { viewModelScope.launch { repository.hapusOdp(o); onDone() } }
    fun updateOdp(o: Odp, onDone: () -> Unit) { viewModelScope.launch { repository.updateOdp(o); onDone() } }

    fun getPelangganById(id: Long, onResult: (Pelanggan?) -> Unit) {
        viewModelScope.launch { onResult(repository.getPelangganById(id)) }
    }

    fun hitungRingkasanDashboard(onResult: (Int, Int, Int, Int) -> Unit) {
        viewModelScope.launch {
            val pelangganList = semuaPelanggan.value ?: emptyList()
            val pendingList = konfirmasiPending.value ?: emptyList()
            val tiketList = semuaTiket.value ?: emptyList()
            val isolirCount = pelangganList.count { it.statusLayanan == "Terisolir" }
            onResult(pelangganList.size, pendingList.size, tiketList.size, isolirCount)
        }
    }
}