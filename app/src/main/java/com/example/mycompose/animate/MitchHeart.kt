package com.example.mycompose.animate

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
class MitchHeart {

    companion object {


        @Composable
        fun doAnimationShit(){
            Column{
                //InfinitelyPulsingHeart()
                DoWhatever()
            }

        }



        @Composable
        private fun InfinitelyPulsingHeart() {
            // Creates an [InfiniteTransition] instance for managing child animations.
            val infiniteTransition = rememberInfiniteTransition()

            // Creates a child animation of float type as a part of the [InfiniteTransition].
            val scale by infiniteTransition.animateFloat(
                initialValue = 1f,
                targetValue = 6f, // 6f
                animationSpec = infiniteRepeatable(
                    // Infinitely repeating a 1000ms tween animation using default easing curve.
                    animation = tween(10000),
                    // After each iteration of the animation (i.e. every 1000ms), the animation will
                    // start again from the [initialValue] defined above.
                    // This is the default [RepeatMode]. See [RepeatMode.Reverse] below for an
                    // alternative.
                    repeatMode = RepeatMode.Restart
                )
            )

            // Creates a Color animation as a part of the [InfiniteTransition].
            val color by infiniteTransition.animateColor(
                initialValue = Color.Red,
                targetValue = Color(0xff800000), // Dark Red
                animationSpec = infiniteRepeatable(
                    // Linearly interpolate between initialValue and targetValue every 1000ms.
                    animation = tween(500, easing = LinearEasing),
                    // Once [TargetValue] is reached, starts the next iteration in reverse (i.e. from
                    // TargetValue to InitialValue). Then again from InitialValue to TargetValue. This
                    // [RepeatMode] ensures that the animation value is *always continuous*.
                    repeatMode = RepeatMode.Reverse // Reverse
                )
            )

            Box(Modifier.fillMaxSize()) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .graphicsLayer(
                            scaleX = scale,
                            scaleY = scale
                        ),
                    tint = color
                )
            }
        }


        @Composable
        fun DoWhatever(){
            var visible = remember { mutableStateOf(true) }
            Whatever()
            Button(onClick = { visible.value = false }) {
                Text("Start")
            }
        }

        @Composable
        private fun Whatever(){
            var visible = remember { mutableStateOf(true) }
            AnimatedVisibility(
                visible = visible.value,
                enter = fadeIn(
                    // Overwrites the initial value of alpha to 0.4f for fade in, 0 by default
                    initialAlpha = 0.4f
                ),
                exit = fadeOut(
                    // Overwrites the default animation with tween
                    animationSpec = tween(durationMillis = 250)
                )
            ) {
                // Content that needs to appear/disappear goes here:
                Text("Content to appear/disappear",
                    Modifier
                        .fillMaxWidth()
                        .requiredHeight(200.dp)
                        .clickable {
                            visible.value = false
                        })

            }
        }
    }

}

enum class MyColors(val color: Color) {
    Red(Color.Red), Green(Color.Green), Blue(Color.Blue)
}

