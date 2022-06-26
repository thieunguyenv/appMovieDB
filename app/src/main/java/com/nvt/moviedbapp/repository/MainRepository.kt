package com.nvt.moviedbapp.repository

import com.nvt.moviedbapp.model.GenresModel
import com.nvt.moviedbapp.model.MovieModel
import com.nvt.moviedbapp.model.TrendingMvModel
import com.nvt.moviedbapp.service.MovieService
import io.reactivex.Single


object MainRepository : IRepository {

    override fun getATrendingMv(): Single<TrendingMvModel> {
        return MovieService.providerMvDB().getAllTrendingByDay()
    }

    override fun getAGenres(): Single<GenresModel> {
        return MovieService.providerMvDB().getALlGenre()
    }

    override fun getAMovie(): Single<MovieModel> {
        return MovieService.providerMvDB().getAMovie()
    }


    override fun getMvWithGenresID(id: Int): Single<MovieModel> {
        return MovieService.providerMvDB().getMvTypeWGenreID(id)
    }


}