package com.example.hotelautomtionproject.presentation.presentation

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DependencyInjection{

    @Provides
    @Singleton
    fun provideGuestLoginAPI(): APIService {
        return Retrofit.Builder()
            .baseUrl(Config.API_ACCESS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }

}