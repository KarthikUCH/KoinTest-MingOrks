package com.example.kointutorial.mindorks.data.repository

import com.example.kointutorial.mindorks.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}