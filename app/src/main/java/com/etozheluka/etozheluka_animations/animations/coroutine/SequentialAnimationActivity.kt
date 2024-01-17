package com.etozheluka.etozheluka_animations.animations.coroutine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.etozheluka.etozheluka_animations.ui.theme.AnimationTheme

class SequentialAnimationActivity : ComponentActivity() {
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
                        SequentialAnimationsExample()
                    }
                }
            }
        }
    }

    @Composable
    fun SequentialAnimationsExample() {
        val alphaAnimation = remember { Animatable(0f) }
        val yAnimation = remember { Animatable(0f) }
        val xAnimation = remember { Animatable(1f) }

        LaunchedEffect("animationKey") {
            alphaAnimation.animateTo(1f)
            yAnimation.animateTo(100f, animationSpec = tween(1000))
            yAnimation.animateTo(500f, animationSpec = tween(1000))
            xAnimation.animateTo(150f, animationSpec = tween(450))
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Surface(
                modifier = Modifier
                    .size(100.dp)
                    .alpha(alphaAnimation.value)
                    .offset(x = xAnimation.value.dp, y = yAnimation.value.dp),
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.primary
            ) {}
        }
    }
}