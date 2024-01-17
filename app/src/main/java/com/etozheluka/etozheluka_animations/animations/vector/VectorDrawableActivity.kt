package com.etozheluka.etozheluka_animations.animations.vector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.etozheluka.etozheluka_animations.R
import com.etozheluka.etozheluka_animations.ui.theme.AnimationTheme

class VectorDrawableActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AnimatedVectorDrawable()
                    }
                }
            }
        }
    }

    // https://developer.android.com/jetpack/compose/animation/vectors
    // https://shapeshifter.design
    @OptIn(ExperimentalAnimationGraphicsApi::class)
    @Composable
    fun AnimatedVectorDrawable() {
        val interactionSource = remember { MutableInteractionSource() }

        val image = AnimatedImageVector.animatedVectorResource(R.drawable.avd_anim)
        var atEnd by remember { mutableStateOf(false) }
        Image(
            painter = rememberAnimatedVectorPainter(image, atEnd),
            contentDescription = "Transaction Operation",
            modifier =
            Modifier
                .width(100.dp)
                .height(100.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = {
                        atEnd = !atEnd
                    }
                ),
            contentScale = ContentScale.Crop
        )
    }
}