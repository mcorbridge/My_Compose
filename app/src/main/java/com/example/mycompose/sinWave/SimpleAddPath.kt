package com.example.mycompose.sinWave

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mycompose.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import java.util.*
import kotlin.math.sin

class SimpleAddPath {

    //private val dynamicLineMaster = DynamicLineMaster()
    private val inkMaster = Inkmaster()

    @Composable
    fun AddPath() {
        var drawSineWave = DrawSineWave()
        drawSineWave.SineWave()
    }


    @ExperimentalComposeApi
    @Composable
    fun AddPathh() {

        var toggle = remember { mutableStateOf(true) }
        var zPath = remember { mutableStateOf(Path()) }
        val wavePoint = remember { mutableStateOf(0.0f) }
        val timeAxis = remember { mutableStateOf(0.0f) }
        val previousTimeAxis = remember { mutableStateOf(0.0f) }
        val previousWavePoint = remember { mutableStateOf(670.0f) }
        val buttonText = remember { mutableStateOf("stop") }
        val amplitude = remember { mutableStateOf(4.0f) }
        val frequency = remember { mutableStateOf(1.0f) }

        val path = Path()

        path.moveTo(10f, 10f)
        //path.lineTo(10f,500f)

        if (toggle.value) {

            var dynamicLineMaster = DynamicLineMaster()

            dynamicLineMaster.DoLine {
                wavePoint.value =
                    ((amplitude.value * sin((2 * Math.PI * frequency.value * it) + 1)) * 200).toFloat()
                timeAxis.value = it * 1000
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
            buttonText.value = "start"
            previousTimeAxis.value = 0.0f
            previousWavePoint.value = 670.0f

            LaunchedEffect(0) {
                println(this.isActive)
                delay(10)
                toggle.value = true
            }
        }

        Canvas(modifier = Modifier
            .fillMaxSize()
            .offset((-10).dp, 400.dp),
            onDraw = {

                drawPath(
                    path = zPath.value,
                    color = Color.Green,
                    alpha = 0.10f,
                    style = Stroke(50f)
                )

                drawPath(
                    path = zPath.value,
                    color = Color.Green,
                    alpha = 0.3f,
                    style = Stroke(25f)
                )

                drawPath(
                    path = zPath.value,
                    color = Color.Green,
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
                Text("x = ${timeAxis.value} y = ${wavePoint.value}")
                //ClockScreen()
            }

        }

    }


    @Composable
    fun ClockScreen() {
        fun currentTime(): com.example.mycompose.sinWave.Time {
            val cal = Calendar.getInstance()
            return Time(
                hours = cal.get(Calendar.HOUR_OF_DAY),
                minutes = cal.get(Calendar.MINUTE),
                seconds = cal.get(Calendar.SECOND),
            )
        }

        var time by remember { mutableStateOf(currentTime()) }

        LaunchedEffect(0) {
            while (true) {
                time = currentTime()
                delay(1000)
                println("---------------------> $time")
            }
        }

    }


    @Composable
    fun AddPathv() {

        val toggle = remember { mutableStateOf(true) }
        val zPath = remember { mutableStateOf(Path()) }
        val wavePoint = remember { mutableStateOf(0.0f) }
        val timeAxis = remember { mutableStateOf(0.0f) }
        val previousTimeAxis = remember { mutableStateOf(0.0f) }
        val previousWavePoint = remember { mutableStateOf(0.0f) }
        val buttonText = remember { mutableStateOf("stop") }

        val path = Path()

        path.moveTo(10f, 10f)
        path.lineTo(10f, 500f)

        Canvas(modifier = Modifier
            .fillMaxSize()
            .offset((10).dp, 400.dp),
            onDraw = {

                drawPath(
                    path = zPath.value,
                    color = Color.Black,
                    alpha = 1f,
                    style = Stroke(5f)
                )

            })

        if (toggle.value) {
//            dynamicLineMaster.DoLine {
//                wavePoint.value = ((4 * sin((2 * Math.PI * 1 * it) + 1)) * 200).toFloat()
//                timeAxis.value = it * 300
//            }
        }

        println("x = ${timeAxis.value} y = ${wavePoint.value}")

        path.moveTo(previousTimeAxis.value, previousWavePoint.value)
        path.lineTo(timeAxis.value, wavePoint.value)
        previousTimeAxis.value = timeAxis.value
        previousWavePoint.value = wavePoint.value
        zPath.value.addPath(path)

        Button(onClick = {
            toggle.value = !toggle.value
            if (toggle.value) buttonText.value = "stop" else buttonText.value = "start"
        }) {
            Text(buttonText.value)
        }

    }


    @Composable
    fun AddPathq() {

        var bikeState = remember { mutableStateOf(BikePosition.START) }

//        val offsetAnimation: Dp by animateDpAsState(
//            if (bikeState.value == BikePosition.START) (5.dp) else (300.dp),
//            //spring(dampingRatio = Spring.DampingRatioNoBouncy), // <- this works as well!!
//            tween(1000, easing = CubicBezierEasing(0.4f, 0.0f, 0.8f, 0.8f)),
//            finishedListener = {
//                println("finished! $it")
//            },
//        )

        //println("offsetAnimation.value = ${offsetAnimation.value}")

        val foo: Int by animateIntAsState(
            targetValue = if (bikeState.value == BikePosition.START) (0) else (100),
            tween(1000, easing = CubicBezierEasing(0.4f, 0.0f, 0.8f, 0.8f)),
            finishedListener = { println(" >>>>>>>>>>>>>>>>>>>>>>>> animateIntAsState finished! $it") }
        )

        var fooOffset = remember { mutableStateOf(10.dp) }

        // look Ma!  No hands!  Seriously though, fooOffset.value updates whenever val foo changes
        // this is cool, and it really entails rethinking how to code loops in compose
        fooOffset.value = (foo * 10).dp

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.firestore),
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .absoluteOffset(y = fooOffset.value) // <- changed by foo: animateIntAsState
                //.offset(x = offsetAnimation, y = offsetAnimation) // alternate view: x and y offset changes at same time
            )
            Button(
                onClick = {
                    bikeState.value = when (bikeState.value) {
                        BikePosition.START -> BikePosition.FINISH
                        BikePosition.FINISH -> BikePosition.START
                    }
                }, modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center)
            ) {
                Text(text = "Ride")
            }
        }

    }

    @Composable
    fun AddPathx() {

        val path = remember { mutableStateOf(Path()) }
        val amplitude = remember { mutableStateOf(4.0f) }
        val frequency = remember { mutableStateOf(1.0f) }
        val phase = remember { mutableStateOf(1.0f) }
        val wavePoint = remember { mutableStateOf(0.0f) }
        val timeAxis = remember { mutableStateOf(0.0f) }
        val toggle = remember { mutableStateOf(true) }

        path.value.moveTo(10f, 10f)

        if (toggle.value) {

//            dynamicLineMaster.DoLine {
//                wavePoint.value =
//                    (amplitude.value * sin((2 * Math.PI * frequency.value * it) + phase.value)).toFloat()
//                timeAxis.value = it
//
//                wavePoint.value *= 200
//                timeAxis.value *= 300
//            }

        }


        path.value.lineTo(timeAxis.value, wavePoint.value)


        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Cyan)
        ) {

            Canvas(modifier = Modifier
                .fillMaxSize()
                .offset((10).dp, 400.dp),
                onDraw = {

                    drawPath(
                        path = path.value,
                        color = Color.Black,
                        alpha = 1f,
                        style = Stroke(5f)
                    )

                })

            Row {
                Text("x = ${timeAxis.value} y = ${wavePoint.value}")
            }
        }
    }


    @Composable
    fun AddPathz() {

        val pathx = Path()
        val path = Path()
        val yAdd = remember { mutableStateOf(100f) }
        val toggle = remember { mutableStateOf(true) }
        val amplitude = remember { mutableStateOf(4.0f) }
        val frequency = remember { mutableStateOf(1.0f) }
        val phase = remember { mutableStateOf(1.0f) }
        val wavePoint = remember { mutableStateOf(0.0f) }
        val timeAxis = remember { mutableStateOf(0.0f) }

        path.moveTo(100f, 0f)
        path.lineTo(100f, 100f)

        pathx.moveTo(100f, 100f)

        if (toggle.value) {

//            dynamicLineMaster.DoLine {
//                wavePoint.value =
//                    (amplitude.value * sin((2 * Math.PI * frequency.value * it) + phase.value)).toFloat()
//                timeAxis.value = it
//            }
        }

        Row {
            Text("x = ${timeAxis.value} y = ${wavePoint.value}")
        }

        pathx.lineTo(100f, 100f + yAdd.value)
        //pathx.lineTo(timeAxis.value, wavePoint.value)
        path.addPath(pathx)

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Cyan)
        ) {

            Canvas(modifier = Modifier
                .fillMaxSize()
                .offset((10).dp, 400.dp),
                onDraw = {

                    drawPath(
                        path = path,
                        color = Color.Black,
                        alpha = 1f,
                        style = Stroke(20f)
                    )

                })

            //Text("${yAdd.value}")
            Text("x = ${timeAxis.value} y = ${wavePoint.value}")
        }
    }

    @Composable
    fun StartStop(xPos: Dp, yPos: Dp, mainControl: Boolean, callback: (arg: Boolean) -> Unit) {
        val startStop = remember { mutableStateOf("stop") }
        val toggle = remember { mutableStateOf(true) }

        //info sent DOWN from outside world!
        if (!mainControl) {
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

data class Time(val hours: Int, val minutes: Int, val seconds: Int)

class DynamicLineMaster {

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

enum class BikePosition {
    START, FINISH
}

class Inkmaster {
    @Composable
    fun DoLine(callback: (arg: Float) -> Unit) {

        val infiniteTransition = rememberInfiniteTransition()

        val sineState = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 1.0f, //2.0f
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 1000,
                    easing = LinearEasing,
                    delayMillis = 0
                )
            )
        )

        val doIncrement = remember { mutableStateOf(true) }

        if (sineState.value > 0.990 && doIncrement.value) {
            doIncrement.value = false
            println("-------------------> ${sineState.value}")
            callback(sineState.value)
        }
        if (sineState.value > 0.400 && sineState.value < 0.500) {
            doIncrement.value = true
        }


    }
}