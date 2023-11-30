package com.example.kointutorial.mindorks

import android.app.Application
import com.example.kointutorial.mindorks.di.module.appModule
import com.example.kointutorial.mindorks.di.module.repoModule
import com.example.kointutorial.mindorks.di.module.viewModelModule
import com.kvr.navigation.payment.di.paymentModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinSampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KoinSampleApp)
            modules(listOf(appModule, repoModule, viewModelModule, paymentModule))
        }
    }
}