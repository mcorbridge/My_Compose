package com.example.mycompose.transition

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import kotlinx.coroutines.delay

class ScreenTransitions {


    companion object{

        @ExperimentalAnimationApi
        @Composable
        fun EnterAnimation(content: @Composable () -> Unit) {
            AnimatedVisibility(
                visible = true,
                enter = slideInVertically(
                    initialOffsetY = { -140 }
                ) + expandVertically(
                    expandFrom = Alignment.Top
                ) + fadeIn(initialAlpha = 0.0f),
                exit = slideOutVertically(animationSpec = tween(250,5000,easing = FastOutSlowInEasing)) + shrinkVertically() + fadeOut(animationSpec = tween(250,5000,easing = FastOutSlowInEasing)),
                content = content,
                initiallyVisible = false
            )
        }

        @ExperimentalAnimationApi
        @Composable
        fun SceneAnimation(content: @Composable () -> Unit) {
            AnimatedVisibility(
                visible = true,
                enter = slideInHorizontally( initialOffsetX = { -1100 }, animationSpec = tween(durationMillis = 1000, delayMillis = 100)),
                exit = slideOutHorizontally(targetOffsetX = { 0 }, animationSpec = tween(durationMillis = 1000, delayMillis = 0)),
                content = content,
                initiallyVisible = false
            )
        }

    }

}