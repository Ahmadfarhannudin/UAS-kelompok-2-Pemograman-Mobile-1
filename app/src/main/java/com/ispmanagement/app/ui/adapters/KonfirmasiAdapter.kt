package com.ispmanagement.app.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ispmanagement.app.R
import com.ispmanagement.app.data.Tagihan
import com.ispmanagement.app.databinding.ItemKonfirmasiPembayaranBinding

class KonfirmasiAdapter(
    private var items: List<Tagihan>,
    private val onTerima: (Tagihan) -> Unit,
    private val onTolak: (Tagihan) -> Unit
) : RecyclerView.Adapter<KonfirmasiAdapter.VH>() {

    fun submitList(newItems: List<Tagihan>) {
        items = newItems
        notifyDataSetChanged()
    }

    inner class VH(val binding: ItemKonfirmasiPembayaranBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val b = ItemKonfirmasiPembayaranBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(b)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val t = items[position]
        val ctx = holder.itemView.context

        holder.binding.tvIdKonfirmasi.text = "Tagihan #${t.id} - ${t.periode}"
        holder.binding.tvCaraBayarKonfirmasi.text = "Rp ${t.jumlah}"
        holder.binding.tvTanggalKonfirmasi.text = "Jatuh Tempo: ${t.jatuhTempo}"
        holder.binding.tvStatusKonfirmasi.text = t.status

        val statusColor = when (t.status) {
            "Paid" -> R.color.status_paid
            "Belum Bayar" -> R.color.status_unpaid
            else -> R.color.status_pending
        }
        holder.binding.tvStatusKonfirmasi.background.setTint(ContextCompat.getColor(ctx, statusColor))

        // Foto Bukti
        if (!t.fotoPath.isNullOrEmpty()) {
            holder.binding.ivBuktiTransfer.visibility = View.VISIBLE
            Glide.with(ctx).load(t.fotoPath).centerCrop().into(holder.binding.ivBuktiTransfer)
        } else {
            holder.binding.ivBuktiTransfer.visibility = View.GONE
        }

        // Tombol Lihat Detail
        holder.binding.btnLihatDetail.setOnClickListener {
            tampilkanDetailDialog(ctx, t)
        }

        // Aksi Awal
        val isPending = t.status == "Pending"
        holder.binding.layoutAksiKonfirmasi.visibility = if (isPending) View.VISIBLE else View.GONE
        holder.binding.btnTerima.setOnClickListener { onTerima(t) }
        holder.binding.btnTolak.setOnClickListener { onTolak(t) }
    }

    private fun tampilkanDetailDialog(context: Context, t: Tagihan) {
        // 1. Asumsikan kita punya cara untuk mengambil data KonfirmasiPembayaran berdasarkan tagihanId
        // Jika tidak punya akses database di sini, data ini HARUS disiapkan saat submitList()
        // Untuk sekarang, kita perbaiki akses datanya:

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_detail_pembayaran, null)
        val ivFoto = dialogView.findViewById<ImageView>(R.id.ivDialogFoto)
        val tvInfo = dialogView.findViewById<TextView>(R.id.tvDialogInfo)

        // Tampilkan data yang tersedia di object Tagihan & data tambahan
        tvInfo.text = "ID Tagihan: ${t.id}\n" +
                "Periode: ${t.periode}\n" +
                "Jumlah: Rp ${t.jumlah}\n" +
                "Status: ${t.status}\n\n" +
                "--- Data Konfirmasi ---\n" +
                "Tanggal Bayar: ${t.tanggalBayar ?: "-"}\n" +
                "Cara Bayar: ${t.caraBayar ?: "-"}"

        // Pastikan fotoPath diakses dari properti yang benar
        if (!t.fotoPath.isNullOrEmpty()) {
            Glide.with(context)
                .load(t.fotoPath)
                .into(ivFoto)
        } else {
            tvInfo.append("\n\n(Tidak ada bukti foto)")
        }

        AlertDialog.Builder(context)
            .setTitle("Detail Konfirmasi")
            .setView(dialogView)
            .setPositiveButton("Tutup", null)
            .show()
    }

    override fun getItemCount() = items.size
}