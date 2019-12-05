package com.surelabs.pariwisataternate.ui.galeri
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.surelabs.pariwisataternate.R
import kotlinx.android.synthetic.main.item_adapter_galeri.view.*

class AdapterGaleri(private val list: List<String>) :
    RecyclerView.Adapter<AdapterGaleri.ViewHolder>() {
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.context = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_adapter_galeri,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(list.get(position)).into(holder.imageViewGallery)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewGallery = itemView.imageViewGaleri
    }

}