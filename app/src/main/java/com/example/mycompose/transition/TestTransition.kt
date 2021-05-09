package com.example.mycompose.transition

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.mycompose.animatedVisibility.TestAnimatedVisibility
import com.example.mycompose.models.TestViewModel
import kotlinx.coroutines.delay

class TestTransition {

    var deviceWidth:Dp = 0.dp
    var deviceHeight:Dp = 0.dp

    @ExperimentalAnimationApi
    @Composable
    fun DoTransition(navController: NavController, testViewModel: TestViewModel) {

        val testAnimatedVisibility = TestAnimatedVisibility()
        testAnimatedVisibility.RunTransition()

        return

        deviceWidth =  testViewModel.getScreenDims().first.dp
        deviceHeight =  testViewModel.getScreenDims().second.dp

        val isInit = remember { mutableStateOf(true) }
        val boxText = remember { mutableStateOf("") }
        val moveBox = remember { mutableStateOf(false) }

        LaunchedEffect(0) {

            while (isInit.value) {
                delay(250)
                isInit.value = false
                boxText.value = "Hello!"
                moveBox.value = true
            }

        }

        val offsetX: Dp by animateDpAsState(
            if (moveBox.value) 0.dp else deviceWidth,
        )

        if (!isInit.value) {
            Button(onClick = {
                moveBox.value = !moveBox.value
            }) {
                Text("hello")
            }
        }


        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset(x = offsetX)
                .background(color = Color.Black)
        ) {
            Column{
                Text(text = boxText.value, color = Color.White)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    moveBox.value = !moveBox.value
                }) {
                    Text("goodbye")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    navController.navigate("thirtyThirdScreen")
                }) {
                    Text("Next")
                }
            }

        }

    }

    @Composable
    fun DoAnimateDpAsState(moveBox: Boolean) {

        var offsetToggle = remember { mutableStateOf(true) }

        val offsetX: Dp by animateDpAsState(
            if (moveBox) 0.dp else deviceWidth,
        )

        Box(
            modifier = Modifier
                .offset(offsetX, 400.dp)
                .height(200.dp)
                .width(200.dp)
                .background(Color.White)
        ) {
            Button(onClick = {
                offsetToggle.value = !offsetToggle.value
            }) {
                Text("tween")
            }
        }

    }


}