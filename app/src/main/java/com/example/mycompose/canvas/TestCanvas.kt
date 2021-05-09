package com.example.mycompose.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate

class TestCanvas {

    var fooColor = Color(red = 0f, green = 0f, blue = 1f, alpha = 0.4f)

    lateinit var thisNavController:NavController

    @Composable
    fun Squares(navController: NavController) {

        this.thisNavController = navController

        Box(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .background(color = Color.LightGray)
        ) {
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            drawLine(
                start = Offset(x = canvasWidth, y = 0f),
                end = Offset(x = 0f, y = canvasHeight),
                color = fooColor,
                strokeWidth = 30f
            )
            drawLine(
                start = Offset(y = canvasHeight, x = canvasWidth / 2),
                end = Offset(y = 0f, x = canvasWidth / 2),
                color = fooColor,
                strokeWidth = 30f
            )
            drawLine(
                start = Offset(x = canvasWidth, y = canvasHeight),
                end = Offset(x = 0f, y = 0f),
                color = fooColor,
                strokeWidth = 30f
            )
            drawLine(
                start = Offset(x = canvasWidth, y = canvasHeight / 2),
                end = Offset(x = 0f, y = canvasHeight / 2),
                color = fooColor,
                strokeWidth = 30f
            )
            drawLine(
                start = Offset(x = canvasWidth, y = (canvasHeight / 2) / 2),
                end = Offset(x = 0f, y = (canvasHeight * 3) / 4),
                color = fooColor,
                strokeWidth = 20f
            )
            drawLine(
                start = Offset(x = -5f, y = (canvasHeight / 2) / 2),
                end = Offset(x = canvasWidth + 5, y = (canvasHeight * 3) / 4),
                color = fooColor,
                strokeWidth = 20f
            )
        }
        Text("Canvas?")
    }

    @Composable
    fun CircleShapeDemo(navController: NavController) {

        Box(modifier = Modifier
            .absoluteOffset(y = 100.dp)
            .clickable {
                navController.navigate("sixthScreen")
            }) {
            ExampleBox(shape = CircleShape, 250f, Color.Black)
            ExampleBox(shape = CircleShape, 200f, Color.Blue)
            ExampleBox(shape = CircleShape, 150f, Color.Red)
            ExampleBox(shape = CircleShape, 100f, Color.Yellow)
        }

    }

    @Composable
    fun ExampleBox(shape: Shape, size: Float, color: Color) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .clip(shape)
        ) {
            Box(
                modifier = Modifier
                    .size(size.dp)
                    .background(color)

            ) { }

        }
    }

    @Composable
    fun EmptyCanvas() {
        Canvas(modifier = Modifier
            .fillMaxSize()
            .background(color = fooColor)
            .clickable { this.thisNavController.navigate("welcome") },
            onDraw = {
            drawCircle(
                Color.Black,
                radius = 400f,
                center = Offset(size.width / 2f, size.height / 2f)
            )
            drawCircle(
                Color.Blue,
                radius = 300f,
                center = Offset(size.width / 2f, size.height / 2f)
            )
            drawCircle(
                Color.Red,
                radius = 200f,
                center = Offset(size.width / 2f, size.height / 2f)
            )
            drawCircle(
                Color.Yellow,
                radius = 100f,
                center = Offset(size.width / 2f, size.height / 2f),
            )
        })
    }

    @Composable
    fun MyRect(){

        //density-independent pixels (dp)

        val pxValue = with(LocalDensity.current) { 16.dp.toPx() }

        println("pxValue.dp ===========> ${pxValue.dp.value}")

        Canvas(modifier = Modifier
            .height(600.dp).width(300.dp)
            .absoluteOffset(0.dp, 0.dp)
            .background(Color.Yellow), onDraw = {
            println("draw Black rectangle")
            drawRect(color = Color.Black, size = Size(500f, 1640f), topLeft = Offset(0f, 0f)) // 2.73
        })

        /*Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
            println("draw Red rectangle")
            drawRect(color = Color.Red, size = Size(500f, 330f), topLeft = Offset(0f, 330f))
        })

        Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
            println("draw Green rectangle")
            drawRect(color = Color.Green, size = Size(500f, 330f), topLeft = Offset(0f, 330f*2))
        })

        Canvas(modifier = Modifier.fillMaxSize(), topLeft = Offset(0f, 330f*3), onDraw = {
            println("draw Yellow rectangle")
            drawRect(color = Color.Yellow, size = Size(500f, 330f))
        })*/
    }


} //end class











