package com.etozheluka.etozheluka_animations.utils

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

// Function to generate a random color
fun randomColor(): Color {
    val random = Random.Default
    return Color(
        red = random.nextFloat(),
        green = random.nextFloat(),
        blue = random.nextFloat(),
        alpha = 1f
    )
}