package com.example.mycompose.transition

import android.transition.Transition
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class ScreenTransitions {


    companion object{


        @ExperimentalAnimationApi
        @Composable
        fun TestAnimation(content: @Composable () -> Unit) {
            AnimatedVisibility(visibleState = MutableTransitionState(false),
                enter = slideInVertically(initialOffsetY = { -140 }) + expandVertically(expandFrom = Alignment.Top) + fadeIn(initialAlpha = 0.0f),
                exit = slideOutVertically(animationSpec = tween(250,5000,easing = FastOutSlowInEasing)) + shrinkVertically() + fadeOut(animationSpec = tween(250,5000,easing = FastOutSlowInEasing))) {
                content()
            }

        }

//        @ExperimentalAnimationApi
//        @Composable
//        fun ExampleAnimation(content: @Composable () -> Unit) {
//            AnimatedVisibility(visibleState = MutableTransitionState(initialState = true),
//                enter = fadeIn(initialAlpha = 0.1f, animationSpec = tween(1000, 100, easing= LinearEasing)),
//                exit = fadeOut(targetAlpha = 0.5f, animationSpec = tween(1000, 100, easing= LinearEasing))) {
//                content()
//            }
//        }
//
//
//        @ExperimentalAnimationApi
//        @Composable
//        fun EnterAnimation(content: @Composable () -> Unit) {
//            AnimatedVisibility(transitionState = remember {
//                MutableTransitionState(
//                    initialState = false
//                )
//            }
//                .apply { targetState = true },
//                modifier = Modifier,
//                enter = slideInVertically(
//                    initialOffsetY = { -140 }
//                ) + expandVertically(
//                    expandFrom = Alignment.Top
//                ) + fadeIn(initialAlpha = 0.0f),
//                exit = slideOutVertically(animationSpec = tween(250,5000,easing = FastOutSlowInEasing)) + shrinkVertically() + fadeOut(animationSpec = tween(250,5000,easing = FastOutSlowInEasing))) {
//                content()
//            }
//        }
//
//        @ExperimentalAnimationApi
//        @Composable
//        fun SceneAnimation(content: @Composable () -> Unit) {
//            AnimatedVisibility(transitionState = remember {
//                MutableTransitionState(
//                    initialState = false
//                )
//            }
//                .apply { targetState = true },
//                modifier = Modifier,
//                enter = slideInHorizontally( initialOffsetX = { -1100 }, animationSpec = tween(durationMillis = 1000, delayMillis = 1000)),
//                exit = fadeOut(0f, animationSpec = tween(durationMillis = 1000, delayMillis = 1000))
//            ) {
//                content()
//            }
//        }
//
//        @ExperimentalAnimationApi
//        @Composable
//        fun ExampleAnimation(content: @Composable () -> Unit, ) {
//            AnimatedVisibility(transitionState = remember { MutableTransitionState(initialState = false) }
//                .apply { targetState = true },
//                modifier = Modifier,
//                enter = fadeIn(initialAlpha = 0.1f, animationSpec = tween(1000, 100, easing= LinearEasing)),
//                exit = fadeOut(targetAlpha = 0.5f, animationSpec = tween(1000, 100, easing= LinearEasing))) {
//                content()
//            }
//        }

        @ExperimentalAnimationApi
        @Composable
        fun ExampleAnimation(content: @Composable () -> Unit, ) {
            AnimatedVisibility(visibleState = remember { MutableTransitionState(initialState = false) }
                .apply { targetState = true },
                enter = fadeIn(initialAlpha = 0.1f, animationSpec = tween(1000, 100, easing= LinearEasing)),
                exit = fadeOut(targetAlpha = 0.5f, animationSpec = tween(1000, 100, easing= LinearEasing))) {
                content()
            }


        }

//
//        @ExperimentalAnimationApi
//        @Composable
//        fun SampleAnimation(content: @Composable () -> Unit) {
//            AnimatedVisibility(transitionState = remember {
//                MutableTransitionState(
//                    initialState = false
//                )
//            }
//                .apply { targetState = true },
//                modifier = Modifier,
//                enter = fadeIn(initialAlpha = 0.1f, animationSpec = tween(1000, 100, easing= LinearEasing)),
//                exit = fadeOut(targetAlpha = 0.5f, animationSpec = tween(1000, 100, easing= LinearEasing))
//            ) {
//                content()
//            }
//        }

    }

}