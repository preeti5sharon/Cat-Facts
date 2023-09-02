package com.example.catfactapp

import retrofit2.Response
import retrofit2.http.GET

interface CatService {
    @GET("/fact")
    suspend fun getCatDetails(): Response<CatResponse>
}