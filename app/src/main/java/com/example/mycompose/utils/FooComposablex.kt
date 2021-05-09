package com.example.mycompose.utils

import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class FooComposablex {

    var barComposablex = BarComposablex()
    var xutComposablex = XutComposablex()
    var yopComposablex = YopComposablex()


    @ExperimentalAnimationApi
    @Composable
    fun NewFooText(){

        var xisible by remember { mutableStateOf(true)}

        Column {
            Text("Hello there! From a separate FooComposablex!!")
            //barComposablex.NewFooText()
            //xutComposablex.NewFooText()
            //yopComposablex.NewFooText()
            AnimatedVisibility(
                visible = xisible,
                enter = slideInVertically(
                    initialOffsetY = { -40 }
                ) + expandVertically(
                    expandFrom = Alignment.Top
                ) + fadeIn(initialAlpha = 0.3f),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()
            ) {
                Text(">>>>>>>>>>>>>>>>>>>>>>>>> Hello",
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp))
            }
        }

    }
}

