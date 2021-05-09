package com.example.mycompose.comps

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class BarComposables {


    @Composable fun NewFooText(kolor:Color){
        Column{
            Text("Hello there! From a separate BarComposables!!", color = kolor)
        }

    }
}