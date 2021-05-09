package com.example.mycompose.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mycompose.MainActivity

class BarComposablex {


    @Composable
    fun NewFooText() {

        Text("Hello there BarComposablex! From a separate klass!!",
            color = Color.Cyan, modifier = Modifier.padding(16.dp))
    }
}
