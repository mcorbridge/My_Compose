package com.example.mycompose.transition

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PanoramaFishEye
import androidx.compose.material.icons.filled.Segment
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.mycompose.models.TestViewModel

class SecondTransitionScreen {

    @Composable
    fun ShowScreen(navController: NavController, testViewModel: TestViewModel){
        Box(modifier = Modifier.fillMaxSize().background(color = Color.Yellow)){
            Button(onClick = {
                navController.navigate("firstAnimationScreen")
            }) {
                Icon(
                    Icons.Filled.PanoramaFishEye,
                    "<-",
                    tint = Color.White,
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
                Text(text = "<-")
            }
        }
    }

}