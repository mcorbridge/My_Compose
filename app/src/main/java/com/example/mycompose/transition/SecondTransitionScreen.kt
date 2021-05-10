package com.example.mycompose.transition

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Landscape
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.Nature
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.mycompose.models.TestViewModel
import com.example.mycompose.text.SampleText
import com.example.mycompose.text.TestingText

class SecondTransitionScreen {

    @ExperimentalAnimationApi
    @Composable
    fun ShowScreen(navController: NavController, testViewModel: TestViewModel) {

        val visible = remember { mutableStateOf(testViewModel.visible) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Yellow)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                Button(onClick = {
                    navController.navigate("firstAnimationScreen")
                }) {
                    Text(text = "<-")
                    Icon(
                        Icons.Filled.Landscape,
                        "sealed",
                        tint = Color.White,
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = {
                    testViewModel.visible = !testViewModel.visible
                }) {
                    Icon(
                        Icons.Filled.Nature,
                        "*",
                        tint = Color.White,
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                    )
                    Text(text = "${testViewModel.visible}")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = { visible.value = !visible.value }) {
                    Text("clicky ${ visible.value }")
                }

                Spacer(modifier = Modifier.height(10.dp))

                AnimatedVisibility(
                    visible = visible.value,
                    enter = slideInVertically(
                        initialOffsetY = { -500 },
                        animationSpec = tween(2000, 0)
                    ) + expandVertically(
                        expandFrom = Alignment.Top
                    ) + fadeIn(initialAlpha = 0.0f, animationSpec = tween(3000, 0)),
                    exit = fadeOut(targetAlpha = 0f, animationSpec = tween(1000, 0))
                ) {
                    TestingText.CustomStyledText(
                        SampleText.nowIsTheWinter,
                        style = TextStyle(
                            fontFamily = FontFamily.Cursive,
                            color = Color.Blue,
                            fontSize = 30.sp
                        )
                    )
                }

            }
        }
    }
}

