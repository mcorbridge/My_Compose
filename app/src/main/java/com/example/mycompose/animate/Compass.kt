package com.example.mycompose.animate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycompose.R
import com.example.mycompose.compassRose.Bearing
import com.example.mycompose.compassRose.TempColor
import com.example.mycompose.models.TestViewModel

class Compass(navController: NavController, testViewModel: TestViewModel) {



    companion object{

        @Composable
        fun DoWindBearing(rotation:Float){
            val compassRose: Painter = painterResource(id = R.drawable.compass_rose)
            val compassArrow: Painter = painterResource(id = R.drawable.arrow)
            var xPos by remember { mutableStateOf(55)}
            var yPos by remember { mutableStateOf(-5)}
            var rot by remember { mutableStateOf(rotation)}

            Column{
                Box(modifier = Modifier.offset(100.dp, 10.dp)){
                    Image(
                        modifier = Modifier
                            .background(color = Color.Transparent ),
                        alpha = 0.5f,
                        painter = compassRose,
                        contentDescription = "A compass rose",
                    )
                    Image(
                        modifier = Modifier
                            .offset(xPos.dp, yPos.dp)
                            .rotate(rot),
                        painter = compassArrow,
                        contentDescription = "A compass arrow",
                    )
                }

                Text("Wind Bearing: ${Bearing.findBearing(rot)}")

            }

        }


    }


    @Composable
    fun DoCompass(){

        val compassRose: Painter = painterResource(id = R.drawable.compass_rose)
        val compassArrow: Painter = painterResource(id = R.drawable.arrow)
        val compassSize = 400.dp
        val arrowSize = 400.dp

        var xPos by remember { mutableStateOf(55)}
        var yPos by remember { mutableStateOf(-5)}
        var rot by remember { mutableStateOf(0f)}
        var xPosText by remember { mutableStateOf("") }
        var yPosText by remember { mutableStateOf("") }
        var rotationText by remember { mutableStateOf("") }

        Column{


            Column{
                Box(modifier = Modifier.offset(100.dp, 10.dp)){
                    Image(
                        modifier = Modifier
                            .background(color = Color.Transparent ),
                        alpha = 0.5f,
                        painter = compassRose,
                        contentDescription = "A compass rose",
                    )
                    Image(
                        modifier = Modifier
                            .offset(xPos.dp, yPos.dp)
                            .rotate(rot),
                        painter = compassArrow,
                        contentDescription = "A compass arrow",
                    )
                }

                Text("Wind Bearing: ${Bearing.findBearing(rot)}")
            }


            Spacer(modifier = Modifier.height(16.dp))

//            Row{
//                Button(onClick = {
//                    xPos--
//                    println("xPos: $xPos  yPos: $yPos rotation: $rot")
//                }) {
//                    Text("x--")
//                }
//
//                Spacer(modifier = Modifier.width(16.dp))
//
//                Button(onClick = {
//                    xPos++
//                    println("xPos: $xPos  yPos: $yPos rotation: $rot")
//                }) {
//                    Text("x++")
//                }
//
//                Spacer(modifier = Modifier.width(32.dp))
//
//                Button(onClick = {
//                    yPos--
//                    println("xPos: $xPos  yPos: $yPos rotation: $rot")
//                }) {
//                    Text("y--")
//                }
//
//                Spacer(modifier = Modifier.width(16.dp))
//
//                Button(onClick = {
//                    yPos++
//                    println("xPos: $xPos  yPos: $yPos rotation: $rot")
//                }) {
//                    Text("y++")
//                }
//
//            }

  //          Spacer(modifier = Modifier.height(32.dp))

//            Row{
//
//                OutlinedTextField(
//                    value = xPosText,
//                    onValueChange = { xPosText = it },
//                    label = { Text("xPos") }
//                )
//
//                Spacer(modifier = Modifier.width(16.dp))
//
//                Button(onClick = {
//
//                    xPos = xPosText.toInt()
//
//                }) {
//                    Text("xPos")
//                }
//            }

//            Spacer(modifier = Modifier.height(2.dp))
//
//            Row{
//                OutlinedTextField(
//                    value = yPosText,
//                    onValueChange = { yPosText = it },
//                    label = { Text("yPos") }
//                )
//
//                Spacer(modifier = Modifier.width(16.dp))
//
//                Button(onClick = {
//
//                    yPos = yPosText.toInt()
//
//                }) {
//                    Text("yPos")
//                }
//            }

            Spacer(modifier = Modifier.height(2.dp))

            Row{
                Button(onClick = {
                    rot--
                    println("xPos: $xPos  yPos: $yPos rotation: $rot")
                }) {
                    Text("rotate--")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(onClick = {
                    rot++

                }) {
                    Text("rotate++")
                }

                Spacer(modifier = Modifier.width(16.dp))

            }

            Spacer(modifier = Modifier.height(2.dp))


            Row{

                OutlinedTextField(
                    value = rotationText,
                    onValueChange = { rotationText = it },
                    label = { Text("rotation") }
                )

                Spacer(modifier = Modifier.width(16.dp))

                Button(onClick = {

                    rot = rotationText.toFloat()

                }) {
                    Text("rotate")
                }

            }

            var tempColor = TempColor()
            tempColor.Test()



        }







    }



}