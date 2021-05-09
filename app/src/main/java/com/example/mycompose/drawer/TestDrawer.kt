package com.example.mycompose.drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.mycompose.ui.theme.CormorantTypography
import kotlinx.coroutines.launch
import com.example.mycompose.R

class TestDrawer {

    lateinit var nav:NavController
    lateinit var thisDrawerState:DrawerState

    @Composable
    fun ThisDrawer(navController: NavController) {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        nav = navController


        ModalDrawer(

            drawerState = drawerState,

            drawerContent = {
                thisDrawerState = drawerState
                Column {

                    Text(stringResource(R.string.hello), style = CormorantTypography.h1)

                    Text("Go to -> Welcome", style = CormorantTypography.h2, modifier = Modifier.clickable{doNav(0)})

                    Text("Go to -> Two", style = CormorantTypography.h2, modifier = Modifier.clickable{doNav(1)})

                    Text("Go to -> Three", style = CormorantTypography.h2, modifier = Modifier.clickable{doNav(2)})

                    Text("Go to -> Four", style = CormorantTypography.h2, modifier = Modifier.clickable{doNav(3)})

                    Text("Go to -> Ten", style = CormorantTypography.h2, modifier = Modifier.clickable{doNav(10)})

                    Text("Close", style = CormorantTypography.h2, modifier = Modifier.clickable{
                        scope.launch {
                            drawerState.close()
                        }
                    })
                }
            }

        ) {
            Column {
                Text("Text in Body context", style = CormorantTypography.h3)
                Button(onClick = {

                    scope.launch {
                        drawerState.open()
                    }

                }) {
                    Text("Click to open")
                }
            }
        }
    }

    private fun doNav(arg0:Int){
        when(arg0){
            0 -> nav.navigate("welcome")
            1 -> nav.navigate("secondScreen")
            2 -> nav.navigate("thirdScreen")
            3 -> nav.navigate("fourthScreen")
            4 -> nav.navigate("fifthScreen")
            10 -> nav.navigate("tenthScreen")
        }
    }


}