package com.example.hotelautomtionproject.presentation.presentation

import retrofit2.http.*

interface APIService {
    @GET(Config.API_ACCESS_INDEX_URL)
    suspend fun getUserName(
        @Query(Config.API_ACCESS_KEY_USERNAME)
        username:String,
    ): List<User>
}