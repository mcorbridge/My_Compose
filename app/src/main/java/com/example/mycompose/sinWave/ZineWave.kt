package com.example.mycompose.sinWave

import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import kotlin.math.sin


class ZineWave {

    var zineWaveMaster = ZineWaveMaster()

    @Composable
    fun DoZineWave() {

        val amplitude = remember { mutableStateOf(4.0f) }
        val frequency = remember { mutableStateOf(1.0f) }
        val phase = remember { mutableStateOf(1.0f) }
        val wavePoint = remember { mutableStateOf(0.0f) }
        val timeAxis = remember { mutableStateOf(0.0f) }
        val yList = remember { mutableStateListOf<Pair<Float, Float>>() }
        val zinePath = Path()
        val xinePath = remember { mutableStateOf(Path()) }
        val isWorking = remember { mutableStateOf(true) }

        if(isWorking.value){ // <------ effectively starts/stops the animation
            zineWaveMaster.DoWave{
                wavePoint.value = (amplitude.value * sin((2 * Math.PI * frequency.value * it) + phase.value)).toFloat()
                timeAxis.value = it
            }
        }

        Row {
            Text("x = ${timeAxis.value} y = ${wavePoint.value}")
        }

        //yList.add(Pair(((timeAxis.value * 300f)), wavePoint.value * 200f))

//        if (yList.size == 900) {
//            isWorking.value = false
//        }

        zinePath.apply {
            moveTo(100f, 100f)
        }

        xinePath.value.apply {
            moveTo(100f, 100f)
            lineTo(100f, 200f)
        }

        zinePath.lineTo(timeAxis.value, wavePoint.value)
        xinePath.value.addPath(zinePath)

//        zinePath.apply {
//            moveTo(290.0f, 670.0f)
//            yList.forEach {
//                lineTo(it.first, it.second)
//            }
//        }

        ZineCanvas(xinePath.value)

    }

    @Composable
    fun ZineCanvas(path: Path) {

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .border(1.dp, Color.Black)
                .offset(
                    (-110).dp,// <- here! the x canvas offset is where we position the sine wave on the canvas (smile)
                    (400).dp// <- here! the y canvas offset is where we position the sine wave on the canvas (smile)
                ),
            onDraw = {

                drawPath(
                    path = path,
                    color = Color.Black,
                    alpha = 1.0f,
                    style = Stroke(20f)
                )

//                drawPath(
//                    path = xinePath,
//                    color = Color.Red,
//                    alpha = 1.0f,
//                    style = Stroke(10f)
//                )
            })
    }

}


class ZineWaveMaster {

    @Composable
    fun DoWave(callback: (arg: Float) -> Unit) {

        val infiniteTransition = rememberInfiniteTransition()

        val sineState = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 1.0f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 5000,
                    easing = LinearEasing,
                    delayMillis = 0
                )
            )
        )

        val ndx = remember { mutableStateOf(0) }
        val toggle = remember { mutableStateOf(true) }

        // incrementing the time dimension
        if ((sineState.value > 0.0 &&  sineState.value < 0.05) && toggle.value) {
            ndx.value++
            toggle.value = false
        }
        if (sineState.value > 0.0 &&  sineState.value < 0.05) {
            toggle.value = true
        }

        Log.d("INFO","                        ${sineState.value + ndx.value}")

        callback(sineState.value + ndx.value)
    }
}