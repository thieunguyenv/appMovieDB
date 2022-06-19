package com.nvt.moviedbapp.repository

import com.nvt.moviedbapp.service.MovieService
import com.nvt.moviedbapp.utils.Commons

class MainRepository {
    fun getGenresnname() = MovieService.prividerMvDB().getALlGenre(Commons.API_KEY)
}