package com.example.catfactapp

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CatModule {
    @Provides
    @Singleton
    fun providesMoshi() = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun providesRetrofit(moshi: Moshi) =
        Retrofit.Builder().baseUrl("https://catfact.ninja").addConverterFactory(
            MoshiConverterFactory.create(moshi),
        ).build()

    @Provides
    @Singleton
    fun providesService(retrofit: Retrofit) = retrofit.create(CatService::class.java)
    @Provides
    @Singleton
    fun providesRepository(service: CatService) = CatRepository(service)
}
