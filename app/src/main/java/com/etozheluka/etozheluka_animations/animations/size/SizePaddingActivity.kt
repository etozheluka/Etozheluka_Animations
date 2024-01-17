package com.etozheluka.etozheluka_animations.animations.size

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.etozheluka.etozheluka_animations.R
import com.etozheluka.etozheluka_animations.ui.theme.AnimationTheme

class SizePaddingActivity : ComponentActivity() {
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
                        AnimatePadding()
                        AnimateSizeChange()
                    }
                }
            }
        }
    }

    @Composable
    fun AnimatePadding() {
        Box {
            var toggled by remember {
                mutableStateOf(false)
            }
            val animatedPadding by animateDpAsState(
                if (toggled) {
                    0.dp
                } else {
                    100.dp
                },
                label = "padding"
            )
            Box(
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(animatedPadding)
                    .background(Color(0xFF157ABD))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        toggled = !toggled
                    }
            )
        }

    }

    @Composable
    fun AnimateSizeChange() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            var expanded by remember { mutableStateOf(false) }
            Box(
                modifier = Modifier
                    .background(Color.Blue)
                    .animateContentSize()
                    .height(if (expanded) 400.dp else 200.dp)
                    .fillMaxWidth()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        expanded = !expanded
                    }
            ) {
                Text(
                    text = stringResource(id = if (!expanded) R.string.story_mini else R.string.story_expanded),
                    fontSize = 24.sp
                )
            }
        }
    }
}


