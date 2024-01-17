package com.etozheluka.etozheluka_animations.animations.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.etozheluka.etozheluka_animations.ui.theme.AnimationTheme

class StateBasedAnimationActivity : ComponentActivity() {
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
                        StateBasedAnimationExample()
                    }
                }
            }
        }
    }

    @Composable
    fun StateBasedAnimationExample() {
        var state by remember {
            mutableStateOf(UiState.Loading)
        }
        AnimatedContent(
            state,
            transitionSpec = {
                fadeIn(
                    animationSpec = tween(3000)
                ) togetherWith fadeOut(animationSpec = tween(3000))
            },
            modifier = Modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                state = when (state) {
                    UiState.Loading -> UiState.Loaded
                    UiState.Loaded -> UiState.Error
                    UiState.Error -> UiState.Loading
                }
            },
            label = "Animated Content"
        ) { targetState ->
            when (targetState) {
                UiState.Loading -> {
                    LoadingContent()
                }

                UiState.Loaded -> {
                    LoadedContent()
                }

                UiState.Error -> {
                    ErrorContent()
                }
            }
        }
    }

    @Composable
    fun LoadingContent() {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Loading content UI
            CircularProgressIndicator(
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center)
            )
        }
    }

    @Composable
    fun LoadedContent() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green)
        ) {
            // Loaded content UI
            Text(
                text = "Content Loaded",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

    @Composable
    fun ErrorContent() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
        ) {
            // Error content UI
            Text(
                text = "Error Loading Content",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

enum class UiState {
    Loading,
    Loaded,
    Error
}