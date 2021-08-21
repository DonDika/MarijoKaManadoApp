package com.example.marijokamanado.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.marijokamanado.view.DetailWisataActivity
import com.example.marijokamanado.R
import com.example.marijokamanado.model.Wisata

class ListWisataAdapter (val listWisata: ArrayList<Wisata>) : RecyclerView.Adapter<ListWisataAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_card_wisata, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listWisata.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, intro, photo, overview) = this.listWisata[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvIntro.text = intro

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailWisataActivity::class.java)
            moveDetail.putExtra(DetailWisataActivity.EXTRA_INTRO, intro)
            moveDetail.putExtra(DetailWisataActivity.EXTRA_NAME, name)
            moveDetail.putExtra(DetailWisataActivity.EXTRA_PHOTO, photo)
            moveDetail.putExtra(DetailWisataActivity.EXTRA_OVERVIEW, overview)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvIntro: TextView = itemView.findViewById(R.id.tv_item_intro)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}