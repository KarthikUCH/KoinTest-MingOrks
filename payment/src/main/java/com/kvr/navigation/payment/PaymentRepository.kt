package com.kvr.navigation.payment

class PaymentRepository(private val paymentService: PaymentService) {

    var payments = emptyList<String>()

    fun getPaymentList(): List<String> {
        return payments.ifEmpty { paymentService.getPaymentList() }
    }
}