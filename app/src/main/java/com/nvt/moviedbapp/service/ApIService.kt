package com.nvt.moviedbapp.service


import com.nvt.moviedbapp.ui.model.GenreMvDetail
import com.nvt.moviedbapp.ui.model.GenresMovie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApIService {

    @GET("/genre/movie/list")
    fun getALlGenre(@Query("api_key") apikey:String) : Single<List<GenresMovie>>
}