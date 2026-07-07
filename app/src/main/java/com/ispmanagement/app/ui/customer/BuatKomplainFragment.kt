package com.ispmanagement.app.ui.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ispmanagement.app.data.TiketKomplain
import com.ispmanagement.app.databinding.FragmentBuatKomplainBinding
import com.ispmanagement.app.viewmodel.AppViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class BuatKomplainFragment : Fragment() {

    private var _binding: FragmentBuatKomplainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModels(ownerProducer = { requireActivity() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuatKomplainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKirimKomplain.setOnClickListener {
            val judul = binding.etJudul.text?.toString()?.trim().orEmpty()
            val deskripsi = binding.etDeskripsi.text?.toString()?.trim().orEmpty()
            if (judul.isEmpty() || deskripsi.isEmpty()) {
                Toast.makeText(requireContext(), "Lengkapi judul dan deskripsi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val pelangganId = viewModel.session.getPelangganId()
            val tanggal = SimpleDateFormat("dd MMM yyyy", Locale("in", "ID")).format(Date())

            lifecycleScope.launch {
                val jumlahSaatIni = viewModel.jumlahTiketSaatIni()
                val nomorAntrean = "A${(jumlahSaatIni + 1).toString().padStart(3, '0')}"

                viewModel.buatTiket(
                    TiketKomplain(
                        nomorAntrean = nomorAntrean,
                        pelangganId = pelangganId,
                        judul = judul,
                        deskripsi = deskripsi,
                        status = "Baru",
                        tanggalDibuat = tanggal
                    )
                ) {
                    if (!isAdded) return@buatTiket
                    Toast.makeText(
                        requireContext(),
                        "Komplain terkirim. Nomor antrean Anda: $nomorAntrean",
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
