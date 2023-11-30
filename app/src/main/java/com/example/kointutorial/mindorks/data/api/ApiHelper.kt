package com.example.kointutorial.mindorks.data.api

import com.example.kointutorial.mindorks.data.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<List<User>>
}