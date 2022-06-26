package com.nvt.moviedbapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nvt.moviedbapp.databinding.CustomLayoutGroupListMvBinding
import com.nvt.moviedbapp.model.MovieModelDetail

class GroupMvByGenIDAdapter : RecyclerView.Adapter<GroupMvByGenIDAdapter.MyViewHolders> {



    private lateinit var mvByGenresID: List<MovieModelDetail>
    private lateinit var context: Context

    constructor(context: Context, mvByGenreID: List<MovieModelDetail>) {
        this.context = context
        this.mvByGenresID = mvByGenreID
    }

    inner class MyViewHolders(private val itemBinding : CustomLayoutGroupListMvBinding)
        : RecyclerView.ViewHolder(itemBinding.root){

            fun setData(mvByGenreID: MovieModelDetail){
                Glide.with(itemView).load("https://image.tmdb.org/t/p/w500"+mvByGenreID.posterPath)
                    .into(itemBinding.imgActionMv)
                itemBinding.txtNamAction.text = mvByGenreID.title
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolders {
        val itemView = CustomLayoutGroupListMvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolders(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolders, position: Int) {
        holder.setData(mvByGenresID[position])
    }

    override fun getItemCount(): Int {
       return mvByGenresID.size
    }
}