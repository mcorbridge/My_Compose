package com.example.mycompose.animatedVisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TestAnimatedVisibility {


    @ExperimentalAnimationApi
    @Composable
    fun RunTransition() {

        val mapleLeafBlue = Color(0, 32, 91, 225)
        val bostonBruinsGold = Color(252,181,20, 225)
        val floridaPanthersRed = Color(200,16,46, 225)
        val floridaPanthersNavy = Color(4,30,66, 225)
        val floridaPanthersTan = Color(185,151,91, 225)

        val visible = remember { mutableStateOf(false) }
        val fooColor = remember { mutableStateOf(Color.Green)}
        val ndx = remember { mutableStateOf(0)}

        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

            Column {
                AnotherAnimated()

                Button(
                    onClick = { visible.value = !visible.value },
                    modifier = Modifier.offset(x = 100.dp, y = 400.dp)
                ) {
                    Text("run")
                }

                AnimatedVisibility(
                    visible = visible.value,
                    enter = slideInHorizontally(initialOffsetX = { -100 }),
                    exit = slideOutHorizontally(),
                ) {
                    Column {
                        Text("Toronto Maple Leafs are in the playoffs!", color = mapleLeafBlue, fontSize = 46.sp)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!", color = bostonBruinsGold, fontSize = 46.sp)
                        Box(modifier = Modifier.height(6.dp).fillMaxWidth().background(color = floridaPanthersNavy))
                        Text("Florida Panthers are in the playoffs!", color = floridaPanthersRed, fontSize = 46.sp)
                        Box(modifier = Modifier.height(6.dp).fillMaxWidth().background(color = floridaPanthersTan))
                        Text("foo",
                            color = fooColor.value,
                            fontSize = 46.sp,
                            letterSpacing = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            onTextLayout = {println("onTextLayout: foo")},
                            textDecoration = TextDecoration.Underline,
                            fontFamily = FontFamily.Cursive,
                            modifier = Modifier.clickable {
                                changeTextColor(fooColor, ndx.value)
                                if(ndx.value == 5){
                                    ndx.value = 0
                                }else{
                                    ndx.value++
                                }

                            })
                    }
                }
            }
        }
    }

    private fun changeTextColor(color: MutableState<Color>, ndx:Int){
        var mapleLeafBlue = Color(0, 32, 91, 225)
        val bostonBruinsGold = Color(252,181,20, 225)
        val floridaPanthersRed = Color(200,16,46, 225)
        val floridaPanthersNavy = Color(4,30,66, 225)
        val floridaPanthersTan = Color(185,151,91, 225)

        color.value = when(ndx){
            0 -> mapleLeafBlue
            1 -> bostonBruinsGold
            2 -> floridaPanthersRed
            3 -> floridaPanthersNavy
            4 -> floridaPanthersTan
            else -> Color.Black
        }


    }

    @ExperimentalAnimationApi
    @Composable
    fun AnotherAnimated() {
        var editable = remember { mutableStateOf(true) }

        Column {

            Button(onClick = { editable.value = !editable.value }) {
                Text(text = "editable.value ${editable.value}")
            }

            Spacer(modifier = Modifier.height(10.dp))

            AnimatedVisibility(visible = editable.value) {
                Text(text = "Simplest Possible Animated Visibility")
            }

        }


    }


}