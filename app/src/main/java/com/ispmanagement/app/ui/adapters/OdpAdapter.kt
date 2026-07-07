package com.ispmanagement.app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ispmanagement.app.data.Odp
import com.ispmanagement.app.databinding.ItemOdpBinding

class OdpAdapter(
    private var items: List<Odp>,
    private val onHapus: (Odp) -> Unit
) : RecyclerView.Adapter<OdpAdapter.VH>() {

    fun submitList(newItems: List<Odp>) {
        items = newItems
        notifyDataSetChanged()
    }

    inner class VH(val binding: ItemOdpBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val b = ItemOdpBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(b)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val o = items[position]
        holder.binding.tvNamaOdp.text = o.namaOdp
        holder.binding.tvAlamatOdp.text = o.alamat
        holder.binding.tvPortTotal.text = o.totalPort.toString()
        holder.binding.tvPortTerpakai.text = o.portTerpakai.toString()
        holder.binding.tvPortSisa.text = (o.totalPort - o.portTerpakai).toString()
        holder.binding.tvKoordinatOdp.text =
            "Koordinat: ${o.latitude}, ${o.longitude}"
        holder.binding.btnHapusOdp.setOnClickListener { onHapus(o) }
    }

    override fun getItemCount() = items.size
}
