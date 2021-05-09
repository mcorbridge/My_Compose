package com.example.mycompose.animate

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.dp

class TestAnimate {

    @Composable
    fun AnimateAsStateDemo() {

        var blue by remember { mutableStateOf(true) }

        val kolor by animateColorAsState(if (blue) Blue else Red)

        Column {
            Button(onClick = { blue = !blue }) {
                Text("Change Color")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.size(128.dp).background(kolor)) {

            }
        }

    }



    @Composable
    fun CrossfadeDemo() {
        var currentColor by remember { mutableStateOf(MyColorz.Red) }
        Column {
            Row {
                MyColorz.values().forEach { myColorz ->
                    Button(
                        onClick = { currentColor = myColorz },
                        Modifier.weight(1f, true)
                            .height(48.dp)
                            .background(myColorz.color),
                        colors = ButtonDefaults.buttonColors(backgroundColor = myColorz.color)
                    ) {
                        Text(myColorz.name)
                    }
                }
            }
            Crossfade(targetState = currentColor, animationSpec = tween(1000)) { selectedColor ->
                Box(modifier = Modifier.fillMaxSize().background(selectedColor.color))
            }
        }
    }

}  // end class

enum class MyColorz(val color: Color) {
    Red(Color.Red), Green(Color.Green), Blue(Color.Blue)
}