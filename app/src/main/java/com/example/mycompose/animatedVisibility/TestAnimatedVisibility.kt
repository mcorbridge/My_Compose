package com.example.mycompose.animatedVisibility

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

class TestAnimatedVisibility {




    @ExperimentalAnimationApi
    @Composable
    fun RunTransition() {

        var visible = remember { mutableStateOf(false) }

        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {


                Button(onClick = { visible.value = !visible.value }, modifier = Modifier.offset(x=100.dp, y=400.dp)) {
                    Text("run")
                }

                AnimatedVisibility(
                    visible = visible.value,
                    enter = slideInHorizontally(initialOffsetX = { -100 }) ,
                    exit = slideOutHorizontally(),
                ) {
                    Column(){
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Boston Bruins are in the playoffs!",)
                    }

                }
        }





    }



}