package com.example.mycompose.checkbox

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class TestCheckbox {

    companion object {
        @RequiresApi(Build.VERSION_CODES.N)
        @Composable
        fun MakeCheckboxes() {

            val checkedState0 = remember { mutableStateOf(true) }
            val checkedState1 = remember { mutableStateOf(true) }
            val chkList = remember { mutableStateListOf<Boolean>() }
            var isLoaded = remember { mutableStateOf(false) }
            val alphabet: MutableList<String> = mutableListOf(
                "a", "b", "c", "d",
                "e", "f", "g", "h",
                "i", "j", "k", "l",
                "m", "n", "o", "p",
                "q", "r", "s", "t",
                "u", "v", "w", "x",
                "y", "z"
            )

            if (!isLoaded.value) {
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                chkList.add(false)
                isLoaded.value = true
            }

            println(chkList.size)

            Column {
                Row {
                    Checkbox(
                        checked = chkList[0],
                        modifier = Modifier.padding(16.dp),
                        onCheckedChange = {
                            chkList[0] = it
                            chkList[1] = !it
                            chkList[2] = !it
                            chkList[3] = !it
                            chkList[4] = !it
                            chkList[5] = !it
                            chkList[6] = !it
                            chkList[7] = !it
                            chkList[8] = !it
                        },
                    )
                    Checkbox(
                        checked = chkList[1],
                        modifier = Modifier.padding(16.dp),
                        onCheckedChange = {
                            chkList[0] = !it
                            chkList[1] = it
                            chkList[2] = !it
                            chkList[3] = !it
                            chkList[4] = !it
                            chkList[5] = !it
                            chkList[6] = !it
                            chkList[7] = !it
                            chkList[8] = !it
                        },
                    )
                    Checkbox(
                        checked = chkList[2],
                        modifier = Modifier.padding(16.dp),
                        onCheckedChange = {
                            chkList[0] = !it
                            chkList[1] = !it
                            chkList[2] = it
                            chkList[3] = !it
                            chkList[4] = !it
                            chkList[5] = !it
                            chkList[6] = !it
                            chkList[7] = !it
                            chkList[8] = !it
                        },
                    )
                }
                Row {
                    Checkbox(
                        checked = chkList[3],
                        modifier = Modifier.padding(16.dp),
                        onCheckedChange = {
                            chkList[0] = !it
                            chkList[1] = !it
                            chkList[2] = !it
                            chkList[3] = it
                            chkList[4] = !it
                            chkList[5] = !it
                            chkList[6] = !it
                            chkList[7] = !it
                            chkList[8] = !it
                        },
                    )
                    Checkbox(
                        checked = chkList[4],
                        modifier = Modifier.padding(16.dp),
                        onCheckedChange = {
                            chkList[0] = !it
                            chkList[1] = !it
                            chkList[2] = !it
                            chkList[3] = !it
                            chkList[4] = it
                            chkList[5] = !it
                            chkList[6] = !it
                            chkList[7] = !it
                            chkList[8] = !it
                        },
                    )
                    Checkbox(
                        checked = chkList[5],
                        modifier = Modifier.padding(16.dp),
                        onCheckedChange = {
                            chkList[0] = !it
                            chkList[1] = !it
                            chkList[2] = !it
                            chkList[3] = !it
                            chkList[4] = !it
                            chkList[5] = it
                            chkList[6] = !it
                            chkList[7] = !it
                            chkList[8] = !it
                        },
                    )
                }
                Row {
                    Checkbox(
                        checked = chkList[6],
                        modifier = Modifier.padding(16.dp),
                        onCheckedChange = {
                            chkList[0] = !it
                            chkList[1] = !it
                            chkList[2] = !it
                            chkList[3] = !it
                            chkList[4] = !it
                            chkList[5] = !it
                            chkList[6] = it
                            chkList[7] = !it
                            chkList[8] = !it
                        },
                    )
                    Checkbox(
                        checked = chkList[7],
                        modifier = Modifier.padding(16.dp),
                        onCheckedChange = {
                            chkList[0] = !it
                            chkList[1] = !it
                            chkList[2] = !it
                            chkList[3] = !it
                            chkList[4] = !it
                            chkList[5] = !it
                            chkList[6] = !it
                            chkList[7] = it
                            chkList[8] = !it
                        },
                    )
                    Checkbox(
                        checked = chkList[8],
                        modifier = Modifier.padding(16.dp),
                        onCheckedChange = {
                            chkList[0] = !it
                            chkList[1] = !it
                            chkList[2] = !it
                            chkList[3] = !it
                            chkList[4] = !it
                            chkList[5] = !it
                            chkList[6] = !it
                            chkList[7] = !it
                            chkList[8] = it
                        },
                    )
                }

                var ndx = 0

                alphabet.forEach {
                    CustomObject.SetCustomObject(it, chkList, ndx)
                    ndx++
                }

            }
        } // end fun MakeCheckboxes

    } // end companion object
} // end class

class CustomObject {

    companion object {

        @Composable
        fun SetCustomObject(arg0: String, list: MutableList<Boolean>, ndx: Int) {

            var status = remember { mutableStateOf("") }

            Row(
                modifier = Modifier.border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = RectangleShape
                )
            ) {
                Text(
                    text = arg0,
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.25f)
                        .padding(5.dp)
                        .border(2.dp, MaterialTheme.colors.secondary, RectangleShape)
                        .background(MaterialTheme.colors.primary, RectangleShape)
                        .padding(5.dp)
                )
                Checkbox(
                    checked = list[ndx],
                    modifier = Modifier.padding(5.dp),
                    onCheckedChange = {
                        list[ndx] = it
                        if (it)
                            status.value = "selected"
                        else
                            status.value = ""
                    })
                Text(status.value, modifier = Modifier.width(100.dp))

            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }

}

data class CheckState(

    var things: MutableList<Boolean> = mutableListOf(
        true,
        false,
        true,
        false,
        true,
        true,
        false,
        true,
        false,
        true,
        true,
        false,
        true,
        false,
        true
    )
)