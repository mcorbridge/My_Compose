package com.example.mycompose.utils

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import java.nio.file.WatchEvent


class YopComposablex {

    @Composable fun NewFooText(){
        Text("Hello there YopComposablex! From a separate klass!!", color = Color.Red, modifier = Modifier.clickable {
            println("I was clicked")
        })
    }

}
