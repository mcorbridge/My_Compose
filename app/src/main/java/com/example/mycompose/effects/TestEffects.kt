package com.example.mycompose.effects

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import com.example.mycompose.R

class TestEffects {

    companion object{

        @Composable
        fun LandingScreen(onTimeout: () -> Unit) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                // Adds composition consistency. Use the value when LaunchedEffect is first called
                val currentOnTimeout by rememberUpdatedState(onTimeout)

                LaunchedEffect(Unit) {
                    println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> LaunchedEffect")
                    delay(10000)
                    currentOnTimeout()
                }
                Column{
                    Image(painterResource(id = R.drawable.jpk_space), contentDescription = "foo")
                }

            }
        }



    }
}