package com.ispmanagement.app.ui.cs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ispmanagement.app.R
import com.ispmanagement.app.data.Pelanggan
import com.ispmanagement.app.databinding.FragmentKelolaPelangganBinding
import com.ispmanagement.app.ui.adapters.PelangganAdapter
import com.ispmanagement.app.viewmodel.AppViewModel

class KelolaPelangganFragment : Fragment() {

    private var _binding: FragmentKelolaPelangganBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModels(ownerProducer = { requireActivity() })
    private lateinit var adapter: PelangganAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKelolaPelangganBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PelangganAdapter(emptyList()) { pelanggan ->
            konfirmasiToggleIsolir(pelanggan)
        }
        binding.rvPelanggan.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPelanggan.adapter = adapter

        viewModel.semuaPelanggan.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
            binding.tvEmptyPelanggan.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
        }

        binding.fabRegistrasi.setOnClickListener {
            findNavController().navigate(R.id.registrasiPelangganFragment)
        }
    }

    private fun konfirmasiToggleIsolir(p: Pelanggan) {
        val statusBaru = if (p.statusLayanan == "Aktif") "Terisolir" else "Aktif"
        val pesanAksi = if (statusBaru == "Terisolir")
            "Set status pelanggan ${p.nama} menjadi Terisolir?\n(Pemutusan jaringan harus dilakukan manual oleh teknisi.)"
        else
            "Aktifkan kembali layanan pelanggan ${p.nama}?\n(Penyambungan jaringan harus dilakukan manual oleh teknisi.)"

        AlertDialog.Builder(requireContext())
            .setTitle("Ubah Status Pelanggan")
            .setMessage(pesanAksi)
            .setPositiveButton("Ya") { _, _ ->
                viewModel.updatePelangganStatus(p, statusBaru) {
                    if (!isAdded) return@updatePelangganStatus
                    Toast.makeText(
                        requireContext(),
                        "Status ${p.nama} diubah menjadi $statusBaru",
                        Toast.LENGTH_SHORT
                    ).show()
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
