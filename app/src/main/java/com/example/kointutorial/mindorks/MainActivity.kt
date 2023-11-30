package com.example.kointutorial.mindorks

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kointutorial.mindorks.ui.theme.KoinTutorialMindOrksTheme
import com.kvr.navigation.payment.PaymentActivity
import com.kvr.navigation.payment.PaymentRepository
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class MainActivity : ComponentActivity() {

    val paymentQualifiedScope = getKoin().getOrCreateScope("PaymentScopeId", named("PaymentScope"))

    private val mainViewModel: MainViewModel by viewModel()

    private val paymentRepository: PaymentRepository by paymentQualifiedScope.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinTutorialMindOrksTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    DisplayUser(mainViewModel = mainViewModel) {
                        val intent = Intent(this, PaymentActivity::class.java)
                        startActivity(intent)
                        paymentQualifiedScope.close()
                    }
                }
            }

        }
    }

    override fun onResume() {
        super.onResume()
        paymentRepository.payments = listOf("Main NETS", "Main VISA", "Main CASH")
        println(paymentRepository.getPaymentList())
    }
}

@Composable
fun DisplayUser(mainViewModel: MainViewModel, onItemClick: () -> Unit) {
    LazyColumn(modifier = Modifier.padding(all = 16.dp)) {
        items(items = mainViewModel.users) { user ->
            Text(text = user.name, modifier = Modifier
                .padding(bottom = 8.dp)
                .clickable {
                    onItemClick()
                })

            Spacer(modifier = Modifier.background(color = Color.Black))
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KoinTutorialMindOrksTheme {
        Greeting("Android")
    }
}