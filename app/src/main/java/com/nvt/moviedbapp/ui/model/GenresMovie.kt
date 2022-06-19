package com.nvt.moviedbapp.ui.model


import com.google.gson.annotations.SerializedName

class GenresMovie(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<GenreMvDetail>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)