package com.nvt.moviedbapp.repository

import com.nvt.moviedbapp.model.GenresModel
import com.nvt.moviedbapp.model.MovieModel
import com.nvt.moviedbapp.model.TrendingMvModel
import io.reactivex.Single

interface IRepository {

    fun getATrendingMv() : Single<TrendingMvModel>

    fun getAGenres() : Single<GenresModel>

    fun getAMovie() : Single<MovieModel>

    fun getMvWithGenresID(id : Int): Single<MovieModel>
}