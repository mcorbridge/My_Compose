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

        var n0 by remember { mutableStateOf(false) }
        var n1 by remember { mutableStateOf(false) }
        var n2 by remember { mutableStateOf(false) }
        var n3 by remember { mutableStateOf(false) }
        var n4 by remember { mutableStateOf(false) }

        fun changeColor(){
            println("before > n0:$n0 n1:$n1 n2:$n2 n3:$n3 n4:$n4")
            if(!n0 && !n1 && !n2 && !n3 && !n4){
                n0 = true
            }else if(n0 && !n1 && !n2 && !n3 && !n4){
                n0 = false
                n1 = true
            }else if(!n0 && n1 && !n2 && !n3 && !n4){
                n1 = false
                n2 = true
            }else if(!n0 && !n1 && n2 && !n3 && !n4){
                n2 = false
                n3 = true
            }else if(!n0 && !n1 && !n2 && n3 && !n4){
                n3 = false
                n4 = true
            }else if(!n0 && !n1 && !n2 && !n3 && n4){
                n4 = false
            }

        }

        fun doFooColor():Color{
            println("n0:$n0 n1:$n1 n2:$n2  n3:$n3 n4:$n4 < after")
            return when{
                n0 -> Color.Black
                n1 -> Color.Green
                n2 -> Color.Blue
                n3 -> Color.Red
                n4 -> Color.Cyan
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
                .align(Alignment.Center)){
                Button(onClick = { changeColor() }) {
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

