package com.ispmanagement.app.ui.cs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ispmanagement.app.data.Odp
import com.ispmanagement.app.data.Pelanggan
import com.ispmanagement.app.data.Tagihan
import com.ispmanagement.app.databinding.FragmentRegistrasiPelangganBinding
import com.ispmanagement.app.viewmodel.AppViewModel
import java.text.SimpleDateFormat
import java.util.*

class RegistrasiPelangganFragment : Fragment() {

    private var _binding: FragmentRegistrasiPelangganBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModels(ownerProducer = { requireActivity() })

    // Variabel untuk menyimpan objek ODP yang dipilih secara lengkap
    private var odpTerpilih: Odp? = null

    data class PaketISP(val nama: String, val harga: Long)

    private val daftarPaket = listOf(
        PaketISP("Paket Hemat 20 Mbps", 150000L),
        PaketISP("Paket Standar 30 Mbps", 250000L),
        PaketISP("Paket Keluarga 50 Mbps", 350000L),
        PaketISP("Paket Gamer Pro 100 Mbps", 600000L)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrasiPelangganBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        generateNomorLayananOtomatis()
        setupDropdownPaket()
        setupDropdownOdp()

        binding.btnSimpanPelanggan.setOnClickListener {
            simpanPelanggan()
        }
    }

    private fun generateNomorLayananOtomatis() {
        binding.etNomorLayanan.isEnabled = false
        viewModel.getLastPelanggan { lastPelanggan ->
            val nextNomor = if (lastPelanggan != null && lastPelanggan.nomorLayanan.startsWith("ISP")) {
                val lastNumber = lastPelanggan.nomorLayanan.removePrefix("ISP").toIntOrNull() ?: 0
                val nextNumber = lastNumber + 1
                String.format("ISP%04d", nextNumber)
            } else {
                "ISP0001"
            }
            binding.etNomorLayanan.setText(nextNomor)
        }
    }

    private fun setupDropdownPaket() {
        val paketNames = daftarPaket.map { it.nama }
        val adapterPaket = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, paketNames)
        (binding.etPaket as? AutoCompleteTextView)?.setAdapter(adapterPaket)

        (binding.etPaket as? AutoCompleteTextView)?.setOnItemClickListener { _, _, position, _ ->
            val selectedPaket = daftarPaket[position]
            binding.etHargaPaket.setText(selectedPaket.harga.toString())
            binding.etHargaPaket.isEnabled = false
        }
    }

    private fun setupDropdownOdp() {
        viewModel.semuaOdp.observe(viewLifecycleOwner) { listOdp ->
            if (listOdp != null) {
                val odpNames = listOdp.map { odp -> odp.namaOdp }
                val adapterOdp = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, odpNames)
                val autoCompleteOdp = binding.etOdp as? AutoCompleteTextView
                autoCompleteOdp?.setAdapter(adapterOdp)

                autoCompleteOdp?.setOnItemClickListener { _, _, position, _ ->
                    val selectedOdp = listOdp[position]
                    val sisaPort = selectedOdp.totalPort - selectedOdp.portTerpakai

                    if (sisaPort <= 0) {
                        odpTerpilih = null // Reset pilihan
                        binding.layoutOdp.error = "Port penuh! Pilih ODP lain."
                        binding.layoutOdp.helperText = null
                        binding.btnSimpanPelanggan.isEnabled = false
                        Toast.makeText(requireContext(), "ODP ${selectedOdp.namaOdp} sudah tidak memiliki port kosong!", Toast.LENGTH_SHORT).show()
                    } else {
                        odpTerpilih = selectedOdp // Simpan objek ODP yang valid
                        binding.layoutOdp.error = null
                        binding.layoutOdp.helperText = "Tersedia $sisaPort port kosong."
                        binding.btnSimpanPelanggan.isEnabled = true
                    }
                }
            }
        }
    }

    private fun simpanPelanggan() {
        val nama          = binding.etNama.text?.toString()?.trim().orEmpty()
        val alamat        = binding.etAlamat.text?.toString()?.trim().orEmpty()
        val noHp          = binding.etNoHp.text?.toString()?.trim().orEmpty()
        val paket         = binding.etPaket.text?.toString()?.trim().orEmpty()
        val hargaStr      = binding.etHargaPaket.text?.toString()?.trim().orEmpty()
        val odpAkses      = binding.etOdp.text?.toString()?.trim().orEmpty()
        val nomorLayanan  = binding.etNomorLayanan.text?.toString()?.trim().orEmpty()
        val username      = binding.etUsername.text?.toString()?.trim().orEmpty()
        val password      = binding.etPassword.text?.toString()?.trim().orEmpty()

        if (listOf(nama, alamat, noHp, paket, hargaStr, odpAkses, nomorLayanan, username, password)
                .any { it.isEmpty() }
        ) {
            Toast.makeText(requireContext(), "Semua field wajib diisi", Toast.LENGTH_SHORT).show()
            return
        }

        // Mencegah CS mengetik manual nama ODP yang tidak ada di sistem
        if (odpTerpilih == null || odpTerpilih?.namaOdp != odpAkses) {
            Toast.makeText(requireContext(), "Silakan pilih ODP dari daftar yang tersedia", Toast.LENGTH_SHORT).show()
            return
        }

        val harga = hargaStr.toLongOrNull() ?: 0L
        val fmt   = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val today = fmt.format(Date())

        val cal = Calendar.getInstance().apply {
            add(Calendar.MONTH, 1)
            set(Calendar.DAY_OF_MONTH, 25)
        }
        val jatuhTempo = fmt.format(cal.time)
        val periode    = SimpleDateFormat("MMMM yyyy", Locale("in", "ID"))
            .format(cal.time)

        val pelanggan = Pelanggan(
            nomorLayanan  = nomorLayanan,
            nama          = nama,
            alamat        = alamat,
            noHp          = noHp,
            paket         = paket,
            hargaPaket    = harga,
            odp           = odpAkses, // <-- KOMENTAR DIHAPUS, data ODP sekarang masuk
            tanggalDaftar = today,
            username      = username,
            password      = password
        )

        viewModel.registrasiPelanggan(pelanggan) { newId ->
            viewModel.tambahTagihan(
                Tagihan(
                    pelangganId = newId,
                    periode     = periode,
                    jumlah      = harga,
                    jatuhTempo  = jatuhTempo,
                    status      = "Belum Bayar"
                )
            ) {
                if (!isAdded) return@tambahTagihan

                // Tambahkan 1 pada port yang terpakai di ODP tersebut
                val odpUpdate = odpTerpilih!!.copy(portTerpakai = odpTerpilih!!.portTerpakai + 1)

                // Simpan update ODP ke database
                viewModel.updateOdp(odpUpdate) {
                    if (!isAdded) return@updateOdp

                    Toast.makeText(
                        requireContext(),
                        "Pelanggan $nama berhasil didaftarkan, Port ODP telah disesuaikan.",
                        Toast.LENGTH_LONG
                    ).show()
                    findNavController().popBackStack()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}