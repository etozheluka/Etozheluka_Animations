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
import androidx.compose.ui.unit.dp
import com.etozheluka.etozheluka_animations.ui.theme.AnimationTheme
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ConcurrentAnimationActivity : ComponentActivity() {
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
                        ConcurrentAnimationsExample()
                    }
                }
            }
        }
    }

    @Composable
    fun ConcurrentAnimationsExample() {
        val yAnimation = remember { Animatable(0f) }
        val xAnimation = remember { Animatable(0f) }

        LaunchedEffect("animationKey") {
            val xJob = async {
                launch {
                    xAnimation.animateTo(100f, animationSpec = tween(500))
                    xAnimation.animateTo(30f, animationSpec = tween(700))
                    xAnimation.animateTo(125f, animationSpec = tween(650))
                    xAnimation.animateTo(180f, animationSpec = tween(650))
                    xAnimation.animateTo(65f, animationSpec = tween(650))
                }
            }

            val yJob = async {
                launch {
                    yAnimation.animateTo(1f)
                    yAnimation.animateTo(500f, animationSpec = tween(1000))
                    yAnimation.animateTo(250f, animationSpec = tween(800))
                    yAnimation.animateTo(125f, animationSpec = tween(700))
                    yAnimation.animateTo(250f, animationSpec = tween(600))
                }
            }

            xJob.await()
            yJob.await()
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Surface(
                modifier = Modifier
                    .size(100.dp)
                    .offset(x = xAnimation.value.dp, y = yAnimation.value.dp),
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.primary
            ) {}
        }
    }
}