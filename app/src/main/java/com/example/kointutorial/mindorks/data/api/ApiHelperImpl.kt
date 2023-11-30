package com.example.kointutorial.mindorks.data.api

import com.example.kointutorial.mindorks.data.model.User
import retrofit2.Response

class ApiHelperImpl(private val apiService: ApiService): ApiHelper {
    override suspend fun getUsers(): Response<List<User>> {
        return apiService.getUsers()
    }
}