package com.example.catfactapp

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CatResponse(
    val fact: String,
    val length: Int,
)
