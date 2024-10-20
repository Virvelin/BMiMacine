package com.example.bmimacine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmimacine.ui.theme.BMIMacineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMIMacineTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BMICalculatorScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BMICalculatorScreen(modifier: Modifier = Modifier) {
    val bmiViewModel: BMIViewModel = viewModel()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("BMI-laskin", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = bmiViewModel.weight.value,
            onValueChange = { bmiViewModel.weight.value = it },
            label = { Text("Paino (kg)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = bmiViewModel.height.value,
            onValueChange = { bmiViewModel.height.value = it },
            label = { Text("Pituus (m)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { bmiViewModel.updateBMI() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Laske BMI")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("BMI: ${bmiViewModel.bmiResult.value}", style = MaterialTheme.typography.titleMedium)
    }
}