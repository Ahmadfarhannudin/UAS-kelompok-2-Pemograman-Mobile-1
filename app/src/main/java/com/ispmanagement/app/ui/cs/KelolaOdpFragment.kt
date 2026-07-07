package com.ispmanagement.app.ui.cs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.ispmanagement.app.data.Odp
import com.ispmanagement.app.databinding.FragmentKelolaOdpBinding
import com.ispmanagement.app.ui.adapters.OdpAdapter
import com.ispmanagement.app.viewmodel.AppViewModel

class KelolaOdpFragment : Fragment() {

    private var _binding: FragmentKelolaOdpBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModels(ownerProducer = { requireActivity() })
    private lateinit var adapter: OdpAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKelolaOdpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = OdpAdapter(emptyList()) { odp ->
            AlertDialog.Builder(requireContext())
                .setTitle("Hapus ODP")
                .setMessage("Hapus data ODP ${odp.namaOdp}?")
                .setPositiveButton("Hapus") { _, _ ->
                    viewModel.hapusOdp(odp) {
                        if (!isAdded) return@hapusOdp
                        Toast.makeText(requireContext(), "ODP dihapus", Toast.LENGTH_SHORT).show()
                    }
                }
                .setNegativeButton("Batal", null)
                .show()
        }
        binding.rvOdp.layoutManager = LinearLayoutManager(requireContext())
        binding.rvOdp.adapter = adapter

        viewModel.semuaOdp.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
            binding.tvEmptyOdp.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
        }

        binding.fabTambahOdp.setOnClickListener { tampilkanDialogTambahOdp() }
    }

    private fun tampilkanDialogTambahOdp() {
        val dialogView = LayoutInflater.from(requireContext())
            .inflate(android.R.layout.simple_list_item_1, null)

        // Buat form secara programmatic agar tidak memerlukan layout terpisah
        val container = android.widget.LinearLayout(requireContext()).apply {
            orientation = android.widget.LinearLayout.VERTICAL
            setPadding(52, 24, 52, 0)
        }

        fun buatInput(hint: String, tipeInput: Int = android.text.InputType.TYPE_CLASS_TEXT): TextInputEditText {
            val til = TextInputLayout(requireContext(), null,
                com.google.android.material.R.attr.textInputOutlinedStyle).apply {
                this.hint = hint
                layoutParams = android.widget.LinearLayout.LayoutParams(
                    android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                    android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
                ).also { it.bottomMargin = 16 }
                boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_OUTLINE
                setBoxCornerRadii(10f, 10f, 10f, 10f)
            }
            val et = TextInputEditText(til.context).apply {
                inputType = tipeInput
                layoutParams = android.widget.LinearLayout.LayoutParams(
                    android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                    android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
                )
            }
            til.addView(et)
            container.addView(til)
            return et
        }

        val etNama      = buatInput("Nama ODP (cth: ODP-BDG-001)")
        val etAlamat    = buatInput("Alamat ODP")
        val etLat       = buatInput("Latitude", android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL or android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_SIGNED)
        val etLng       = buatInput("Longitude", android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL or android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_SIGNED)
        val etTotal     = buatInput("Total Port", android.text.InputType.TYPE_CLASS_NUMBER)
        val etTerpakai  = buatInput("Port Terpakai", android.text.InputType.TYPE_CLASS_NUMBER)

        AlertDialog.Builder(requireContext())
            .setTitle("Tambah Data ODP")
            .setView(container)
            .setPositiveButton("Simpan") { _, _ ->
                val nama      = etNama.text?.toString()?.trim().orEmpty()
                val alamat    = etAlamat.text?.toString()?.trim().orEmpty()
                val lat       = etLat.text?.toString()?.toDoubleOrNull() ?: 0.0
                val lng       = etLng.text?.toString()?.toDoubleOrNull() ?: 0.0
                val total     = etTotal.text?.toString()?.toIntOrNull() ?: 0
                val terpakai  = etTerpakai.text?.toString()?.toIntOrNull() ?: 0

                if (nama.isEmpty() || alamat.isEmpty()) {
                    Toast.makeText(requireContext(), "Nama dan alamat wajib diisi", Toast.LENGTH_SHORT).show()
                    return@setPositiveButton
                }

                viewModel.tambahOdp(
                    Odp(
                        namaOdp      = nama,
                        alamat       = alamat,
                        latitude     = lat,
                        longitude    = lng,
                        totalPort    = total,
                        portTerpakai = terpakai
                    )
                ) {
                    if (!isAdded) return@tambahOdp
                    Toast.makeText(requireContext(), "ODP $nama berhasil ditambahkan", Toast.LENGTH_SHORT).show()
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
