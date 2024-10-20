package com.example.bmimacine



import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BMIViewModel : ViewModel() {
    var weight = mutableStateOf("")
    var height = mutableStateOf("")
    var bmiResult = mutableStateOf("")

    private fun calculateBMI(): Double {
        val weightValue = weight.value.toDoubleOrNull() ?: return 0.0
        val heightValue = height.value.toDoubleOrNull() ?: return 0.0
        return weightValue / (heightValue * heightValue)
    }

    fun updateBMI() {
        val bmi = calculateBMI()
        bmiResult.value = String.format("%.2f", bmi)
    }
}
