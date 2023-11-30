package com.example.kointutorial.mindorks.di.module

import com.example.kointutorial.mindorks.data.api.ApiHelper
import com.example.kointutorial.mindorks.data.api.ApiHelperImpl
import com.example.kointutorial.mindorks.data.repository.MainRepository
import org.koin.dsl.module


val repoModule = module {
    single {
        MainRepository(get())
    }

    single<ApiHelper> {
        return@single ApiHelperImpl(get())
    }
}
