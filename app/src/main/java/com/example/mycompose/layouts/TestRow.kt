package com.example.mycompose.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.mycompose.ui.theme.CormorantTypography

class TestRow {


    var magicNum = getMagicNumber()
    var winMsg = "Default"

    @Composable
    fun ThisTestRow(navController: NavController) {


        var barColor by remember {
            mutableStateOf(
                Color(
                    red = 1f,
                    green = 0.7f,
                    blue = 0.1f,
                    alpha = 1.0f
                )
            )
        }

        val fooColor = Color(red = 0f, green = 0f, blue = 0f, alpha = 0.2f)

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = fooColor),
            Arrangement.SpaceEvenly
        ) {
            Text(winMsg, style = CormorantTypography.h4, color = Color.Blue, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = barColor),
                Arrangement.SpaceEvenly
            ) {

                Button(onClick = {
                    barColor = changeColor(1)
                    doFoo(1)
                    navController.navigate("ninthScreen")
                }) {
                    Text("1")
                }
                Button(onClick = {
                    barColor = changeColor(2)
                    doFoo(2)
                }) {
                    Text("2")
                }

                Button(onClick = {
                    barColor = changeColor(3)
                    doFoo(3)
                }) {
                    Text("3")
                }

                Button(onClick = {
                    barColor = changeColor(4)
                    doFoo(4)
                }) {
                    Text("4")
                }

                Button(onClick = {
                    barColor = changeColor(5)
                    doFoo(5)
                }) {
                    Text("5")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = barColor),
                Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    barColor = changeColor(6)
                    doFoo(6)
                }) {
                    Text("6")
                }
                Button(onClick = {
                    barColor = changeColor(7)
                    doFoo(7)
                }) {
                    Text("7")
                }

                Button(onClick = {
                    barColor = changeColor(7)
                    doFoo(8)
                }) {
                    Text("8")
                }

                Button(onClick = {
                    barColor = changeColor(7)
                    doFoo(9)
                }) {
                    Text("9")
                }

                Button(onClick = {
                    barColor = changeColor(7)
                    doFoo(10)
                }) {
                    Text("10")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = barColor),
                Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    barColor = changeColor(7)
                    doFoo(11)
                }) {
                    Text("11")
                }
                Button(onClick = { doFoo(12) }) {
                    Text("12")
                }

                Button(onClick = {
                    barColor = changeColor(13)
                    doFoo(13)
                }) {
                    Text("13")
                }

                Button(onClick = {
                    barColor = changeColor(14)
                    doFoo(14)
                }) {
                    Text("14")
                }

                Button(onClick = {
                    barColor = changeColor(15)
                    doFoo(15)
                }) {
                    Text("15")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = barColor),
                Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    barColor = changeColor(16)
                    doFoo(16)
                }) {
                    Text("16")
                }
                Button(onClick = {
                    barColor = changeColor(17)
                    doFoo(17)
                }) {
                    Text("17")
                }

                Button(onClick = {
                    barColor = changeColor(18)
                    doFoo(18)
                }) {
                    Text("18")
                }

                Button(onClick = {
                    barColor = changeColor(19)
                    doFoo(19)
                }) {
                    Text("19")
                }

                Button(onClick = {
                    barColor = changeColor(20)
                    doFoo(20)
                }) {
                    Text("20")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = barColor),
                Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    barColor = changeColor(21)
                    doFoo(21)
                }) {
                    Text("21")
                }
                Button(onClick = {
                    barColor = changeColor(22)
                    doFoo(22)
                }) {
                    Text("22")
                }

                Button(onClick = {
                    barColor = changeColor(23)
                    doFoo(23)
                }) {
                    Text("23")
                }

                Button(onClick = {
                    barColor = changeColor(24)
                    doFoo(24)
                }) {
                    Text("24")
                }

                Button(onClick = {
                    barColor = changeColor(25)
                    doFoo(25)
                }) {
                    Text("25")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = barColor),
                Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    barColor = changeColor(26)
                    doFoo(26)
                }) {
                    Text("26")
                }
                Button(onClick = {
                    barColor = changeColor(27)
                    doFoo(27)
                }) {
                    Text("27")
                }

                Button(onClick = {
                    barColor = changeColor(28)
                    doFoo(28)
                }) {
                    Text("28")
                }

                Button(onClick = {
                    barColor = changeColor(29)
                    doFoo(29)
                }) {
                    Text("29")
                }

                Button(onClick = {
                    barColor = changeColor(30)
                    doFoo(30)
                }) {
                    Text("30")
                }
            }
        }
    }

    private fun makeRndColor(): Color {
        val red: Float = ((1..10).random()) / 10f
        val green: Float = ((1..10).random()) / 10f
        val blue: Float = ((1..10).random()) / 10f
        val alpha: Float = ((1..10).random()) / 10f
        println("$red $green $blue $alpha")
        var color = Color(red = red, green = green, blue = blue, alpha = alpha)
        println(" -----color.toString()------> $color")
        return color
    }

    private fun doFoo(arg0: Int) {
        if (arg0 == this.magicNum) {
            println("!!!!!!!!!!!!!! YOU WIN !!!!!!!!!!!!!")
            winMsg = "!!!!!!!!!!!!!! YOU WIN !!!!!!!!!!!!!"
            this.magicNum = getMagicNumber()
        } else {
            winMsg = "...keep looking"
        }
    }

    private fun changeColor(arg0: Int): Color {
        return when (arg0) {
            1 -> Color(red = 0.6f, green = 0.2f, blue = 0.9f, alpha = 1.0f)
            2 -> Color(red = 0.2f, green = 0.7f, blue = 0.1f, alpha = 1.0f)
            3 -> Color(red = 1f, green = 0.3f, blue = 0.1f, alpha = 1.0f)
            4 -> Color(red = 0.8f, green = 0.4f, blue = 0.7f, alpha = 1.0f)
            5 -> Color(red = 0.11f, green = 0.34f, blue = 1.0f, alpha = 1.0f)
            else -> makeRndColor()
        }
    }

    fun getMagicNumber(): Int {
        return (1..30).random()
    }


}