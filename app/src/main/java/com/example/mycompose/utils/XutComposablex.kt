package com.example.mycompose.utils

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class XutComposablex {


        @Composable fun NewFooText(){
            Text("Hello there XutComposablex! From a separate klass!!", color = Color.Red, modifier = Modifier.clickable {
                println("I was clicked")
            })
        }
    }
