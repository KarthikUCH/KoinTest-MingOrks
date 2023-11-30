package com.example.kointutorial.mindorks.utils


sealed class Resource(val status: Status) {

    data class Success<T>( val data: T) : Resource(Status.SUCCESS)

    data class Error( val message: String) : Resource(Status.ERROR)

    class Loading() : Resource(Status.LOADING)
}
