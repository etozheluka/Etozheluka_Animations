package com.etozheluka.etozheluka_animations.animations.graphic_layer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.etozheluka.etozheluka_animations.ui.theme.AnimationTheme

class GraphicLayerExampleActivity : ComponentActivity() {
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
                        GraphicsLayerExample()
                        NoGraphicsLayerExample()
                    }
                }
            }
        }
    }

    @Composable
    fun GraphicsLayerExample() {
        var rotationState by remember { mutableStateOf(0f) }
        val animatedRotationState by animateFloatAsState(targetValue = rotationState)

        Box(
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(200.dp)
                    .graphicsLayer(
                        rotationZ = animatedRotationState,
                        clip = true
                    ),
                imageVector = Icons.Filled.Settings,
                contentDescription = null
            )

            Button(
                onClick = {
                    rotationState += 45f
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text("Rotate")
            }
        }
    }

    @Composable
    fun NoGraphicsLayerExample() {
        var rotationState by remember { mutableStateOf(0f) }
        val animatedRotationState by animateFloatAsState(targetValue = rotationState)

        Box(
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
        ) {
            Icon(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(200.dp)
                    .rotate(animatedRotationState),
                imageVector = Icons.Filled.Settings,
                contentDescription = null
            )

            Button(
                onClick = {
                    rotationState += 45f
                },
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                Text("Rotate")
            }
        }
    }
}