package com.example.flixsterplus

import com.google.gson.annotations.SerializedName

class Movie {
    @SerializedName("title")
    var title:String? = null

    @SerializedName("poster_path")
    var image:String? = null

    @SerializedName("overview")
    var description:String? = null
}