package com.ispmanagement.app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ispmanagement.app.R
import com.ispmanagement.app.data.Tagihan
import com.ispmanagement.app.databinding.ItemTagihanBinding
import java.text.NumberFormat
import java.util.Locale

class TagihanAdapter(
    private var items: List<Tagihan>,
    private val onBayarClick: (Tagihan) -> Unit,
    private val btnLabel: String = "Konfirmasi Pembayaran"
) : RecyclerView.Adapter<TagihanAdapter.VH>() {

    fun submitList(newItems: List<Tagihan>) {
        items = newItems
        notifyDataSetChanged()
    }

    inner class VH(val binding: ItemTagihanBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemTagihanBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val t = items[position]
        val ctx = holder.itemView.context
        val rupiah = NumberFormat.getNumberInstance(Locale("in", "ID")).format(t.jumlah)

        holder.binding.tvPeriode.text = t.periode
        holder.binding.tvJumlah.text = "Rp $rupiah"
        holder.binding.tvJatuhTempo.text = "Jatuh tempo: ${t.jatuhTempo}"
        holder.binding.tvStatus.text = t.status

        val color = when (t.status) {
            "Paid"      -> R.color.status_paid
            "Pending"   -> R.color.status_pending
            else        -> R.color.status_unpaid
        }
        holder.binding.tvStatus.background
            .setTint(ContextCompat.getColor(ctx, color))

        // Tombol hanya tampil pada tagihan yang belum dibayar
        if (t.status == "Belum Bayar") {
            holder.binding.btnBayar.visibility = View.VISIBLE
            holder.binding.btnBayar.text = btnLabel
            holder.binding.btnBayar.setOnClickListener { onBayarClick(t) }
        } else {
            holder.binding.btnBayar.visibility = View.GONE
        }
    }

    override fun getItemCount() = items.size
}