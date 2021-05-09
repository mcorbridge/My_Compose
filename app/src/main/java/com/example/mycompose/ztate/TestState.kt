package com.example.mycompose.ztate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mycompose.ui.theme.CormorantTypography
import com.example.mycompose.image.ImageActivity
import com.example.mycompose.image.ImageActivity.Companion.TitleComponent

class TestState {


    companion object {


        @Composable
        fun MakeState() {

            Column{
                Text(
                    "This is a test of State",
                    style = CormorantTypography.h2,
                    fontWeight = FontWeight.ExtraBold
                )

                StateComponent()

                ModelComponent()

                CheckBoss()
            }


        }

        @Composable
        fun StateComponent() {

            var counter = remember {
                mutableStateOf(0)
            }

            TitleComponent("Example using state class to store state")

            Row(modifier = Modifier.fillMaxWidth()) {
                // This Row consists of two buttons. We wanted to ensure that both these buttons occupy
                // equal amount of width. We do that by using the LayoutWeight modifier and passing equal
                // weight to both the buttons. This is similar to how we used layout_weight with
                // LinearLayouts in the old Android UI Toolkit.
                Button(
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    elevation = ButtonDefaults.elevation(5.dp),
                    // We increment the counter every time this button is clicked.
                    onClick = {
                        counter.value++
                    }) {
                    // The Text composable is pre-defined by the Compose UI library; you can use this
                    // composable to render text on the screen
                    Text(text = "Increment", modifier = Modifier.padding(5.dp))
                }

                Button(
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    elevation = ButtonDefaults.elevation(5.dp),
                    onClick = {
                        counter.value = 0
                    }) {
                    Text(text = "Reset", modifier = Modifier.padding(16.dp))
                }
            }

            // This text composable is just used to display the current value of the counter.
            Text(text = "Counter value is ${counter.value}", modifier = Modifier.padding(16.dp))
        }


        @Composable
        fun ModelComponent() {

            var counterState = remember { mutableStateOf(CounterState()) }

            TitleComponent("Example using Model class to store state")

            Row(modifier = Modifier.fillMaxWidth()) {

                Button(
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    elevation = ButtonDefaults.elevation(5.dp),
                    onClick = {
                        counterState.value = counterState.value.copy(counter = counterState.value.counter + 1)
                        counterState.value.bar = "Fuck you asshole!"
                    }) {

                    Text(text = "Increment", modifier = Modifier.padding(5.dp))
                }

                Button(
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    elevation = ButtonDefaults.elevation(5.dp),
                    onClick = {
                        counterState.value = counterState.value.copy(counter = 0)
                    }) {
                    Text(text = "Reset", modifier = Modifier.padding(16.dp))
                }
            }
            // This text composable is just used to display the current value of the counter.
            Text(text = "${counterState.value.bar} is ${counterState.value.counter}", modifier = Modifier.padding(16.dp))
        }

        @Composable
        fun CheckBoss(){

            var checkState = remember { mutableStateOf(CheckState()) }

            checkState.value.things.forEach {
                println(it)
            }
            Row{
                println("CheckBoss:Row")

                Text(checkState.value.bar)

                Button(onClick = { checkState.value.bar = "FooBar" }) {
                    Text("click")
                }

                Checkbox(
                    checked = checkState.value.things[0],
                    onCheckedChange = { checked ->
                        println("1. checked? $checked ${System.currentTimeMillis()}")
                        checkState.value.things[0] = checked
                        println("2. checked? $checked ${System.currentTimeMillis()}")
                        println("3. counterState.value.things[0]? ${checkState.value.things[0]} ${System.currentTimeMillis()}")
                        checkState.value.bar = "FooBar"
                    }
                )

                Checkbox(
                    checked = checkState.value.things[1],
                    onCheckedChange = {

                    }
                )

                Checkbox(
                    checked = checkState.value.things[2],
                    onCheckedChange = {

                    }
                )
                Checkbox(
                    checked = checkState.value.things[3],
                    onCheckedChange = {

                    }
                )

                Checkbox(
                    checked = checkState.value.things[4],
                    onCheckedChange = {

                    }
                )

                Checkbox(
                    checked = true,
                    onCheckedChange = null,
                )
            }
        }



    }//end companion object

} //end class

data class CounterState(val counter:Int = 0,
                        val foo:Int = 0,
                        var bar:String = "Counter value",
                        var things:MutableList<Boolean> = mutableListOf(true,false,true,false,true))

data class CheckState(val counter:Int = 0,
                        val foo:Int = 0,
                        var bar:String = "CheckState",
                        var things:MutableList<Boolean> = mutableListOf(true,false,true,false,true))