package com.example.mycompose.hoisting

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


/**
 * State hoisting is a programming pattern where you move the state of a composable to the caller
 * of that composable. A simple way to do this is by replacing the state with a parameter and using
 * lambdas to represent events.
 *
 * Key Term:  STATE HOISTING IS A PATTERN OF MOVING STATE UP THE TREE TO MAKE A COMPONENT STATELESS
 */

class TestStateHoisting {


    companion object {

        @ExperimentalFoundationApi
        @Composable
        fun AllComposables() {
            Column {
                HelloScreen()
                LazeeListyScreen()
            }

        }


        @Composable
        fun HelloScreen() {
            var name by rememberSaveable { mutableStateOf("") }
            var namez by remember { mutableStateOf("") }

            Column {
                HelloContent(name = name, onNameChange = { name = it })
                HelloContent(name = namez, onNameChange = { namez = it })
            }

        }

        @Composable
        fun HelloContent(name: String, onNameChange: (String) -> Unit) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Hello, $name",
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.h5
                )
                OutlinedTextField(
                    value = name,
                    onValueChange = { onNameChange(it) },
                    label = { Text("Name") }
                )
            }
        }

        @ExperimentalFoundationApi
        @Composable
        fun LazeeListyScreen() {
            var selectedItemList: MutableList<String> = remember { mutableStateListOf<String>() }
            var isLoaded by remember { mutableStateOf(false) }

            if (!isLoaded) {
                selectedItemList.add("a")
                selectedItemList.add("b")
                selectedItemList.add("c")
                selectedItemList.add("d")
                selectedItemList.add("e")
                selectedItemList.add("f")
                selectedItemList.add("g")
                selectedItemList.add("h")
                selectedItemList.add("i")
                selectedItemList.add("j")
                selectedItemList.add("k")
                selectedItemList.add("l")
                selectedItemList.add("m")
                selectedItemList.add("n")
                selectedItemList.add("o")
                selectedItemList.add("p")
                selectedItemList.add("q")
                selectedItemList.add("r")
                selectedItemList.add("s")
                selectedItemList.add("t")
                selectedItemList.add("u")
                selectedItemList.add("v")
                selectedItemList.add("w")
                selectedItemList.add("x")
                selectedItemList.add("y")
                selectedItemList.add("z")
                isLoaded = true
            }

            println("selectedItemList.size===========> ${selectedItemList.size}")
            LazeeListyContent(list = selectedItemList)
        }

        @ExperimentalFoundationApi
        @Composable
        fun LazeeListyContent(list: MutableList<String>) {

            var chkLst:MutableList<Any> = mutableListOf()

            println("--------------------LazeeListyContent-------------------------")

            var chkdState = remember { mutableStateOf(true)}

            LazyColumn(reverseLayout = false, contentPadding = PaddingValues(50.dp)) {

                println("--------------------LazyColumn-------------------------")

                stickyHeader { Text("Lazy List") }

                items(list) { item ->
                    println("=====> $item")
                    LazeeItem(item, chkdState,
                        onClickItem = { println("--------$it clicked-----------") },
                        onFoo = { println("--------$item pressed-----------")})
                }
            }
        }

        fun doFoo(item:String){
            println("--------$item pressed-----------")
        }

        @Composable
        fun LazeeItem(item: String, ckSt:MutableState<Boolean>, onClickItem: (String) -> Unit, onFoo: () -> Unit) {

            val checkedState = remember { mutableStateOf(true) }

            println("--------------------LazeeItem [$item] ------------------------- ${System.currentTimeMillis()}")

            Row {
                Text(item, modifier = Modifier.width(50.dp))
                Checkbox(
                    checked = ckSt.value,
                    onCheckedChange = {
                        ckSt.value = it
                        onClickItem(item)
                        onFoo()
                    }
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
        }

    }


}


