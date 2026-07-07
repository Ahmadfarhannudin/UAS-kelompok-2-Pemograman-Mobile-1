package com.ispmanagement.app.ui.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ispmanagement.app.R
import com.ispmanagement.app.data.TiketKomplain
import com.ispmanagement.app.databinding.FragmentDetailKomplainBinding
import com.ispmanagement.app.viewmodel.AppViewModel
import kotlinx.coroutines.launch

class DetailKomplainFragment : Fragment() {

    private var _binding: FragmentDetailKomplainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModels(ownerProducer = { requireActivity() })
    private var tiketSaatIni: TiketKomplain? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailKomplainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tiketId = arguments?.getLong("tiketId") ?: 0L
        val isCs    = arguments?.getBoolean("isCs") ?: false

        binding.cardBalasCs.visibility = if (isCs) View.VISIBLE else View.GONE

        loadTiket(tiketId)

        binding.btnProses.setOnClickListener { simpanBalasan("Diproses") }
        binding.btnSelesai.setOnClickListener { simpanBalasan("Selesai") }
    }

    private fun loadTiket(tiketId: Long) {
        lifecycleScope.launch {
            val tiket = viewModel.getTiketByIdSuspend(tiketId)
            if (!isAdded || tiket == null) return@launch
            tiketSaatIni = tiket
            tampilkanTiket(tiket)
        }
    }

    private fun tampilkanTiket(t: TiketKomplain) {
        binding.tvNomorAntreanDetail.text = "Antrean #${t.nomorAntrean}"
        binding.tvJudulDetail.text        = t.judul
        binding.tvTanggalDetail.text      = t.tanggalDibuat
        binding.tvDeskripsiDetail.text    = t.deskripsi
        binding.tvStatusDetail.text       = t.status

        val color = when (t.status) {
            "Selesai"   -> R.color.status_done
            "Diproses"  -> R.color.status_process
            else        -> R.color.status_new
        }
        binding.tvStatusDetail.background
            .setTint(ContextCompat.getColor(requireContext(), color))

        if (t.balasanCS.isNotBlank()) {
            binding.layoutBalasanCS.visibility = View.VISIBLE
            binding.tvBalasanCS.text           = t.balasanCS
            binding.etBalasan.setText(t.balasanCS)
        } else {
            binding.layoutBalasanCS.visibility = View.GONE
        }
    }

    private fun simpanBalasan(statusBaru: String) {
        val tiket   = tiketSaatIni ?: return
        val balasan = binding.etBalasan.text?.toString()?.trim().orEmpty()
        if (balasan.isEmpty()) {
            Toast.makeText(requireContext(), "Tulis balasan terlebih dahulu", Toast.LENGTH_SHORT).show()
            return
        }
        viewModel.balasTiket(tiket, balasan, statusBaru) {
            if (!isAdded) return@balasTiket
            Toast.makeText(requireContext(),
                "Tiket diperbarui menjadi $statusBaru", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
