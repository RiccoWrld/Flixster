package com.example.flixster

import com.google.gson.annotations.SerializedName

class Flixster {
    @JvmField
    @SerializedName("title")
    var title: String? = null

    @JvmField
    @SerializedName("overview")
    var description: String? = null

    @JvmField
    @SerializedName("poster_path")
    var ImageUrl: String? = null
}