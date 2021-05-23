package com.example.mycompose.room

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

class TestingRoom {

    var bgColor = Color(0xFFF1BE48)

    @Composable
    fun DoTestRoom(navController: NavController) {

        BoxWithConstraints(modifier = Modifier
            .background(color = bgColor)
            .fillMaxSize()) {

            DoMenuButton(navController)

        }

    }

    @Composable
    fun DoMenuButton(navController: NavController) {

        Column {
            Button(onClick = {
                navController.navigate("menuTwo")
            }) {
                Text("<- back")
            }
        }
    }

}