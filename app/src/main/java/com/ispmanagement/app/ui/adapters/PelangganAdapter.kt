package com.ispmanagement.app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ispmanagement.app.R
import com.ispmanagement.app.data.Pelanggan
import com.ispmanagement.app.databinding.ItemPelangganBinding

class PelangganAdapter(
    private var items: List<Pelanggan>,
    private val onToggleIsolir: (Pelanggan) -> Unit
) : RecyclerView.Adapter<PelangganAdapter.VH>() {

    fun submitList(newItems: List<Pelanggan>) {
        items = newItems
        notifyDataSetChanged()
    }

    inner class VH(val binding: ItemPelangganBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val b = ItemPelangganBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(b)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val p = items[position]
        val ctx = holder.itemView.context

        holder.binding.tvNamaPelangganItem.text = p.nama
        holder.binding.tvNomorLayananItem.text = p.nomorLayanan
        holder.binding.tvPaketItem.text = "Paket ${p.paket}"
        holder.binding.tvHpItem.text = p.noHp
        holder.binding.tvStatusPelangganItem.text = p.statusLayanan

        val statusColor = if (p.statusLayanan == "Aktif") R.color.status_active else R.color.status_isolir
        holder.binding.tvStatusPelangganItem.background
            .setTint(ContextCompat.getColor(ctx, statusColor))

        holder.binding.btnToggleIsolir.text = if (p.statusLayanan == "Aktif") "Set Isolir" else "Aktifkan"
        holder.binding.btnToggleIsolir.setOnClickListener { onToggleIsolir(p) }
    }

    override fun getItemCount() = items.size
}
