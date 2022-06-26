package com.nvt.moviedbapp.service


import com.nvt.moviedbapp.model.GenresMvModel
import com.nvt.moviedbapp.model.MoviesModel
import com.nvt.moviedbapp.model.TrendingMvModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApIService {

    //get Trending : day - media_type : all
    @GET("trending/all/day")
    fun getAllTrendingByDay() : Single<TrendingMvModel>

    @GET("/genre/movie/list")
    fun getALlGenre() : Single<GenresMvModel>

    //get movie type with genre_id
    @GET("/discover/movie")
    fun getMvTypeWGenreID(@Query("genre_ids") id : Int) : Single<MoviesModel>

}