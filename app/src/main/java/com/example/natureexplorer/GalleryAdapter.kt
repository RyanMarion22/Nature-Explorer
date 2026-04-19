package com.example.natureexplorer

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class GalleryAdapter(
    private val titles: List<String>,
    private val descs: List<String>,
    private val images: List<Int>,
    private val context: android.content.Context
) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.cardImage)
        val title: TextView = itemView.findViewById(R.id.cardTitle)
        val desc: TextView = itemView.findViewById(R.id.cardDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = titles.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = titles[position]
        holder.desc.text = descs[position]
        holder.img.setImageResource(images[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("title", titles[position])
            intent.putExtra("desc", descs[position])
            intent.putExtra("image", images[position])
            context.startActivity(intent)
        }
    }
}