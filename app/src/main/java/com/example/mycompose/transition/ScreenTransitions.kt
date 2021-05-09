package com.example.mycompose.transition

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

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
                exit = slideOutVertically() + shrinkVertically() + fadeOut(),
                content = content,
                initiallyVisible = false
            )
        }

        @ExperimentalAnimationApi
        @Composable
        fun SceneAnimation(content: @Composable () -> Unit) {
            AnimatedVisibility(
                visible = true,
                enter = slideInVertically(
                    initialOffsetY = { -140 },
                    animationSpec = tween(5000,0,easing = FastOutSlowInEasing)
                ) + expandVertically(
                    expandFrom = Alignment.Top
                ) + fadeIn(initialAlpha = 0.0f),
                exit = slideOutVertically(animationSpec = tween(5000,0,easing = FastOutSlowInEasing)) + shrinkVertically() + fadeOut(),
                content = content,
                initiallyVisible = false
            )
        }

    }

}