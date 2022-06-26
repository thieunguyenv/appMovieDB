package com.nvt.moviedbapp.repository

import com.nvt.moviedbapp.model.GenresMvModel
import com.nvt.moviedbapp.model.MoviesModel
import com.nvt.moviedbapp.model.TrendingMvModel
import io.reactivex.Single

interface IRepository {

    fun getATrendingMv() : Single<TrendingMvModel>

    fun getAGenres() : Single<GenresMvModel>

    fun getMvWithGenresID(id : Int): Single<MoviesModel>

}