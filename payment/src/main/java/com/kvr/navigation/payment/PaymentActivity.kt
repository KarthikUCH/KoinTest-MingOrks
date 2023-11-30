package com.kvr.navigation.payment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kvr.navigation.payment.ui.theme.KoinTutorialMindOrksTheme
import org.koin.android.ext.android.getKoin
import org.koin.core.qualifier.named

class PaymentActivity : ComponentActivity() {

    val paymentQualifiedScope = getKoin().getOrCreateScope("PaymentScopeId", named("PaymentScope"))

    val paymentRepository: PaymentRepository by paymentQualifiedScope.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinTutorialMindOrksTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(paymentRepository.getPaymentList())
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        paymentQualifiedScope.close()
    }
}

@Composable
fun Greeting(paymentList: List<String>, modifier: Modifier = Modifier) {

    LazyColumn() {
        items(paymentList) {
            Text(
                text = "Hello $it!",
                modifier = modifier
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KoinTutorialMindOrksTheme {
        Greeting(listOf("Payment 1", "Payment 2", "Payment 3"))
    }
}