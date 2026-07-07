package com.ispmanagement.app.ui.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ispmanagement.app.R
import com.ispmanagement.app.data.Pelanggan
import com.ispmanagement.app.databinding.FragmentCekTagihanBinding
import com.ispmanagement.app.ui.adapters.TagihanAdapter
import com.ispmanagement.app.viewmodel.AppViewModel

class CekTagihanFragment : Fragment() {

    private var _binding: FragmentCekTagihanBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModels(ownerProducer = { requireActivity() })
    private var pelangganAktif: Pelanggan? = null
    private lateinit var adapter: TagihanAdapter

    private val mode: String
        get() = arguments?.getString("mode") ?: "cek"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCekTagihanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupModeUI()

        val btnLabel = if (mode == "konfirmasi") "Konfirmasi Sekarang" else "Konfirmasi Pembayaran"

        adapter = TagihanAdapter(
            items = emptyList(),
            onBayarClick = { tagihan ->
                val p = pelangganAktif ?: return@TagihanAdapter
                findNavController().navigate(
                    R.id.konfirmasiPembayaranFragment,
                    Bundle().apply {
                        putLong("tagihanId", tagihan.id)
                        putLong("pelangganId", p.id)
                        putString("nomorLayanan", p.nomorLayanan)
                    }
                )
            },
            btnLabel = btnLabel
        )

        binding.rvTagihan.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTagihan.adapter = adapter

        binding.btnCek.setOnClickListener {
            val nomor = binding.etNomorLayanan.text?.toString()?.trim().orEmpty()
            if (nomor.isEmpty()) {
                Toast.makeText(requireContext(), "Masukkan nomor layanan", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            viewModel.cekTagihan(nomor) { pelanggan, tagihanList ->
                if (!isAdded) return@cekTagihan
                if (pelanggan == null) {
                    binding.layoutHasil.visibility = View.GONE
                    binding.layoutTidakDitemukan.visibility = View.VISIBLE
                } else {
                    pelangganAktif = pelanggan
                    binding.layoutTidakDitemukan.visibility = View.GONE
                    binding.layoutHasil.visibility = View.VISIBLE
                    binding.tvNamaPelanggan.text = pelanggan.nama
                    binding.tvPaketPelanggan.text =
                        "Paket ${pelanggan.paket} • Status: ${pelanggan.statusLayanan}"

                    val filtered = if (mode == "konfirmasi") {
                        tagihanList.filter { it.status == "Belum Bayar" }
                    } else {
                        tagihanList
                    }

                    if (mode == "konfirmasi" && filtered.isEmpty()) {
                        binding.tvLabelTagihan.text = "✅ Tidak ada tagihan yang perlu dibayar"
                        binding.tvLabelTagihan.setTextColor(
                            resources.getColor(R.color.status_active, null)
                        )
                    } else {
                        binding.tvLabelTagihan.setTextColor(
                            resources.getColor(R.color.text_primary, null)
                        )
                        binding.tvLabelTagihan.text =
                            if (mode == "konfirmasi") "Pilih tagihan yang akan dikonfirmasi:"
                            else "Daftar Tagihan"
                    }
                    adapter.submitList(filtered)
                }
            }
        }
    }

    private fun setupModeUI() {
        if (mode == "konfirmasi") {
            binding.layoutModeBanner.visibility = View.VISIBLE
            binding.tvModeTitle.text = "Konfirmasi Pembayaran"
            binding.tvModeSubtitle.text =
                "Masukkan nomor layanan, lalu pilih tagihan yang ingin dikonfirmasi"
            binding.tvCardTitle.text = "Cari Tagihan Anda"
            binding.tvCardSubtitle.text =
                "Masukkan nomor layanan untuk menemukan tagihan yang belum dibayar"
            binding.btnCek.text = "Cari Tagihan"
        } else {
            binding.layoutModeBanner.visibility = View.GONE
            binding.tvCardTitle.text = "Cek Tagihan"
            binding.tvCardSubtitle.text = "Masukkan nomor layanan Anda, tanpa perlu login"
            binding.btnCek.text = "Cek Tagihan"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}