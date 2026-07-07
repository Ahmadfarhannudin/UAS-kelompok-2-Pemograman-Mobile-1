package com.ispmanagement.app.ui.cs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ispmanagement.app.MainActivity
import com.ispmanagement.app.R
import com.ispmanagement.app.databinding.FragmentCsDashboardBinding
import com.ispmanagement.app.viewmodel.AppViewModel
import java.text.SimpleDateFormat
import java.util.*
import android.graphics.Color
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter

class CsDashboardFragment : Fragment() {

    private var _binding: FragmentCsDashboardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModels(ownerProducer = { requireActivity() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCsDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!viewModel.session.isCsLoggedIn()) {
            findNavController().navigate(R.id.loginCsFragment)
            return
        }

        binding.tvSapaan.text = "Halo, ${viewModel.session.getCsNama()}"

        // Amati perubahan data agar kartu dan grafik selalu up to date
        viewModel.semuaPelanggan.observe(viewLifecycleOwner) { muatRingkasan() }
        viewModel.konfirmasiPending.observe(viewLifecycleOwner) { muatRingkasan() }
        viewModel.semuaTiket.observe(viewLifecycleOwner) { muatRingkasan() }

        binding.btnCekJatuhTempo.setOnClickListener {
            val today = Calendar.getInstance()
            val batas = Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, -30) }
            val fmt = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

            viewModel.cekJatuhTempoBerkala(fmt.format(today.time), fmt.format(batas.time)) {
                if (!isAdded) return@cekJatuhTempoBerkala
                Toast.makeText(
                    requireContext(),
                    "Pengecekan selesai. Status pelanggan & Grafik telah diperbarui.",
                    Toast.LENGTH_LONG
                ).show()
                muatRingkasan() // Segarkan grafik setelah update
            }
        }

        (requireActivity() as MainActivity).refreshDrawerState()
    }

    private fun muatRingkasan() {
        viewModel.hitungRingkasanDashboard { pelanggan, pending, tiket, isolir ->
            if (!isAdded) return@hitungRingkasanDashboard

            // 1. Update Teks Card Atas
            binding.tvJumlahPelanggan.text = pelanggan.toString()
            binding.tvJumlahPending.text = pending.toString()
            binding.tvJumlahTiket.text = tiket.toString()
            binding.tvJumlahIsolir.text = isolir.toString()

            val pelangganLancar = pelanggan - isolir
            binding.tvTotalGrafik.text = "Total: $pelanggan Pelanggan"

            // 2. Siapkan Data untuk Grafik Vertikal
            val entries = ArrayList<BarEntry>()
            entries.add(BarEntry(0f, pelangganLancar.toFloat())) // Index 0: Aktif
            entries.add(BarEntry(1f, pending.toFloat()))         // Index 1: Pending
            entries.add(BarEntry(2f, tiket.toFloat()))           // Index 2: Tiket
            entries.add(BarEntry(3f, isolir.toFloat()))          // Index 3: Isolir

            val dataSet = BarDataSet(entries, "Statistik")

            // Atur warna batang grafik agar profesional (Biru/Ungu ala Startup)
            dataSet.colors = listOf(
                android.graphics.Color.parseColor("#3B82F6"), // Biru Terang (Aktif)
                android.graphics.Color.parseColor("#F59E0B"), // Oranye (Pending)
                android.graphics.Color.parseColor("#8B5CF6"), // Ungu (Tiket)
                android.graphics.Color.parseColor("#EF4444")  // Merah (Isolir)
            )

            dataSet.valueTextColor = android.graphics.Color.parseColor("#374151")
            dataSet.valueTextSize = 12f

            // Hilangkan angka desimal jika nilainya nol
            dataSet.valueFormatter = object : com.github.mikephil.charting.formatter.ValueFormatter() {
                override fun getFormattedValue(value: Float): String {
                    return value.toInt().toString()
                }
            }

            val barData = BarData(dataSet)
            barData.barWidth = 0.5f // Buat batang grafiknya agak kurus agar elegan

            // 3. Konfigurasi Tampilan Grafik (Hapus garis berantakan)
            binding.barChart.apply {
                data = barData
                description.isEnabled = false // Hapus tulisan "Description Label"
                legend.isEnabled = false // Hapus kotak legenda di bawah

                // Atur Sumbu X (Bawah)
                xAxis.position = XAxis.XAxisPosition.BOTTOM
                xAxis.setDrawGridLines(false) // Hapus garis vertikal
                xAxis.valueFormatter = IndexAxisValueFormatter(listOf("Aktif", "Pending", "Tiket", "Isolir"))
                xAxis.granularity = 1f
                xAxis.textColor = android.graphics.Color.parseColor("#6B7280")

                // Atur Sumbu Y (Kiri & Kanan)
                axisRight.isEnabled = false // Matikan angka di kanan
                axisLeft.setDrawGridLines(true) // Biarkan garis horizontal tipis
                axisLeft.gridColor = android.graphics.Color.parseColor("#F3F4F6")
                axisLeft.textColor = android.graphics.Color.parseColor("#6B7280")
                axisLeft.axisMinimum = 0f // Mulai dari 0

                // Mainkan Animasi!
                animateY(1200)
                invalidate() // Refresh grafik
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}