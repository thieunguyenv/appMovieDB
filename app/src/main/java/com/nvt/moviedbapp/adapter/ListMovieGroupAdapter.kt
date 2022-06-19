package com.nvt.moviedbapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nvt.moviedbapp.databinding.CustomLayoutGroupListMvBinding
import com.nvt.moviedbapp.ui.model.AllListMovieDetail


class ListMovieGroupAdapter : RecyclerView.Adapter<ListMovieGroupAdapter.MyViewHolder> {
    private lateinit var listMovieDetail: List<AllListMovieDetail>
    private lateinit var context: Context

    constructor(context: Context, listMovieDetail: List<AllListMovieDetail>) {
        this.context = context
        this.listMovieDetail = listMovieDetail
    }

    inner class MyViewHolder(
        private val itemBinding: CustomLayoutGroupListMvBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        val itemView = itemBinding
        fun setLocationData(allListMovieDetail: AllListMovieDetail) {
            itemBinding.txtNamAction.text = allListMovieDetail.title        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            CustomLayoutGroupListMvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setLocationData(listMovieDetail.get(position))
    }

    override fun getItemCount(): Int {
        return listMovieDetail.size
    }
}