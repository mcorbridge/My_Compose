package com.example.mycompose.coroutine

import android.location.Location
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import com.example.mycompose.destructuring.TestDestructuring
import com.example.mycompose.models.TestViewModel
import kotlinx.coroutines.launch

class TestComposeCoroutine(navController: NavController, testViewModel: TestViewModel) {


    @Composable
    fun DoTestCoroutine(){

        println("*************************************** TestComposeCoroutine ***************************************")

        val testDestructuring = TestDestructuring()
        testDestructuring.doTest()

    }

    private fun getLocation() {

    }




    @Composable
    fun FunWithLocation() {
        // Returns a scope that's cancelled when FunWithLocation is removed from composition
        val coroutineScope = rememberCoroutineScope()

        val (location, setLocation) = remember { mutableStateOf<Location?>(null) }


        val getLocationOnClick: () -> Unit = {
            coroutineScope.launch {
                val location = getLocation()
            }
        }

        Button(onClick = getLocationOnClick) {
            Text("detectLocation")
        }
    }


}

