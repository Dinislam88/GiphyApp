package com.example.giphyapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.giphyapp.R
import com.example.giphyapp.data.Data
import com.example.giphyapp.data.DataX
import com.example.giphyapp.view.MainActivity
import com.squareup.picasso.Picasso

class CustomAdapter(private val mList: List<Data?>,
                    val mItemClickListener: ItemClickListener
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    interface ItemClickListener{
        fun onItemClick(position: List<DataX>)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(this)
            .load("https://media.giphy.com/media/" +mList[position]?.data)  // Call your GIF here (url, raw, etc.)
            .into(holder.imageView)
    }


    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        init {
            ItemView.setOnClickListener {
                mList[position]?.data?.let { it -> mItemClickListener.onItemClick(it) }
            }
        }
    }
}