package com.ispmanagement.app.ui.cs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.ispmanagement.app.data.Tagihan
import com.ispmanagement.app.databinding.FragmentKelolaPembayaranBinding
import com.ispmanagement.app.ui.adapters.KonfirmasiAdapter
import com.ispmanagement.app.viewmodel.AppViewModel

class KelolaPembayaranFragment : Fragment() {

    private var _binding: FragmentKelolaPembayaranBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModels(ownerProducer = { requireActivity() })

    private lateinit var adapter: KonfirmasiAdapter
    private var semuaTagihan: List<Tagihan> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKelolaPembayaranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = KonfirmasiAdapter(
            items = emptyList(),
            onTerima = { t -> konfirmasiTerima(t) },
            onTolak  = { t -> konfirmasiTolak(t) }
        )
        binding.rvKonfirmasi.layoutManager = LinearLayoutManager(requireContext())
        binding.rvKonfirmasi.adapter = adapter

        listOf("Semua", "Belum Bayar", "Pending", "Lunas").forEach { label ->
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(label))
        }

        // PERUBAHAN DISINI: Menggunakan tagihanLengkap agar data (foto, tanggal, dll) sudah menyatu
        viewModel.tagihanLengkap.observe(viewLifecycleOwner) { list ->
            semuaTagihan = list
            filterList(binding.tabLayout.selectedTabPosition)
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) { filterList(tab.position) }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun filterList(tabPosition: Int) {
        val filtered = when (tabPosition) {
            1 -> semuaTagihan.filter { it.status == "Belum Bayar" }
            2 -> semuaTagihan.filter { it.status == "Pending" }
            3 -> semuaTagihan.filter { it.status == "Paid" }
            else -> semuaTagihan
        }

        adapter.submitList(filtered)

        binding.tvEmptyKonfirmasi.visibility = if (filtered.isEmpty()) View.VISIBLE else View.GONE
        binding.rvKonfirmasi.visibility = if (filtered.isEmpty()) View.GONE else View.VISIBLE
    }

    private fun konfirmasiTerima(t: Tagihan) {
        AlertDialog.Builder(requireContext())
            .setTitle("Terima Pembayaran")
            .setMessage("Konfirmasi bahwa dana tagihan periode ${t.periode} telah masuk? Status tagihan akan berubah menjadi Paid.")
            .setPositiveButton("Ya, Terima") { _, _ ->
                val updatedTagihan = t.copy(status = "Paid")
                viewModel.updateTagihan(updatedTagihan) {
                    if (!isAdded) return@updateTagihan
                    Toast.makeText(requireContext(), "Pembayaran diterima. Tagihan ditandai Lunas.", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Batal", null)
            .show()
    }

    private fun konfirmasiTolak(t: Tagihan) {
        val etCatatan = EditText(requireContext()).apply {
            hint = "Alasan penolakan (wajib diisi)"
            setPadding(48, 24, 48, 24)
        }
        AlertDialog.Builder(requireContext())
            .setTitle("Tolak Pembayaran")
            .setMessage("Berikan alasan penolakan untuk tagihan ${t.periode}:")
            .setView(etCatatan)
            .setPositiveButton("Tolak") { _, _ ->
                val catatan = etCatatan.text.toString().trim()
                if (catatan.isEmpty()) {
                    Toast.makeText(requireContext(), "Alasan penolakan wajib diisi", Toast.LENGTH_SHORT).show()
                    return@setPositiveButton
                }

                val updatedTagihan = t.copy(status = "Belum Bayar")
                viewModel.updateTagihan(updatedTagihan) {
                    if (!isAdded) return@updateTagihan
                    Toast.makeText(requireContext(), "Pembayaran ditolak. Status kembali Belum Bayar.", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Batal", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}