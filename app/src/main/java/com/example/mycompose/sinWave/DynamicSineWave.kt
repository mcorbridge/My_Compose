package com.example.mycompose.sinWave

import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.sin


class DynamicSineWave {

    var dynamicWaveMaster =
        DynamicWaveMaster() // <- Note: all the ZineCanvas composables using this


    @Composable
    fun DoDynamic() {

        ZineCanvas(100f, Color.Black, 10f) {
            //println("********************* ZineCanvas $it ********************* ${System.currentTimeMillis()}")
        }
    }


    /**
     * and here we are experimenting with creating a new path and adding it to and existing path
     * and it works!!!
     */
    @Composable
    fun ZineCanvas(xPos: Float, color: Color, lineTime: Float, callback: (arg: Float) -> Unit) {

        //var dynamicWaveMaster = DynamicWaveMaster()
        val path = Path()
        val pathx = remember { mutableStateOf(Path()) }
        //val xPos = remember { mutableStateOf(xPos) }
        var yPos = remember { mutableStateOf(200f) }
        val amplitude = remember { mutableStateOf(4.0f) }
        val frequency = remember { mutableStateOf(1.0f) }
        val phase = remember { mutableStateOf(1.0f) }
        val wavePoint = remember { mutableStateOf(0.0f) }
        val timeAxis = remember { mutableStateOf(0.0f) }
        val mainControl = remember { mutableStateOf(true) }


        path.apply {
            moveTo(xPos, 100f)
        }

        pathx.value.apply {
            moveTo(xPos, 100f)
            lineTo(xPos, 200f)
        }

        if(mainControl.value){

            dynamicWaveMaster.DoWave {
                wavePoint.value = (amplitude.value * sin((2 * Math.PI * frequency.value * it) + phase.value)).toFloat()
                timeAxis.value = it

                wavePoint.value = wavePoint.value * 200
                timeAxis.value = timeAxis.value * 300
            }
        }

        callback(timeAxis.value)

        StartStop(100.dp, 600.dp, mainControl.value){
            mainControl.value = it
        }

        Text("x = ${timeAxis.value} y = ${wavePoint.value}", modifier = Modifier.offset(100.dp, 700.dp))

        //println("x = ${timeAxis.value} y = ${wavePoint.value}")

        // auto-stop
        if(timeAxis.value > 1050){
            mainControl.value = false
        }

        pathx.value.lineTo(timeAxis.value, wavePoint.value)
        path.addPath(pathx.value)

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .border(1.dp, Color.Black)
                .offset(
                    (10).dp,
                    400.dp
                ),

            onDraw = {

                drawPath(
                    path = pathx.value,
                    color = color,
                    alpha = 0.3f,
                    style = Stroke(lineTime)
                )

                drawPath(
                    path = path,
                    color = color,
                    alpha = 0.5f,
                    style = Stroke(lineTime)
                )

            })
    }

    /**
     * This an example of information sent DOWN to the composable from the parent
     * and UP to the parent from the child
     */
    @Composable
    fun StartStop(xPos: Dp, yPos:Dp, mainControl:Boolean, callback: (arg: Boolean) -> Unit){
        val startStop = remember { mutableStateOf("stop") }
        val toggle = remember { mutableStateOf(true)}

        //info sent DOWN from outside world!
        if(!mainControl){
            toggle.value = false
            startStop.value = "start"
        }

        Button(onClick = {
            toggle.value = !toggle.value
            if (toggle.value) startStop.value = "stop" else startStop.value = "start"
            callback(toggle.value) // <-- info sent UP to outside world!
        }, modifier = Modifier.offset(xPos, yPos)) {
            Text(startStop.value)
        }
    }

}


class DynamicWaveMaster {

    @Composable
    fun DoWave(callback: (arg: Float) -> Unit) {

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

        var ndx = remember { mutableStateOf(0) }
        var doIncrement = remember { mutableStateOf(true) }

        // The value from sineState cycles from 0f to 1f.  However we need to increment the value
        // returned from this callback by +1 each cycle.
        if(sineState.value > 0.990 && doIncrement.value){
            ndx.value++
            doIncrement.value = false
        }
        if(sineState.value > 0.400 && sineState.value < 0.500){
            doIncrement.value = true
        }

        callback(sineState.value + ndx.value)
    } // end composable

} // end class

