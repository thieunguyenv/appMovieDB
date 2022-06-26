package com.nvt.moviedbapp.service


import com.nvt.moviedbapp.model.GenresModel
import com.nvt.moviedbapp.model.MovieModel
import com.nvt.moviedbapp.model.TrendingMvModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApIService {

    //get Trending : day - media_type : all
    @GET("trending/all/day")
    fun getAllTrendingByDay() : Single<TrendingMvModel>

    @GET("genre/movie/list")
    fun getALlGenre() : Single<GenresModel>

    //get all movie
    @GET("discover/movie")
    fun getAMovie() : Single<MovieModel>

    //get movie type with genre_id
    @GET("discover/movie")
    fun getMvTypeWGenreID(@Query("with_genres") id : Int) : Single<MovieModel>


}