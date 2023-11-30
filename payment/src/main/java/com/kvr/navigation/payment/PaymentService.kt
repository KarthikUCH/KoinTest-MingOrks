package com.kvr.navigation.payment

class PaymentService {

    fun getPaymentList(): List<String> {
        return listOf("NETS", "VISA", "CASH")
    }
}