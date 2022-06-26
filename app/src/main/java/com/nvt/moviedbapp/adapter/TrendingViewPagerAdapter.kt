package com.nvt.moviedbapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nvt.moviedbapp.databinding.ItemViewPagerTrendingBinding
import com.nvt.moviedbapp.model.TrendingMvModelDetail


class TrendingViewPagerAdapter : RecyclerView.Adapter<TrendingViewPagerAdapter.TravelLocationViewHolder> {

    private lateinit var travellocation: List<TrendingMvModelDetail>
    private lateinit var context: Context

    constructor(context: Context, travelLocation: List<TrendingMvModelDetail>) {
        this.context = context
        this.travellocation = travelLocation
    }

    fun setData(travelLocation: List<TrendingMvModelDetail>){
        this.travellocation = travelLocation
        notifyDataSetChanged()
    }
    inner class TravelLocationViewHolder(private val itemBinding:ItemViewPagerTrendingBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun setLocationData(travelLocation: TrendingMvModelDetail) {
            Glide.with(itemView).load("https://image.tmdb.org/t/p/w500"+travelLocation.poster_path).into(itemBinding.imgViewPager)
            itemBinding.txtNameMvVpager.text = travelLocation.title
            if (travelLocation.originalTitle == null){
                itemBinding.txtNameMvVpager.text = travelLocation.name
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelLocationViewHolder {
        val itemView =
           ItemViewPagerTrendingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TravelLocationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TravelLocationViewHolder, position: Int) {
        holder.setLocationData(travellocation[position])
    }

    override fun getItemCount(): Int {
        return travellocation.size
    }
}