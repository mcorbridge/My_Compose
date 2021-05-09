package com.example.mycompose.transition

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.mycompose.models.TestViewModel
import kotlinx.coroutines.delay

class TransitionTo {

    var deviceWidth: Dp = 0.dp
    var deviceHeight: Dp = 0.dp

    @Composable
    fun NewTransition(navController: NavController, testViewModel: TestViewModel){

        deviceWidth =  testViewModel.getScreenDims().first.dp
        deviceHeight =  testViewModel.getScreenDims().second.dp

        val isInit = remember { mutableStateOf(true) }
        val boxText = remember { mutableStateOf("TransitionTo") }
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

        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset(x = offsetX)
                .background(color = Color.Blue)
        ) {
            Text(text = boxText.value, color = Color.White)
            Button(onClick = {
                moveBox.value = !moveBox.value
                navController.navigate("thirtySecondScreen")
            }) {
                Text("goodbye")
            }
        }


    }


}