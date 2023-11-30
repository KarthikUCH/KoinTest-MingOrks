package com.example.kointutorial.mindorks.di.module

import com.example.kointutorial.mindorks.MainViewModel
import com.example.kointutorial.mindorks.data.api.ApiHelper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        MainViewModel(get(), get())
    }
}
