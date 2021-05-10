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

class FirstTransitionScreen {

    @ExperimentalAnimationApi
    @Composable
    fun ShowScreen(navController: NavController, testViewModel: TestViewModel) {

        var visible = remember { mutableStateOf(true) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Blue)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                Button(onClick = {
                    navController.navigate("secondAnimationScreen")
                }) {
                    Icon(
                        Icons.Filled.Landscape,
                        "sealed",
                        tint = Color.White,
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                    )
                    Text(text = "->")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = { visible.value =  !visible.value}) {

                }

                Spacer(modifier = Modifier.height(10.dp))

                AnimatedVisibility(
                    visible = visible.value,
                    enter = slideInVertically(
                        initialOffsetY = { -140 },
                        animationSpec = tween(1000,10)
                    ) + expandVertically(
                        expandFrom = Alignment.Top
                    ) + fadeIn(initialAlpha = 0.0f, animationSpec = tween(250,250)),
                    exit = slideOutVertically() + shrinkVertically() + fadeOut()
                ) {
                    TestingText.CustomStyledText(
                        SampleText.nowIsTheWinter,
                        style = TextStyle(
                            fontFamily = FontFamily.Cursive,
                            color = Color.White,
                            fontSize = 30.sp
                        )
                    )
                }

            }
        }
    }
}