package com.example.catfactapp

class CatRepository(private val service: CatService) {
    suspend fun getCatFact() = service.getCatDetails()
}
