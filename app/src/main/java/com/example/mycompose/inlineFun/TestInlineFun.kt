package com.example.mycompose.inlineFun

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class TestInlineFun {


    init {
        println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TestInlineFun !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
    }

    var desc = "When using inline functions, the compiler inlines the function body. That is, it " +
            "substitutes the body directly into places where the function gets called."


    @Composable
    fun StartTheShow() {

        val txt = remember { mutableStateOf(desc) }
        val change = remember { mutableStateOf(true) }

        Column {

            Text("TESTING INLINE FUNCTIONS")

            Spacer(modifier = Modifier.height(16.dp))

            Text(txt.value)

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                if (change.value) {
                    txt.value = txt.value.upperCaseify()
                } else {
                    txt.value = txt.value.lowerCaseify()
                }
                change.value = !change.value
            }) {
                if (change.value) {
                    Text(text = "click to change everything to UC")
                } else {
                    Text(text = "click to change everything to LC")
                }
            }
        }


    }

    fun wahat(arg: MutableState<String>) {

        val numbers = listOf(1, 2, 3, 4, 5)
        numbers.gago { println(it) }

        val chrs = listOf("1a", "2b", "3c", "4d", "5e")
        chrs.gago { println(it) }

        val chrx = listOf("1A", "2B", "3C", "4D", "5E")
        chrx.bago { println(it) }

    }

    inline fun <T> Collection<T>.gago(block: (T) -> Unit) {
        for (e in this) block(e)
    }

    private fun <T> Collection<T>.bago(block: (T) -> Unit) {
        for (e in this) block(e)
    }

    inline fun String.upperCaseify(): String {
        println("this =  $this")
        val chrs = this.toCharArray()
        var ndx = 0
        var rt = ""
        chrs.forEach {
            println("=====================> [$ndx] ${it.toTitleCase()}")
            ndx++
            rt += it.toTitleCase()
        }
        println(rt)
        return rt
    }

    inline fun String.lowerCaseify(): String {
        println("this =  $this")
        val chrs = this.toCharArray()
        var ndx = 0
        var rt = ""
        chrs.forEach {
            println("=====================> [$ndx] ${it.toLowerCase()}")
            ndx++
            rt += it.toLowerCase()
        }
        println(rt)
        return rt
    }


}