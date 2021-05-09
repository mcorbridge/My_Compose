package com.example.mycompose.scaffold

import android.net.wifi.WifiConfiguration.AuthAlgorithm.strings
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.mycompose.ui.theme.CormorantTypography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class TestScaffold {


    /**
     *
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    isFloatingActionButtonDocked: Boolean = false,
    drawerContent: @Composable (ColumnScope.() -> Unit)? = null,
    drawerGesturesEnabled: Boolean = true,
    drawerShape: Shape = MaterialTheme.shapes.large,
    drawerElevation: Dp = DrawerDefaults.Elevation,
    drawerBackgroundColor: Color = MaterialTheme.colors.surface,
    drawerContentColor: Color = contentColorFor(drawerBackgroundColor),
    drawerScrimColor: Color = DrawerDefaults.scrimColor,
    backgroundColor: Color = MaterialTheme.colors.background,
    contentColor: Color = contentColorFor(backgroundColor),
    content: @Composable (PaddingValues) -> Unit
     */

    var state: MutableState<MutableList<String>> = mutableStateOf(mutableListOf("open", "closed"))
    lateinit var nav:NavController
    lateinit var navx:NavController
    lateinit var scaffoldState:ScaffoldState
    lateinit var scope:CoroutineScope

    @Composable
    fun createTestScaffold() {

        val materialBlue700 = Color(0xFF1976D2)
        scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        scope = rememberCoroutineScope()

        Scaffold(

            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    title = { Text("TopAppBar") },
                    backgroundColor = materialBlue700
                )
            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                    Text("X")
                }
            },
            drawerContent = { FooDrawerContent() },
            content = { FooContent() },
            bottomBar = { BottomAppBar(backgroundColor = materialBlue700) { Text("BottomAppBar") } },
            drawerBackgroundColor = Color.LightGray
        )

    }


    @Composable
    fun makeTestScaffold(navController: NavController) {
        this.nav = navController
        createTestScaffold()
    }

    @Composable
    fun FooContent() {

        val screenNavController = rememberNavController()
        navx = screenNavController

        NavHost(screenNavController, startDestination = "welcomex") {
            composable("welcomex") {
                WelcomexScreen()
            }

            composable("secondxScreen") {
                SecondxScreen()
            }

            composable("thirdxScreen") {
                ThirdxScreen()
            }
        }
    }

    @Composable
    fun WelcomexScreen() {
        Text("WelcomexScreen", modifier = Modifier.clickable { println("WelcomexScreen") })
    }

    @Composable
    fun SecondxScreen() {
        Text("SecondxScreen", modifier = Modifier.clickable { println("SecondxScreen") })
    }

    @Composable
    fun ThirdxScreen() {
        Text("ThirdxScreen", modifier = Modifier.clickable { println("ThirdxScreen") })
    }

    @Composable
    fun FooTopBar() {
        Row {
            Text("One", modifier = Modifier.clickable { println("One") })
            Text("Two", modifier = Modifier.clickable { println("Two") })
            Text("Three", modifier = Modifier.clickable { println("Three") })
        }
    }

    @Composable
    fun FooBottomBar() {
        Row {
            Text("Four", modifier = Modifier.clickable { println("Four") })
            Text("Five", modifier = Modifier.clickable { println("Five") })
            Text("Six", modifier = Modifier.clickable { println("Six") })
        }
    }

    @Composable
    fun FooDrawerContent() {
        Column {
            Text("Text in Drawer", style = CormorantTypography.h2)

            Text("Go to -> Welcome", style = CormorantTypography.h2, modifier = Modifier.clickable{doNav(0)})

            Text("Go to -> Two", style = CormorantTypography.h2, modifier = Modifier.clickable{doNav(1)})

            Text("Go to -> Three", style = CormorantTypography.h2, modifier = Modifier.clickable{doNav(2)})

            Text("Go to -> Four", style = CormorantTypography.h2, modifier = Modifier.clickable{doNav(3)})

            Text("Go to -> Ten", style = CormorantTypography.h2, modifier = Modifier.clickable{doNav(10)})

            Text("Go to -> Welcomex", style = CormorantTypography.h2, modifier = Modifier.clickable{doNav(11)})

            Text("Go to -> Twox", style = CormorantTypography.h2, modifier = Modifier.clickable{doNav(12)})

            Text("Go to -> Threex", style = CormorantTypography.h2, modifier = Modifier.clickable{doNav(13)})

        }

    }

    private fun doNav(arg0:Int){

        println("destination: $arg0")

        when(arg0){
            0 -> nav.navigate("welcome")
            1 -> nav.navigate("secondScreen")
            2 -> nav.navigate("thirdScreen")
            3 -> nav.navigate("fourthScreen")
            4 -> nav.navigate("fifthScreen")
            10 -> nav.navigate("tenthScreen")

            11 -> navx.navigate("welcomex")
            12 -> navx.navigate("secondxScreen")
            13 -> navx.navigate("thirdxScreen")
        }

        closeDrawer()
    }

    fun closeDrawer(){
        scope.launch {
            scaffoldState.drawerState.close()
        }
    }

}