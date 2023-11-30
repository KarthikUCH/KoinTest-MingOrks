package com.example.kointutorial.mindorks

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
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModel()

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
                    }
                }
            }

        }
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