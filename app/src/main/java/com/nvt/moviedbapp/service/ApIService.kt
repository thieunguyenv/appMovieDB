package com.nvt.moviedbapp.service


import com.nvt.moviedbapp.ui.model.GenresMovie
import com.nvt.moviedbapp.ui.model.TrendingMovie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApIService {

    //get Trending : day - media_type : all
    @GET("trending/all/day")
    fun getAllTrendingByDay(@Query("api_key") apiKey:String) : Single<List<TrendingMovie>>

    @GET("/genre/movie/list")
    fun getALlGenre(@Query("api_key") apikey:String) : Single<List<GenresMovie>>


}