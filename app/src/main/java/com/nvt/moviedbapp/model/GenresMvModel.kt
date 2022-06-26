package com.nvt.moviedbapp.model


import com.google.gson.annotations.SerializedName

class GenresMvModel(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<GenreMvModelDetail>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)