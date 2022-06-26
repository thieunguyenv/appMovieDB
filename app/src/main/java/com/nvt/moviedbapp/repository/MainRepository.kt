package com.nvt.moviedbapp.repository

import com.nvt.moviedbapp.model.GenresMvModel
import com.nvt.moviedbapp.model.MoviesModel
import com.nvt.moviedbapp.model.TrendingMvModel
import com.nvt.moviedbapp.service.MovieService
import io.reactivex.Single


object MainRepository: IRepository{

        override fun getATrendingMv(): Single<TrendingMvModel> {
        return MovieService.providerMvDB().getAllTrendingByDay()
    }

    override fun getAGenres(): Single<GenresMvModel> {
        return MovieService.providerMvDB().getALlGenre()
    }

    override fun getMvWithGenresID(id: Int): Single<MoviesModel> {
        return MovieService.providerMvDB().getMvTypeWGenreID(id)
    }


}