package com.etozheluka.etozheluka_animations.animations.visibility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.etozheluka.etozheluka_animations.ui.theme.AnimationTheme

class VisibilityPreviewActivity : ComponentActivity() {
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
                        VisibilityGoneExample()
                        VisibilityHideExample()
                    }
                }
            }
        }
    }

    @Composable
    fun VisibilityGoneExample() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .wrapContentSize(Alignment.Center)
        ) {
            var visible by remember {
                mutableStateOf(true)
            }
            AnimatedVisibility(visible) {
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Blue)
                )
            }
            Button(modifier = Modifier.align(Alignment.BottomCenter), onClick = {
                visible = !visible
            }) {
                Text("Show/Hide")
            }
        }
    }

    @Composable
    fun VisibilityHideExample() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .wrapContentSize(Alignment.Center)
        ) {
            var visible by remember {
                mutableStateOf(true)
            }
            val animatedAlpha by animateFloatAsState(
                targetValue = if (visible) 1.0f else 0f,
                label = "alpha"
            )
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .graphicsLayer {
                        alpha = animatedAlpha
                    }
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Red)
            )
            Button(modifier = Modifier.align(Alignment.BottomCenter), onClick = {
                visible = !visible
            }) {
                Text("Show/Hide")
            }
        }
    }
}

