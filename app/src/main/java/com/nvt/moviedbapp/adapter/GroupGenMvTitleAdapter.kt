package com.nvt.moviedbapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nvt.moviedbapp.databinding.CustomRvGroupGenreBinding
import com.nvt.moviedbapp.model.MovieModelDetail

class GroupGenMvTitleAdapter(val context: Context,private var
    listMovieGroup: HashMap<String, List<MovieModelDetail>> = HashMap()
) : RecyclerView.Adapter<GroupGenMvTitleAdapter.MyViewHolder>() {

    fun setData(listMoviesGroup : HashMap<String,List<MovieModelDetail>>){
        this.listMovieGroup = listMoviesGroup
        notifyDataSetChanged()
    }

    inner class MyViewHolder(private val itemBinding: CustomRvGroupGenreBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        val viewItem = itemBinding.root
        fun setDataMovieList(title: String, listMovies: List<MovieModelDetail>) {

            itemBinding.txtGenresName.text = title
            Log.d("title",itemBinding.txtGenresName.text.toString())

            //set adapter
            itemBinding.rvListMvOfGenresType.layoutManager =
                LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
            val mvByGenIDAdapter = GroupMvByGenIDAdapter(context,listMovies)
            itemBinding.rvListMvOfGenresType.adapter = mvByGenIDAdapter

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            CustomRvGroupGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val title = listMovieGroup.keys.elementAt(position)
        Log.d("title",title.toString())
        holder.setDataMovieList(title,listMovieGroup.get(title)?: arrayListOf())
    }

    override fun getItemCount(): Int {
        return listMovieGroup.size
    }

}