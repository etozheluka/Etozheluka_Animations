package com.etozheluka.etozheluka_animations.animations.infinite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.etozheluka.etozheluka_animations.ui.theme.AnimationTheme

class InfiniteRepeatableAnimationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        InfiniteRepeatableSpecAnimation()
                    }
                }
            }
        }
    }

    @Composable
    fun InfiniteRepeatableSpecAnimation() {
        val infiniteTransition = rememberInfiniteTransition()
        val angle by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 2000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )

        Box(
            Modifier
                .size(100.dp)
                .offset(x = 15.dp, y = 30.dp)
                .graphicsLayer { rotationZ = angle }
        ) {
            Icon(
                modifier = Modifier.size(size = 100.dp),
                imageVector = Icons.Filled.Settings,
                contentDescription = null,
                tint = Color(0xFF005EFF)
            )
        }
        Box(
            Modifier
                .size(100.dp)
                .graphicsLayer { rotationZ = -angle }
        ) {
            Icon(
                modifier = Modifier.size(size = 100.dp),
                imageVector = Icons.Filled.Settings,
                contentDescription = null,
                tint = Color(0xFFFF001E)
            )
        }
    }
}
