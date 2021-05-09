package com.example.mycompose.sinWave

import android.util.Log
import android.util.Log.INFO
import android.util.Log.VERBOSE
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.mycompose.animate.SingleDot
import java.text.DecimalFormat


class NewSineWave {

    var newWaveMaster = NewWaveMaster()
    var ndx = 0

    @Composable
    fun WaveSetUp(){

        var amplitude = remember { mutableStateOf(1.0)}
        var frequency = remember { mutableStateOf(1.0)}
        var phase = remember { mutableStateOf(1.0)}
        var wavePoint = remember { mutableStateOf(0.0)}
        var time = remember { mutableStateOf(0.0)}
        val dec = DecimalFormat("#,##0.00")
        val timeModifier = remember { mutableStateOf(1)}
        val freqValue = remember { mutableStateOf(4.0)}

        newWaveMaster.DoWave(freqValue.value) {
            //println("freqValue.value: ${freqValue.value}")
            Log.d(INFO.toString(), "freqValue.value: ${freqValue.value}")
            wavePoint.value = amplitude.value * Math.sin((2 * Math.PI * frequency.value * it) + phase.value)
            time.value = it
            if(time.value == 0.0){
                ndx++
                if(ndx >= 6){
                    //newWaveMaster.setStop()
                }
            }

        }

        BoxWithConstraints(modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)) {

            Text("[${  dec.format(time.value)}] [${dec.format(wavePoint.value)}]", modifier = Modifier.offset(
                x = 100.dp,
                y = 100.dp))

            Box(modifier = Modifier.offset(x=(1 + (time.value * (100 * timeModifier.value))).dp, y=(maxHeight/2) + (wavePoint.value * 100).dp)){
                Dot()
            }

            Column {
                Row{
                    Button(onClick = {
                        freqValue.value -= 2.0
                        timeModifier.value++ }) {
                        Text("λ+")
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Button(onClick = {
                        freqValue.value += 2.0
                        timeModifier.value-- }) {
                        Text("λ-")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = { amplitude.value++ }) {
                        Text("amp+")
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Button(onClick = { amplitude.value-- }) {
                        Text("amp-")
                    }
                }
                Row{
                    Button(onClick = { frequency.value++ }) {
                        Text("frq+")
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Button(onClick = { frequency.value-- }) {
                        Text("frq-")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = { phase.value = 1.0 }) {
                        Text("faz+")
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Button(onClick = { phase.value = -1.0 }) {
                        Text("faz-")
                    }
                }
            }

            Row{


            }


        }



    }
    @Composable
    fun Dot() =
        Spacer(
            Modifier
                .size(10.dp)
                .alpha(1f)
                .background(color = Color.Black, shape = CircleShape))
}

class NewWaveMaster {

    var isStop = false

    fun setStop(){
        this.isStop = true
    }


    @Composable
    fun DoWave(freqValue:Double, callback: (arg: Double) -> Unit) {

        if(isStop){
            Log.d(INFO.toString(), "stop")
            return
        }

        val infiniteTransition = rememberInfiniteTransition()

        val sineState = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = freqValue.toFloat(), //2.0f
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 5000,
                    easing = LinearEasing,
                    delayMillis = 1
                )
            )
        )

        callback(sineState.value.toDouble())
    }
}