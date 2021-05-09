package com.example.mycompose.animate

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

class AnimateAs {

    @Composable
    fun DoStateAnimations(){

        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            //DoAnimateColorAsState()
            //DoAnimateSizeAsState()
            DoAnimateAngleAsState()
        }


    }

    @Composable
    fun DoAnimateColorAsState(){
        var trueColor = remember { mutableStateOf(false)}

        val animatedColor0:Color by animateColorAsState(
            targetValue = if(trueColor.value){
                Color.Cyan
            }else{
                Color.Black
            },
        animationSpec = snap(1000),
            finishedListener = { println("trueColor.value ===========> ${trueColor.value}") }
        )

        println("animatedColor0.value ==========> ${animatedColor0.value}")

        val animatedColor1:Color by animateColorAsState(
            targetValue = if(trueColor.value){
                Color.Magenta
            }else{
                Color.LightGray
            },
            animationSpec = tween(
                durationMillis = 2000,
                delayMillis = 40,
                easing = LinearOutSlowInEasing
        ),
            finishedListener = { println("trueColor.value ===========> ${trueColor.value}") }
        )

        println("animatedColor1.value ==========> ${animatedColor1.value}")

        Box(modifier = Modifier
            .offset(10.dp, 10.dp)
            .height(100.dp)
            .width(100.dp)
            .background(animatedColor0)){
            Button(onClick = {
                trueColor.value = !trueColor.value
            }) {
                Text("snap")
            }
        }

        Box(modifier = Modifier
            .offset(10.dp, 120.dp)
            .height(100.dp)
            .width(100.dp)
            .background(animatedColor1)){
            Button(onClick = {
                trueColor.value = !trueColor.value
            }) {
                Text("tween")
            }
        }
    }

    @Composable
    fun DoAnimateSizeAsState() {
        var trueSize = remember { mutableStateOf(true) }

        val animSize : IntSize by animateIntSizeAsState(
            targetValue = if(trueSize.value){
                IntSize(350,100)
            }else{
                IntSize(100,500)
            },
            animationSpec = tween(1000)
        )

        Box(modifier = Modifier
            .offset(10.dp, 120.dp)
            .height(animSize.height.dp)
            .width(animSize.width.dp)
            .background(Color.Blue)){
            Button(onClick = {
                trueSize.value = !trueSize.value
            }) {
                Text("tween")
            }
        }

    }

    @Composable
    fun DoAnimateAngleAsState() {
        var trueAngle = remember { mutableStateOf(true) }

        val animAngle: Int by animateIntAsState(
            targetValue = if (trueAngle.value) {
                0
            } else {
                360 * 10
            },
            animationSpec = tween(5000),
            finishedListener = {trueAngle.value = !trueAngle.value}
        )

        Box(modifier = Modifier
            .offset(10.dp, 120.dp)
            .height(200.dp)
            .width(200.dp)
            .rotate(animAngle.toFloat())
            .background(Color.Blue)){
            Button(onClick = {
                trueAngle.value = !trueAngle.value
            }) {
                Text("angle")
            }
        }
    }

}