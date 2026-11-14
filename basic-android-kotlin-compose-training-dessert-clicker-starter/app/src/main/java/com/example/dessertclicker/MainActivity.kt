package com.example.dessertclicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    DessertClickerApp()
                }
            }
        }
    }
}

@Composable
fun DessertClickerApp(viewModel: DessertViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    val imageId = when (uiState.currentDessertIndex) {
        0 -> R.drawable.cupcake
        1 -> R.drawable.donut
        2 -> R.drawable.eclair
        3 -> R.drawable.froyo
        else -> R.drawable.gingerbread
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Sold: ${uiState.dessertsSold}", fontSize = 20.sp)
        Text(text = "$${uiState.revenue}", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(32.dp))

        IconButton(onClick = { viewModel.onDessertClicked() }) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "Dessert",
                modifier = Modifier.size(200.dp)
            )
        }
    }
}
