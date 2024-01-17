package com.etozheluka.etozheluka_animations.animations.offset

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.etozheluka.etozheluka_animations.ui.theme.AnimationTheme
import kotlin.math.roundToInt
import kotlin.random.Random

class StaticOffsetAnimationActivity : ComponentActivity() {
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
                        AnimateOffset()
                    }
                }
            }
        }
    }

    @Composable
    fun AnimateOffset() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            var randomOffset by remember {
                mutableStateOf(IntOffset(0, 0))
            }
            val maxOffset = with(LocalDensity.current) { 200.dp.toPx().roundToInt() }
            val randomX = Random.nextInt(0, maxOffset)
            val randomY = Random.nextInt(0, maxOffset)
            val x = IntOffset(randomX, randomY)

            val offset by animateIntOffsetAsState(
                targetValue = randomOffset,
                label = "offset"
            )

            Box(
                modifier = Modifier
                    .offset {
                        offset
                    }
                    .background(Color.Blue)
                    .size(100.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        randomOffset = x
                    }
            )
        }
    }
}

