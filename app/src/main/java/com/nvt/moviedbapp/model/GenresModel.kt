package com.nvt.moviedbapp.model


import com.google.gson.annotations.SerializedName

data class GenresModel(
    @SerializedName("genres")
    val genres: List<GenreModelDetail>
)