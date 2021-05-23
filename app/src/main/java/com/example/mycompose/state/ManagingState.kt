package com.example.mycompose.state

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.mycompose.text.SampleText

class ManagingState {


    @Composable
    fun DoManagingState(navController: NavController){


        Column{
            HelloScreenX()
            Button(onClick = {
                navController.navigate("menuTwo")
            }) {
                Text("menu")
            }

            ExpandingCard("Foo", SampleText.nowIsTheWinter)

            Fooby()
        }

    }

    @Composable
    fun HelloScreenX(helloViewModel: HelloViewModel = viewModel()) {
        // by default, viewModel() follows the Lifecycle as the Activity or Fragment
        // that calls HelloScreen(). This lifecycle can be modified by callers of HelloScreen.

        // name is the current value of [helloViewModel.name]
        // with an initial value of ""
        val name: String by helloViewModel.name.observeAsState("")
        val foo: String by helloViewModel.foo.observeAsState("")

        HelloContentX(name = name,  onNameChange = {
            helloViewModel.onNameChange(it)
            helloViewModel.onFooChange(it)
        })
    }

    @Composable
    fun HelloContentX(name: String, onNameChange: (String) -> Unit) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Hello, $name",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
            OutlinedTextField(
                value = name,
                onValueChange = onNameChange,
                label = { Text("Name") }
            )
        }
    }

    @Composable
    fun HelloScreen() {
        var name by remember { mutableStateOf("") }
        HelloContent(name = name, onNameChange = { name = it })
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
                onValueChange = onNameChange,
                label = { Text("Name") }
            )
        }
    }

    @Composable
    fun ExpandingCard(title: String, body: String) {
        var expanded by remember { mutableStateOf(false) }

        // describe the card for the current state of expanded
        Card {
            Column(
                Modifier
                    .width(280.dp)
                    .animateContentSize() // automatically animate size when it changes
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .verticalScroll(ScrollState(0))
            ) {
                Text(text = title, Modifier.clickable { expanded = !expanded })

                // content of the card depends on the current value of expanded
                if (expanded) {
                    Text(text = body, Modifier.padding(top = 8.dp))
                    // change expanded in response to click events
                    IconButton(onClick = { expanded = false }, modifier = Modifier.fillMaxWidth()) {
                        Icon(imageVector = Icons.Default.ExpandLess, contentDescription = "Expand less")
                    }
                } else {
                    // change expanded in response to click events
                    IconButton(onClick = { expanded = true }, modifier = Modifier.fillMaxWidth()) {
                        Icon(imageVector = Icons.Default.ExpandMore, contentDescription = "Expand more")
                    }
                }
            }
        }
    }

    @Composable
    fun Fooby(){

        var n0 = false
        var n1 = false
        var n2 = false
        var n3 = false
        var n4 = false

        val listN = remember { mutableStateListOf<Boolean>(n0, n1, n2, n3, n4) }
        val revList = listN.asReversed()

        fun changeColor(){
            println("before > n0:${listN[0]} n1:${listN[1]} n2:${listN[2]} n3:${listN[3]} n4:${listN[4]}")
            if(!listN[0] && !listN[1] && !listN[2] && !listN[3] && !listN[4]){
                listN[0] = true
            }else if(listN[0] && !listN[1] && !listN[2] && !listN[3] && !listN[4]){
                listN[0] = false
                listN[1] = true
            }else if(!listN[0] && listN[1] && !listN[2] && !listN[3] && !listN[4]){
                listN[1] = false
                listN[2] = true
            }else if(!listN[0] && !listN[1] && listN[2] && !listN[3] && !listN[4]){
                listN[2] = false
                listN[3] = true
            }else if(!listN[0] && !listN[1] && !listN[2] && listN[3] && !listN[4]){
                listN[3] = false
                listN[4] = true
            }else if(!listN[0] && !listN[1] && !listN[2] && !listN[3] && listN[4]){
                listN[4] = false
            }
        }

        fun changeKolor(){
            println("before > n0:${revList[0]} n1:${revList[1]} n2:${revList[2]} n3:${revList[3]} n4:${revList[4]}")
            if(!revList[0] && !revList[1] && !revList[2] && !revList[3] && !revList[4]){
                revList[0] = true
            }else if(revList[0] && !revList[1] && !revList[2] && !revList[3] && !revList[4]){
                revList[0] = false
                revList[1] = true
            }else if(!revList[0] && revList[1] && !revList[2] && !revList[3] && !revList[4]){
                revList[1] = false
                revList[2] = true
            }else if(!revList[0] && !revList[1] && revList[2] && !revList[3] && !revList[4]){
                revList[2] = false
                revList[3] = true
            }else if(!revList[0] && !revList[1] && !revList[2] && revList[3] && !revList[4]){
                revList[3] = false
                revList[4] = true
            }else if(!revList[0] && !revList[1] && !revList[2] && !revList[3] && revList[4]){
                revList[4] = false
            }
        }

        fun doFooColor():Color{
            println("n0:${listN[0]} n1:${listN[1]} n2:${listN[2]} n3:${listN[3]} n4:${listN[4]} < after")
            return when{
                listN[0] -> Color.Black
                listN[1] -> Color.Green
                listN[2] -> Color.Blue
                listN[3] -> Color.Red
                listN[4] -> Color.Cyan
                else -> Color.Transparent
            }
        }

        fun doFooKolor():Color{
            println("n0:${revList[0]} n1:${revList[1]} n2:${revList[2]} n3:${revList[3]} n4:${revList[4]} < after")
            return when{
                revList[0] -> Color.Black
                revList[1] -> Color.Green
                revList[2] -> Color.Blue
                revList[3] -> Color.Red
                revList[4] -> Color.Cyan
                else -> Color.Transparent
            }
        }

        Box(modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .background(color = doFooColor())){
            Box(modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color.White)
                .align(Alignment.Center)
                .background(color = doFooKolor())){
                Button(onClick = {
                    changeColor()
                    //changeKolor()
                }) {
                    Text("color?")
                }
            }
        }
    }

}

class HelloViewModel : ViewModel() {

    // LiveData holds state which is observed by the UI
    // (state flows down from ViewModel)
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    // onNameChange is an event we're defining that the UI can invoke
    // (events flow up from UI)
    fun onNameChange(newName: String) {
        _name.value = newName
    }


    // foo
    private val _foo = MutableLiveData("")
    val foo: LiveData<String> = _foo
    fun onFooChange(newFoo: String) {
        _foo.value = newFoo
    }


}

