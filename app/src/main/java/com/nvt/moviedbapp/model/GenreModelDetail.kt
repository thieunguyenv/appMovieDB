package com.nvt.moviedbapp.model


import com.google.gson.annotations.SerializedName

data class GenreModelDetail(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)