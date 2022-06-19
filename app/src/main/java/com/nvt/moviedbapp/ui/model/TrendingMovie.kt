package com.nvt.moviedbapp.ui.model


import com.google.gson.annotations.SerializedName

data class TrendingMovie(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<TrendingMovieDetail>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)