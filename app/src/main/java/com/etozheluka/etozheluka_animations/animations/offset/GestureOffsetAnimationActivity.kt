package com.etozheluka.etozheluka_animations.animations.offset

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.etozheluka.etozheluka_animations.R
import com.etozheluka.etozheluka_animations.ui.theme.AnimationTheme
import kotlin.math.roundToInt

class GestureOffsetAnimationActivity : ComponentActivity() {
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
                        GestureDetectionExample()
                    }
                }
            }
        }
    }

    @Composable
    fun GestureDetectionExample() {
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }
        var scaleState by remember { mutableStateOf(1f) }
        var rotationState by remember { mutableStateOf(0f) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoom, rotation ->
                        offsetX += pan.x
                        offsetY += pan.y
                        scaleState *= zoom
                        rotationState += rotation
                    }
                }
        ) {
            Image(
                modifier = Modifier
                    .size(200.dp)
                    .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                    .graphicsLayer(
                        scaleX = scaleState,
                        scaleY = scaleState,
                        rotationZ = rotationState
                    ),
                painter = painterResource(R.drawable.image_vector),
                contentDescription = null
            )

            Button(
                onClick = {
                    offsetX = 0f
                    offsetY = 0f
                    scaleState = 1f
                    rotationState = 0f
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text("Reset")
            }
        }
    }
}

