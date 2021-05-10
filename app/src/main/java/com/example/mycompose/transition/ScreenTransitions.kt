package com.example.mycompose.transition

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
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
                exit = fadeOut(0f, animationSpec = tween(durationMillis = 1000, delayMillis = 1000)),
                enter = slideInHorizontally( initialOffsetX = { -1100 }, animationSpec = tween(durationMillis = 1000, delayMillis = 1000)),
                content = content,
                initiallyVisible = false
            )
        }

        @ExperimentalAnimationApi
        @Composable
        fun ExampleAnimation(content: @Composable () -> Unit) {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(initialAlpha = 0.1f, animationSpec = tween(1000, 100, easing= LinearEasing)),
                exit = fadeOut(targetAlpha = 0.5f, animationSpec = tween(1000, 100, easing= LinearEasing)),
                content = content,
                initiallyVisible = false
            )
        }

    }

}