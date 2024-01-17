package com.etozheluka.etozheluka_animations.navigation.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.ShoppingCart

object MainNavigationDataProvider {

    const val ANIMATION_VISIBILITY = "Visibility Animations"
    const val ANIMATION_TEXT = "Text Animation"
    const val ANIMATION_SIZE = "Size Animations"
    const val ANIMATION_OFFSET = "Offset Animations"
    const val ANIMATION_VECTOR = "Vector Animations"
    const val ANIMATION_REPEATABLE = "Infinite Repeatable"
    const val ANIMATION_STATE = "State Based Animation"
    const val ANIMATION_GRAPHIC = "Graphic Layer Animation"
    const val ANIMATION_COROUTINE = "Coroutine Based Animation"

    val optionsList = mutableListOf(
        AnimationModel(icon = Icons.Outlined.Home, option = ANIMATION_VISIBILITY),
        AnimationModel(icon = Icons.Outlined.CheckCircle, option = ANIMATION_TEXT),
        AnimationModel(icon = Icons.Outlined.MoreVert, option = ANIMATION_SIZE),
        AnimationModel(icon = Icons.Outlined.Share, option = ANIMATION_OFFSET),
        AnimationModel(icon = Icons.Outlined.Build, option = ANIMATION_VECTOR),
        AnimationModel(icon = Icons.Outlined.Face, option = ANIMATION_REPEATABLE),
        AnimationModel(icon = Icons.Outlined.AddCircle, option = ANIMATION_STATE),
        AnimationModel(icon = Icons.Outlined.ShoppingCart, option = ANIMATION_GRAPHIC),
        AnimationModel(icon = Icons.Outlined.Menu, option = ANIMATION_COROUTINE)
    )
}

object VisibilityNavigationDataProvider {

    const val VISIBILITY_PREVIEW_ANIMATION = "Visibility based animation"
    const val ADVANCED_VISIBILITY_ANIMATION = "Advanced visibility animation"

    val optionsList = mutableListOf(
        AnimationModel(icon = Icons.Outlined.Done, option = VISIBILITY_PREVIEW_ANIMATION),
        AnimationModel(icon = Icons.Outlined.Lock, option = ADVANCED_VISIBILITY_ANIMATION),
    )
}

object OffsetNavigationDataProvider {

    const val OFFSET_ANIMATION = "Offset animation"
    const val GESTURE_OFFSET_ANIMATION = "Gesture offset animation"

    val optionsList = mutableListOf(
        AnimationModel(icon = Icons.Outlined.Call, option = OFFSET_ANIMATION),
        AnimationModel(icon = Icons.Outlined.MoreVert, option = GESTURE_OFFSET_ANIMATION)
    )
}

object CoroutineNavigationDataProvider {

    const val SEQUENTIAL_ANIMATION = "Sequential animation"
    const val CONCURRENT_ANIMATION = "Concurrent animation"

    val optionsList = mutableListOf(
        AnimationModel(icon = Icons.Outlined.Lock, option = SEQUENTIAL_ANIMATION),
        AnimationModel(icon = Icons.Outlined.Share, option = CONCURRENT_ANIMATION)
    )
}

object VectorNavigationDataProvider {

    const val VECTOR_DRAWABLE_ANIMATION = "Vector drawable animation"
    const val LOTTIE_ANIMATION = "Lottie animation"

    val optionsList = mutableListOf(
        AnimationModel(icon = Icons.Outlined.Search, option = VECTOR_DRAWABLE_ANIMATION),
        AnimationModel(icon = Icons.Outlined.Check, option = LOTTIE_ANIMATION)
    )
}