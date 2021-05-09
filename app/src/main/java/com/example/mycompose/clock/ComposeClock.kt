package com.example.mycompose.clock

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.util.*


class ComposeClock {

    @Composable
    fun TickTock(){

        fun currentTime(): Time { // 1
            val cal = Calendar.getInstance()
            var ampm = "AM"
            if(cal.get(Calendar.HOUR_OF_DAY) > 12){
                ampm = "PM"
            }
            return Time(
                hours = cal.get(Calendar.HOUR_OF_DAY),
                minutes = cal.get(Calendar.MINUTE),
                seconds = cal.get(Calendar.SECOND),
                period = ampm
            )
        }

        var time = remember { mutableStateOf(currentTime()) } // 2

        LaunchedEffect(0) { // 3
            while (true) {
                time.value = currentTime()
                delay(1000)
            }
        }


        Clock(time.value)
    }

    @Composable
    fun Clock(time: Time){

        val hourType = remember { mutableStateOf("show 12 hr")}

        Period(time, hourType.value) // AM or PM

        Box(modifier = Modifier.offset(5.dp, 20.dp)){
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if(hourType.value == "show 12 hr"){ // this is reversed because button text expresses the outcome of onClick
                    HourNumberColumn(0..2, time.hours / 10)
                    HourNumberColumn(0..9, time.hours % 10)
                }else{
                    if(time.hours > 12){
                        time.hours = time.hours - 12
                    }
                    HourNumberColumn(0..12, time.hours)
                }

                Spacer(modifier = Modifier.width(16.dp))

                MinuteNumberColumn(0..5, time.minutes / 10)
                MinuteNumberColumn(0..9, time.minutes % 10)

                Spacer(modifier = Modifier.width(16.dp))

                SecondNumberColumn(0..5, time.seconds / 10)
                SecondNumberColumn(0..9, time.seconds % 10)
            }
        }

        Button(onClick = {
            if(hourType.value == "show 24 hr"){
                hourType.value = "show 12 hr"
            }else{
                hourType.value = "show 24 hr"
            }
        }) {
            Text(hourType.value)
        }

    }

    @Composable
    fun HourNumber(value: Int, active: Boolean, numColor: Color) {

        val backgroundColor: Color by animateColorAsState(
            if (active) {
                MaterialTheme.colors.primary
            } else {
                MaterialTheme.colors.background
            },
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 100,
                easing = FastOutLinearInEasing
            )
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .background(backgroundColor),
        ) {
            Text(
                text = value.toString(),
                fontSize = 20.sp,
                color = Color.White,
            )
        }
    }

    @Composable
    fun MinuteNumber(value: Int, active: Boolean, numColor: Color) {

        val backgroundColor: Color by animateColorAsState(
            targetValue =
                if (active) {
                    MaterialTheme.colors.primary
                } else {
                    MaterialTheme.colors.primaryVariant
                },
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 100,
                easing = FastOutLinearInEasing
            )
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .background(backgroundColor),
        ) {
            Text(
                text = value.toString(),
                fontSize = 20.sp,
                color = numColor,
            )
        }
    }

    @Composable
    fun SecondNumber(value: Int, active: Boolean, numColor: Color) {

        val backgroundColor: Color by animateColorAsState(
            targetValue =
            if (active) {
                MaterialTheme.colors.primary
            } else {
                MaterialTheme.colors.primaryVariant
            },
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 100,
                easing = FastOutLinearInEasing
            )
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .background(backgroundColor),
        ) {
            Text(
                text = value.toString(),
                fontSize = 20.sp,
                color = numColor,
            )
        }
    }


    @Composable
    fun HourNumberColumn(
        range: IntRange,
        current: Int,
    ) {
        val mid = (range.last - range.first) / 2f
        val offset by animateDpAsState(targetValue = 40.dp * (mid - current))

        Column(
            Modifier
                .offset(y = offset)
                .clip(RoundedCornerShape(percent = 25))
        ) {
            range.forEach { num ->
                HourNumber(num, num == current, Color.Magenta)
            }
        }

    }

    @Composable
    fun MinuteNumberColumn(
        range: IntRange,
        current: Int,
    ) {
        val mid = (range.last - range.first) / 2f
        val offset by animateDpAsState(targetValue = 40.dp * (mid - current))

        Column(
            Modifier
                .offset(y = offset)
                .clip(RoundedCornerShape(percent = 25))
        ) {
            range.forEach { num ->
                MinuteNumber(num, num == current, Color.Green)
            }
        }

    }

    @Composable
    fun SecondNumberColumn(
        range: IntRange,
        current: Int,
    ) {
        val mid = (range.last - range.first) / 2f
        val offset by animateDpAsState(
            targetValue = 40.dp * (mid - current),
            tween(1000, easing = CubicBezierEasing(0.4f, 0.0f, 0.8f, 0.8f)),)

        Column(
            Modifier
                .offset(y = offset)
                .clip(RoundedCornerShape(percent = 25))
        ) {
            range.forEach { num ->
                SecondNumber(num, num == current, Color.Cyan)
            }
        }

    }

    @Composable
    fun Period(time: Time, hourType:String){

        Box(modifier = Modifier.offset(10.dp, 400.dp)){
            if(hourType == "show 24 hr"){
                Text(time.period)
            }
        }
    }

}

data class Time(var hours: Int, val minutes: Int, val seconds: Int, val period: String)