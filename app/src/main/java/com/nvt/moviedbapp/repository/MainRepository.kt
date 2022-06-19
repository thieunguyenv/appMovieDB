package com.nvt.moviedbapp.repository

import com.nvt.moviedbapp.service.MovieService
import com.nvt.moviedbapp.utils.Commons

class MainRepository {

    fun getATrending() = MovieService.providerMvDB().getAllTrendingByDay(Commons.API_KEY)
    fun getGenresnname() = MovieService.providerMvDB().getALlGenre(Commons.API_KEY)

}