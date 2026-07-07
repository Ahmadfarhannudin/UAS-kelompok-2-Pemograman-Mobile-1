package com.ispmanagement.app.ui.customer

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.datepicker.MaterialDatePicker
import com.ispmanagement.app.databinding.FragmentKonfirmasiPembayaranBinding
import com.ispmanagement.app.viewmodel.AppViewModel
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class KonfirmasiPembayaranFragment : Fragment() {

    private var _binding: FragmentKonfirmasiPembayaranBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModels(ownerProducer = { requireActivity() })

    private var tagihanId: Long = 0
    private var pelangganId: Long = 0
    private var savedPhotoPath: String? = null

    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            binding.ivBukti.visibility = View.VISIBLE
            Glide.with(this).load(it).centerCrop().into(binding.ivBukti)
            savedPhotoPath = copyImageToInternalStorage(it)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentKonfirmasiPembayaranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tagihanId = arguments?.getLong("tagihanId") ?: 0L
        pelangganId = arguments?.getLong("pelangganId") ?: 0L
        binding.tvInfoTagihan.text = "Nomor Layanan: ${arguments?.getString("nomorLayanan")}"

        // 1. TANGGAL OTOMATIS TERISI (Sesuai tanggal hari ini: 2026-07-05)
        val fmt = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val tanggalHariIni = fmt.format(Date())
        binding.etTanggalBayar.setText(tanggalHariIni)

        // Date Picker Modern (Jika user ingin mengganti tanggal)
        binding.etTanggalBayar.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().setTitleText("Pilih Tanggal").build()
            datePicker.addOnPositiveButtonClickListener { selection ->
                binding.etTanggalBayar.setText(fmt.format(Date(selection)))
            }
            datePicker.show(parentFragmentManager, "DATE_PICKER")
        }

        // 2. SETUP DROPDOWN CARA PEMBAYARAN (Lebih Profesional)
        val opsiCaraBayar = listOf(
            "Transfer Bank BCA",
            "Transfer Bank Mandiri",
            "Transfer Bank BNI",
            "Transfer Bank BRI",
            "OVO / DANA / GoPay"
        )
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, opsiCaraBayar)
        binding.spinnerCaraBayar.setAdapter(adapter)

        // Set pilihan pertama secara default
        binding.spinnerCaraBayar.setText(opsiCaraBayar[0], false)

        // 3. FUNGSI FOTO DAN KIRIM
        binding.btnPilihFoto.setOnClickListener { pickImageLauncher.launch("image/*") }

        binding.btnKirim.setOnClickListener {
            val tanggal = binding.etTanggalBayar.text.toString()
            val caraBayar = binding.spinnerCaraBayar.text.toString()

            if (tanggal.isEmpty() || caraBayar.isEmpty() || savedPhotoPath == null) {
                Toast.makeText(requireContext(), "Lengkapi semua data dan foto bukti", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.kirimKonfirmasi(tagihanId, pelangganId, tanggal, caraBayar, savedPhotoPath!!) {
                Toast.makeText(requireContext(), "Konfirmasi terkirim!", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            }
        }
    }

    private fun copyImageToInternalStorage(uri: Uri): String? {
        return try {
            val file = File(requireContext().filesDir, "bukti_${System.currentTimeMillis()}.jpg")
            requireContext().contentResolver.openInputStream(uri)?.use { input ->
                FileOutputStream(file).use { output -> input.copyTo(output) }
            }
            file.absolutePath
        } catch (e: Exception) { null }
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}