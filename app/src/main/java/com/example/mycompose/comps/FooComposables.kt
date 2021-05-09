package com.example.mycompose.comps

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.example.mycompose.models.TestViewModel

class FooComposables {

    var barComposables = BarComposables()
    var xutComposables = XutComposables()
    var yopComposables = YopComposables()

    @Composable
    fun NewFooText(testViewModel: TestViewModel) {

        var count by remember { mutableStateOf(testViewModel.kounter.value) }
        var kolor by remember { mutableStateOf(testViewModel.color.value) }
        var poo by remember { mutableStateOf(true)}

        Column {
            kolor?.let { Text("Hello there From a FooComposables klass!!", color = it) }
            barComposables.NewFooText(kolor!!)
             /* xutComposables.NewFooText()
             yopComposables.NewFooText()*/
        }
        Button(onClick = {
            println("pressed")
            count = count?.plus(1)
            testViewModel.onKounterChanged(count!!)
            kolor = Color.Yellow
            testViewModel.onColorChanged(kolor!!)
        }) {
            Text(text = "press me $count")
        }

    }
}
