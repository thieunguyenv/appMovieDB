package com.nvt.moviedbapp.model


import com.google.gson.annotations.SerializedName

data class TrendingMvModel(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<TrendingMvModelDetail>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)