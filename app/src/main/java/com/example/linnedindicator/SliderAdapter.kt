package com.example.linnedindicator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter

class SlideAdapter(private val items: List<SlideItem>) : RecyclerView.Adapter<SlideAdapter.SlideViewHolder>() {


    inner class SlideViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)
        fun bind(slideItem: SlideItem) {
            imageView.setImageResource(slideItem.image)
            textViewDescription.text = slideItem.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.slider_item, parent, false)
        return SlideViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {
        val slideItem = items[position]
        holder.bind(slideItem)
    }
}