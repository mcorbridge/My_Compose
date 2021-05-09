package com.example.mycompose.sinWave

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.math.sin

/**
 * I'm not sure why I felt compelled to complete this, but I was bugged by my previous iterations
 * where the code would build the entire sine wave plot from zero up until the last time value
 *
 * That just seemed utterly wasteful, and I decided that there must be a way to add the new plot to
 * the existing line.  And yeah, there is!  And it worked!
 */
class DrawSineWave {

    @Composable
    fun SineWave() {

        var toggle = remember { mutableStateOf(true) }
        var zPath = remember { mutableStateOf(Path()) }
        val wavePoint = remember { mutableStateOf(0.0f) }
        val timeAxis = remember { mutableStateOf(0.0f) }
        val previousTimeAxis = remember { mutableStateOf(0.0f) }
        val previousWavePoint = remember { mutableStateOf(670.0f) }
        val buttonText = remember { mutableStateOf("stop") }
        val amplitude = remember { mutableStateOf(4.0f) }
        val frequency = remember { mutableStateOf(1.0f) }
        val colors = remember { mutableStateListOf(
            Color.Black,
            Color.Green,
            Color.Cyan,
            Color.Red,
            Color.LightGray,
            Color.Blue,
            Color.Yellow,
            Color.Gray,
            Color.DarkGray,
            Color.Magenta,
        )}
        val colorNdx = remember { mutableStateOf(0) }
        val path = Path()

        path.moveTo(10f, 10f)

        if (toggle.value) {

            var sineWaveMaster = SineWaveMaster()

            sineWaveMaster.DoLine {
                wavePoint.value =
                    ((amplitude.value * sin((2 * Math.PI * frequency.value * it) + 1)) * 200).toFloat()
                timeAxis.value = it * 5000
            }

        }

        path.moveTo(previousTimeAxis.value, previousWavePoint.value)
        path.lineTo(timeAxis.value, wavePoint.value)
        previousTimeAxis.value = timeAxis.value
        previousWavePoint.value = wavePoint.value
        zPath.value.addPath(path)

        if (timeAxis.value > 1200f) {
            toggle.value = false
            zPath.value.reset()
            previousTimeAxis.value = 0.0f
            previousWavePoint.value = 670.0f

            LaunchedEffect(0) {
                delay(10) // On average the human blink lasts only a tenth of a second which is 100 milliseconds
                toggle.value = true
            }
        }

        Canvas(modifier = Modifier
            .fillMaxSize()
            .offset((-10).dp, 400.dp),
            onDraw = {

                // this is simply for flourish
                drawPath(
                    path = zPath.value,
                    color = colors[colorNdx.value],
                    alpha = 0.10f,
                    style = Stroke(50f)
                )
                // this is simply for flourish
                drawPath(
                    path = zPath.value,
                    color = colors[colorNdx.value],
                    alpha = 0.3f,
                    style = Stroke(25f)
                )
                // this is simply for flourish
                drawPath(
                    path = zPath.value,
                    color = colors[colorNdx.value],
                    alpha = 0.4f,
                    style = Stroke(2.5f)
                )

            })

        Column {

            Row {
                Button(onClick = {
                    toggle.value = !toggle.value
                    if (toggle.value) buttonText.value = "stop" else buttonText.value = "start"
                }) {
                    Text(buttonText.value)
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(onClick = {
                    amplitude.value += 0.25f
                }) {
                    Text("A+")
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(onClick = {
                    amplitude.value -= 0.25f
                }) {
                    Text("A-")
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(onClick = {
                    frequency.value += 0.25f
                }) {
                    Text("F+")
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(onClick = {
                    frequency.value -= 0.25f
                }) {
                    Text("F-")
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                //Text("x = ${timeAxis.value} y = ${wavePoint.value}")

                Spacer(modifier = Modifier.width(10.dp))

                Button(onClick = {
                    colorNdx.value++
                    if(colorNdx.value == colors.size){
                        colorNdx.value = 0
                    }
                }) {
                    Text("color")
                }
            }

        }

    }


}

class SineWaveMaster {

    @Composable
    fun DoLine(callback: (arg: Float) -> Unit) {

        val lastSineStateValue = remember { mutableStateOf(0f) }
        val ndx = remember { mutableStateOf(0) }
        val callbackValue = remember { mutableStateOf(0f) }

        val infiniteTransition = rememberInfiniteTransition()

        val sineState = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 1.0f, //2.0f
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 5000,
                    easing = LinearEasing,
                    delayMillis = 0
                )
            )
        )

        /**
         * maybe this isn't necessary, but it allows the sineState value to cycle from 0 .. 1
         * but the callbackValue increments by +1 each cycle
         */

        if (sineState.value < lastSineStateValue.value) {
            ndx.value++
        }

        callbackValue.value = sineState.value + ndx.value

        lastSineStateValue.value = sineState.value

        callback(callbackValue.value)

    } // end composable

} // end DynamicLineMaster class