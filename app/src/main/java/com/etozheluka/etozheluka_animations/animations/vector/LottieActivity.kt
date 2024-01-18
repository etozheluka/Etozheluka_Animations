package com.etozheluka.etozheluka_animations.animations.vector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.etozheluka.etozheluka_animations.R
import com.etozheluka.etozheluka_animations.ui.theme.AnimationTheme

class LottieActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AnimatedPreloader()
                    }
                }
            }
        }
    }

    // https://github.com/airbnb/lottie-android
    // https://lottiefiles.com
    // implementation("com.airbnb.android:lottie-compose:4.0.0")
    @Composable
    fun AnimatedPreloader(modifier: Modifier = Modifier) {
        val preloaderLottieComposition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(
                R.raw.animation_christmas
            )
        )

        val preloaderProgress by animateLottieCompositionAsState(
            preloaderLottieComposition,
            iterations = LottieConstants.IterateForever,
            isPlaying = true
        )

        LottieAnimation(
            composition = preloaderLottieComposition,
            progress = preloaderProgress,
            modifier = modifier
        )
    }
}