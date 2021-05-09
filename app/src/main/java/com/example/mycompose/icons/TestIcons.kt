package com.example.mycompose.icons

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycompose.R

class TestIcons {


    companion object {

        var fooColor = Color(red = 0f, green = 0f, blue = 1f, alpha = 0.4f)
        var booColor = Color(0xffffe0b3)
        //var loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

        var loremIpsum = "b c d e f h a"

        var listem: List<String> = loremIpsum.split(" ").map { it.trim() }

        @ExperimentalFoundationApi
        @Composable
        fun doIcons(navController: NavController) {

            var foo by remember { mutableStateOf("foo")}

            var selectedItemList:MutableList<ItemData> = remember { mutableStateListOf<ItemData>() }

            // create the list to populate the lazyList
            listem.forEach{
                var tmp = ItemData()
                tmp.isSelected = false
                tmp.itemValue = it
                selectedItemList.add(tmp)
            }



            Row {

                Box(modifier = Modifier.background(color = booColor, shape = RectangleShape)) {
                    Column {
                        Text(stringResource(id = R.string.icon_name_a))
                        Icon(
                            Icons.Filled.Menu, "menu", tint = Color.Red,
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .clickable { doMenuClick(0) })   // ok
                        Icon(
                            Icons.Filled.Print,
                            "print",
                            tint = Color.Red,
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .clickable { doMenuClick(1) }) // ok
                        Icon(
                            Icons.Filled.ArrowCircleDown,
                            "menu",
                            tint = Color.Red,
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .clickable { doMenuClick(2) })   // ok
                        Icon(
                            Icons.Filled.AccessAlarm,
                            "print",
                            tint = Color.Red,
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .clickable { doMenuClick(3) }) // ok
                        Icon(
                            Icons.Filled.Air,
                            "menu",
                            tint = Color.Red,
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .clickable { doMenuClick(4) })   // ok
                        Icon(
                            Icons.Filled.BabyChangingStation,
                            "print",
                            tint = Color.Red,
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .clickable { doMenuClick(5) }) // ok
                        Icon(
                            Icons.Filled.Cabin,
                            "menu",
                            tint = fooColor,
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .clickable { doMenuClick(6) })   // ok
                        Icon(
                            Icons.Filled.ZoomOutMap,
                            "print",
                            tint = Color.Red,
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .clickable { doMenuClick(7) }) // ok
                    }

                }

                LazyColumn(reverseLayout = false, contentPadding = PaddingValues(50.dp)) {

                    stickyHeader {
                        Text("this is thus [foo]", modifier = Modifier.clickable {  })
                    }

                    items(selectedItemList) { item ->
                        ListItem(item, { foop(item) })
                        Spacer(modifier = Modifier.height(5.dp))
                    }
                }
                ZList()
            }
        }

        // callback... sorta
        private fun foop(item:ItemData) {
            println("************* Foo *************** ${System.currentTimeMillis()}")
            println(" ${item.itemValue} ${item.isSelected}")
        }


        @Composable
        fun ListItem(item: ItemData, goo:(itemData:ItemData) -> Unit) {

            var isSelected by remember { mutableStateOf(false)}

            if (isSelected) {
                Box(
                    modifier = Modifier
                        .border(width = 1.dp, Color.Red, shape = RectangleShape)
                        .width(100.dp)
                ) {
                    Text(item.itemValue, modifier = Modifier
                        .clickable {
                            isSelected = false
                            item.isSelected = false
                            goo(item)
                        }
                        .padding(16.dp))
                }
            } else {
                Box(
                    modifier = Modifier
                        .border(width = 1.dp, Color.Black, shape = RectangleShape)
                        .width(100.dp)
                ) {
                    Text(item.itemValue, modifier = Modifier
                        .clickable {
                            isSelected = true
                            item.isSelected = true
                            goo(item)
                        }
                        .padding(16.dp))
                }
            }

        }

        @Composable
        fun ZList(){
            val selectedList:MutableList<String> = remember { mutableStateListOf<String>() }

            selectedList.add("a" )
            selectedList.add("b" )

            println(selectedList.size)

            XList(selectedList)

        }

        @Composable
        fun XList(selectedList:MutableList<String>){

            Box(modifier = Modifier
                .height(400.dp)
                .width(200.dp)
                .background(color = Color.Black)){
               /* Column{

                    selectedList.forEach {
                        Text( "z", modifier = Modifier.clickable {  }, color = Color.White, fontSize = 40.sp)
                    }
                    Text( selectedList[0], modifier = Modifier.clickable {  }, color = Color.White, fontSize = 40.sp)

                }*/
                Button(onClick = {selectedList.add("c")}){
                    Text("click")
                }
            }
        }


        private fun doMenuClick(arg0: Int) {
            println("|---------------------> YOU PRESSED: [${arg0}]")
        }

    }//end companion object


}// end class

class ItemData {
    var isSelected: Boolean = false
    var itemValue: String = ""
} //end class

