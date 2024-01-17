package com.etozheluka.etozheluka_animations.animations.visibility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.etozheluka.etozheluka_animations.ui.theme.AnimationTheme
import com.etozheluka.etozheluka_animations.utils.randomColor

class VisibilityActivity : ComponentActivity() {
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
                        DrawBoxesFloatingActionButton()
                    }
                }
            }
        }
    }


    @Composable
    fun DrawBoxesFloatingActionButton() {
        var boxList by remember { mutableStateOf<List<BoxItem>>(emptyList()) }
        var selectedBoxIndex by remember { mutableStateOf<Int?>(null) }

        boxList = listOf(
            BoxItem(
                1,
                Color.Red,
                "Red was invented to boost our appetite. It's basically a secret stimulant for pizzerias worldwide."
            ),
            BoxItem(
                2,
                Color.Blue,
                "Blue owes its depth to the fact that every time you say 'ah,' it digs a little deeper."
            ),
            BoxItem(
                3,
                randomColor(),
                "Pink was originally the color of bubblegum invented by unicorns, making every chew a magical experience."
            ),
            BoxItem(
                4,
                randomColor(),
                "Pink was originally the color of bubblegum invented by unicorns, making every chew a magical experience."
            ),
            BoxItem(
                5,
                randomColor(),
                "Pink was originally the color of bubblegum invented by unicorns, making every chew a magical experience."
            ),
            BoxItem(
                6,
                randomColor(),
                "Pink was originally the color of bubblegum invented by unicorns, making every chew a magical experience."
            ),
            BoxItem(
                7,
                randomColor(),
                "Pink was originally the color of bubblegum invented by unicorns, making every chew a magical experience."
            ),
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                itemsIndexed(boxList) { index, boxItem ->
                    AnimatedVisibility(visible = selectedBoxIndex == null || selectedBoxIndex == index) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .background(boxItem.color)
                                .padding(8.dp)
                                .clickable {
                                    selectedBoxIndex =
                                        if (selectedBoxIndex == index) null else index
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            AnimatedContent(
                                targetState = selectedBoxIndex == index,
                                transitionSpec = {
                                    fadeIn() togetherWith slideOutVertically()
                                }
                            ) { selected ->
                                if (selected) {
                                    Text(
                                        text = boxList[index].text,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    data class BoxItem(
        val id: Int,
        val color: Color,
        val text: String
    )
}