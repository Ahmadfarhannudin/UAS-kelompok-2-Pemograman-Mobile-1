package com.ispmanagement.app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ispmanagement.app.R
import com.ispmanagement.app.data.TiketKomplain
import com.ispmanagement.app.databinding.ItemKomplainBinding

class KomplainAdapter(
    private var items: List<TiketKomplain>,
    private val onClick: (TiketKomplain) -> Unit
) : RecyclerView.Adapter<KomplainAdapter.VH>() {

    fun submitList(newItems: List<TiketKomplain>) {
        items = newItems
        notifyDataSetChanged()
    }

    inner class VH(val binding: ItemKomplainBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemKomplainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val t = items[position]
        val ctx = holder.itemView.context
        holder.binding.tvNomorAntrean.text = "Antrean #${t.nomorAntrean}"
        holder.binding.tvJudulKomplain.text = t.judul
        holder.binding.tvTanggalKomplain.text = t.tanggalDibuat
        holder.binding.tvStatusKomplain.text = t.status

        val color = when (t.status) {
            "Selesai" -> R.color.status_done
            "Diproses" -> R.color.status_process
            else -> R.color.status_new
        }
        holder.binding.tvStatusKomplain.background.setTint(ContextCompat.getColor(ctx, color))
        holder.itemView.setOnClickListener { onClick(t) }
    }

    override fun getItemCount() = items.size
}
