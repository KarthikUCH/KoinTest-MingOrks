package com.kvr.navigation.payment.di

import com.kvr.navigation.payment.PaymentRepository
import com.kvr.navigation.payment.PaymentService
import org.koin.core.qualifier.named
import org.koin.dsl.module

val paymentModule = module {
    scope(named("PaymentScope")) {
        scoped { PaymentService() }
        scoped { PaymentRepository(get()) }
    }
}