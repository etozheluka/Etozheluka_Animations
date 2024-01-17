package com.etozheluka.etozheluka_animations.navigation.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.etozheluka.etozheluka_animations.animations.offset.GestureOffsetAnimationActivity
import com.etozheluka.etozheluka_animations.animations.offset.StaticOffsetAnimationActivity
import com.etozheluka.etozheluka_animations.navigation.data.AnimationModel
import com.etozheluka.etozheluka_animations.navigation.data.OffsetNavigationDataProvider
import com.etozheluka.etozheluka_animations.navigation.data.OffsetNavigationDataProvider.GESTURE_OFFSET_ANIMATION
import com.etozheluka.etozheluka_animations.navigation.data.OffsetNavigationDataProvider.OFFSET_ANIMATION
import com.etozheluka.etozheluka_animations.ui.theme.AnimationTheme
import kotlin.reflect.KClass

class AnimatedOffsetActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        verticalArrangement = Arrangement.spacedBy(space = 24.dp), // gap between items
                        contentPadding = PaddingValues(all = 22.dp) // padding for LazyColumn layout
                    ) {
                        items(OffsetNavigationDataProvider.optionsList) { item ->
                            AnimationItem(item)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun AnimationItem(
    optionName: AnimationModel,
    context: Context = LocalContext.current.applicationContext
) {
    Card(
        shape = RoundedCornerShape(size = 12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Gray),
        modifier = Modifier
            .padding(8.dp)
            .clickable { context.navigateToAnimation(optionName) }
            .size(150.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(size = 36.dp),
                imageVector = optionName.icon,
                contentDescription = null,
                tint = Color(0xFF6650a4)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = optionName.option,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}


private fun Context.navigateToAnimation(it: AnimationModel) {
    when (it.option) {
        OFFSET_ANIMATION -> navigateToScreen(
            StaticOffsetAnimationActivity::class
        )

        GESTURE_OFFSET_ANIMATION -> navigateToScreen(
            GestureOffsetAnimationActivity::class
        )
    }
}

private fun <T : Any> Context.navigateToScreen(activity: KClass<T>) {
    startActivity(
        Intent(this, activity.java)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).apply {
                putExtra("parameter", 1)
            }
    )
}