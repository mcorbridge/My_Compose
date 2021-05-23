package com.example.mycompose

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.mycompose.animate.*
import com.example.mycompose.canvas.TestCanvas
import com.example.mycompose.checkbox.TestCheckbox
import com.example.mycompose.clock.ComposeClock
import com.example.mycompose.comps.FooComposables
import com.example.mycompose.dragdrop.TestDragDrop
import com.example.mycompose.drawer.TestDrawer
import com.example.mycompose.effects.TestEffects
import com.example.mycompose.firebase.TestFirestore
import com.example.mycompose.hoisting.TestStateHoisting
import com.example.mycompose.icons.TestIcons
import com.example.mycompose.image.TestImage
import com.example.mycompose.inlineFun.TestInlineFun
import com.example.mycompose.layouts.TestRow
import com.example.mycompose.menu.MenuTwo
import com.example.mycompose.models.TestViewModel
import com.example.mycompose.nhl.AnotherNHL
import com.example.mycompose.nhl.ShowNHL
import com.example.mycompose.room.TestingRoom
import com.example.mycompose.scaffold.TestScaffold
import com.example.mycompose.sealed.TestSealedClass
import com.example.mycompose.sinWave.*
import com.example.mycompose.state.ManagingState
import com.example.mycompose.text.TestingText
import com.example.mycompose.transition.*
import com.example.mycompose.ui.theme.MyComposeTheme
import com.example.mycompose.utils.FooComposablex
import com.example.mycompose.ztate.TestState
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    var isTrue = true
    var ndx = 0
    var thisInsult: String = "STOP CLICKING ME!!!!!!!!!!!!!!!!"

    private val testViewModel by viewModels<TestViewModel>()

    var fooComposables = FooComposables()
    var fooComposablex = FooComposablex()
    var testAnimate = TestAnimate()
    var testCanvas = TestCanvas()
    var testRow = TestRow()
    var testDrawer = TestDrawer()
    var testScaffold = TestScaffold()


    @RequiresApi(Build.VERSION_CODES.N)
    @ExperimentalFoundationApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO send screen dimensions to all composable screens

        testViewModel.setScreenDims(applicationContext)

        /*setContent {

            MyApp {
                val fooState = remember { mutableStateOf("Foo State") }
                //MyScreenContent()
                //LazyColumnDemo()
                //FooLazyColumn()
                //MyComposeList()
                //HelloContent()("foo")
                //NamePicker("Pick A Name!",nmList) {}
                TestColumn()
                TestText("fooState")
            }

        }*/

        setContent {

            MyComposeTheme {

                val navController = rememberNavController()

                NavHost(navController, startDestination = "welcome") {

                    composable("welcome") {
                        WelcomeScreen(navController, testViewModel)
                    }

                    composable("secondScreen") {
                        SecondScreen(navController, testViewModel)
                    }

                    composable("thirdScreen") {
                        ThirdScreen(navController, testViewModel)
                    }

                    composable("fourthScreen") {
                        FourthScreen(navController, testViewModel)
                    }

                    composable("fifthScreen") {
                        FifthScreen(navController, testViewModel)
                    }

                    composable("sixthScreen") {
                        SixthScreen(navController, testViewModel)
                    }

                    composable("seventhScreen") {
                        SeventhScreen(navController, testViewModel)
                    }

                    composable("eighthScreen") {
                        EighthScreen(navController, testViewModel)
                    }

                    composable("ninthScreen") {
                        NinthScreen(navController, testViewModel)
                    }

                    composable("tenthScreen") {
                        TenthScreen(navController, testViewModel)
                    }

                    composable("eleventhScreen") {
                        EleventhScreen(navController, testViewModel)
                    }

                    composable("twelvthScreen") {
                        TwelvthScreen(navController, testViewModel)
                    }

                    composable("thirteenthScreen") {
                        ThirteenthScreen(navController, testViewModel)
                    }

                    composable("menuTwo") {
                        MenuTwo(navController, testViewModel)
                    }

                    composable("fourteenthScreen") {
                        FourteenthScreen(navController, testViewModel)
                    }

                    composable("fifthteenthScreen") {
                        FifthteenthScreen(navController, testViewModel)
                    }

                    composable("sixteenthScreen") {
                        SixteenthScreen(navController, testViewModel)
                    }

                    composable("seventeenthScreen") {
                        SeventeenthScreen(navController, testViewModel)
                    }

                    composable("eighteenthScreen") {
                        EighteenthScreen(navController, testViewModel)
                    }

                    composable("nineteenthScreen") {
                        NineteenthScreen(navController, testViewModel)
                    }

                    composable("twentiethScreen") {
                        TwentiethScreen(navController, testViewModel)
                    }

                    composable("twentyFirstScreen") {
                        TwentyFirstScreen(navController, testViewModel)
                    }

                    composable("twentySecondScreen") {
                        TwentySecondScreen(navController, testViewModel)
                    }

                    composable("twentyThirdScreen") {
                        TwentyThirdScreen(navController, testViewModel)
                    }

                    composable("twentyFourthScreen") {
                        TwentyFourthScreen(navController, testViewModel)
                    }

                    composable("twentyFifthScreen") {
                        TwentyFifthScreen(navController, testViewModel)
                    }

                    composable("twentySixthScreen") {
                        TwentySixthScreen(navController, testViewModel)
                    }

                    composable("twentySeventhScreen") {
                        TwentySeventhScreen(navController, testViewModel)
                    }

                    composable("twentyEightScreen") {
                        TwentyEightScreen(navController, testViewModel)
                    }

                    composable("twentyNinthScreen") {
                        TwentyNinthScreen(navController, testViewModel)
                    }

                    composable("thirtiethScreen") {
                        ThirtiethScreen(navController, testViewModel)
                    }

                    composable("thirtyFirstScreen") {
                        ThirtyFirstScreen(navController, testViewModel)
                    }

                    composable("thirtySecondScreen") {
                        ThirtySecondScreen(navController, testViewModel)
                    }

                    composable("thirtyThirdScreen") {
                        ThirtyThirdScreen(navController, testViewModel)
                    }

                    composable("thirtyFourthScreen") {
                        ThirtyFourthScreen(navController, testViewModel)
                    }

                    composable("firstAnimationScreen") {
                            ScreenTransitions.ExampleAnimation{
                                FirstAnimationScreen(navController, testViewModel)
                            }
                        }

                    composable("secondAnimationScreen") {
                        ScreenTransitions.ExampleAnimation{
                            SecondAnimationScreen(navController, testViewModel)
                        }
                    }

                    composable("nhlScreen") {
                        ScreenTransitions.ExampleAnimation{
                            NHLScreen(navController, testViewModel)
                        }
                    }

                    composable("managingState") {
                        ScreenTransitions.ExampleAnimation{
                            ManagingState(navController, testViewModel)
                        }
                    }

                    composable("roomDatabase") {
                        ScreenTransitions.ExampleAnimation{
                            RoomDatabase(navController, testViewModel)
                        }
                    }

                }
            }
        }



        /*setContent {
            MyComposeTheme {

                // A surface container using the 'background' color from the theme
                Surface(color = Teal200) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        //Greeting("Wally")
                        //BostonBruins()
                        //SimpleText("I am learning Compose")
                        //TextWithPaddingFromBaseline()
                        //ButtonExample()
                        //ExpandingCard("Lorem Ipsum", loremIpsum)
                        //Counter()
                        //FooText(fuckingInsult)
                    }

                }
            }
        }*/
    }



    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @ExperimentalAnimationApi
    @Composable
    fun HelloScreen(testViewModel: TestViewModel) {
        var name by rememberSaveable { mutableStateOf(testViewModel.name.value) }

        println("HelloScreen::testViewModel.name.value------------------------>  [${testViewModel.name.value}]")

        fooComposables.NewFooText(testViewModel)
        fooComposablex.NewFooText()

        name?.let {
            HelloContent(name = it,
                onNameChange = {
                    name = it
                    testViewModel.onNameChanged(it)
                },
                doFoo = {
                    println("--------------------------> $name")
                },
                doBar = {
                    println("--------------------------> $it")
                }
            )
        }
    }

    @Composable
    fun HelloContent(
        name: String,
        onNameChange: (String) -> Unit,
        doFoo: () -> Unit,
        doBar: (String) -> Unit
    ) {

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Hello, $name",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
            OutlinedTextField(value = name,
                onValueChange = {
                    onNameChange(it)
                    doFoo()
                    doBar(it.toUpperCase())
                },
                label = { Text("Enter First Name") }
            )
        }
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ******************************************************************************************

    @Composable
    fun MyScreenContent() {

        val counterState = remember { mutableStateOf(0) }
        val headerName: MutableState<String> = remember { mutableStateOf("Pick Me!") }

        Column(modifier = Modifier.fillMaxHeight()) {

            Text("Pick Me!", style = MaterialTheme.typography.h5)
            NameList(nmList, Modifier.weight(1f))
            Counter(
                count = counterState.value,
                updateCount = { newCount -> counterState.value = newCount })
        }
    }

    @Composable
    fun TestText(fooState: String) {
        Text(fooState, style = MaterialTheme.typography.h5)
    }

    var toggle = true

    @Composable
    fun TestColumn(name: String = "Pick me!!!!") {

        var headerName by remember { mutableStateOf(name) }
        var headerNameAlt by remember { mutableStateOf("******************") }
        var fooHeaderText by remember { mutableStateOf("* Header *") }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {

            Text(fooHeaderText, style = MaterialTheme.typography.h1, color = Color.Yellow)

            Column {
                Text(headerName, style = MaterialTheme.typography.h5)
                Text(headerName, style = MaterialTheme.typography.h5)
                Text(headerName, style = MaterialTheme.typography.h5)
                Text(headerName, style = MaterialTheme.typography.h5)
                Text(headerName, style = MaterialTheme.typography.h5)
                Text(
                    headerName,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.clickable(onClick = { fooHeaderText = "<Foo Foo>" })
                )
            }

            Column {
                Text(
                    ">> $headerNameAlt", style = MaterialTheme.typography.h6,
                    modifier = Modifier.clickable(onClick = {
                        toggle = !toggle
                        if (toggle) {
                            headerName = "You Suck!"
                        } else {
                            headerNameAlt = "Fuck You!"
                        }
                    })
                )
            }

        }
    }

    @Composable
    fun NameList(names: List<String>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(items = names) { name ->
                Greetingz(name = name)
                GaaFoo(name = name, { println("I did foo") })
                Divider(color = Color.Black)
            }
        }
    }

    @Composable
    fun Greetingz(name: String) {
        var isSelected by remember { mutableStateOf(false) }
        val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)

        Text(
            text = "Hello $name!",
            modifier = Modifier
                .padding(24.dp)
                .background(color = backgroundColor)
                .clickable(onClick = { isSelected = !isSelected })
        )
    }

    @Composable
    fun GaaFoo(name: String, doFoo: () -> Unit) {
        println("gaaFoo $name")
        //doFoo()
    }

    @Composable
    fun Counter(count: Int, updateCount: (Int) -> Unit) {
        Button(
            onClick = { updateCount(count + 1) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (count > 5) Color.Green else Color.White
            )
        ) {
            Text("I've been clicked $count times")
        }
    }

    // ******************************************************************************************

    @Composable
    fun MyApp(content: @Composable () -> Unit) {

        MyComposeTheme {
            Surface(color = Color.LightGray) {
                content()
            }
        }
    }

    /**
     * Display a list of names the user can click with a header
     */
    @Composable
    fun NamePicker(header: String, names: List<String>, onNameClicked: (String) -> Unit) {

        var headerName by remember { mutableStateOf(header) }
        var headerNameAlt by remember { mutableStateOf("pick me!") }

        Column {
            // this will recompose when [header] changes, but not when [names] changes
            Text(headerName, style = MaterialTheme.typography.h5)
            Divider()

            // LazyColumnFor is the Compose version of a RecyclerView.
            // The lambda passed is similar to a RecyclerView.ViewHolder.
            LazyColumn(modifier = Modifier) {
                items(names) { name ->
                    headerName = name
                    NamePickerItem(name, onNameClicked)
                    Divider(color = Color.DarkGray)
                }
            }
        }
    }

    /**
     * Display a single name the user can click.
     */
    @Composable
    private fun NamePickerItem(name: String, onClicked: (String) -> Unit) {

        Text(name, Modifier.clickable(onClick = {
            println("*********************** $name ************************************")
            onClicked(name)
        }
        ))
    }


    @Composable
    fun HelloContent() {

        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = "Hello",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )

            CustomFoo()

            CustomFoo()

            CustomFoo()

        }
    }

    @Composable
    fun CustomFoo() {
        var name by remember { mutableStateOf("") }
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
    }


    @Composable
    fun FooLazyColumn() {
        val itemsList = (0..50).toList()
        val itemsIndexedList = listOf("A", "B", "C")

        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {

            items(itemsList) {
                Text("Item is $it")
                Divider(color = Color.DarkGray)
            }

            /*item {
                Text("Single item")
            }*/

            /*itemsIndexed(itemsIndexedList) { index, item ->
                Text("Item at index $index is $item")
            }*/
        }
    }

    data class ItemViewState(
        val text: String
    )

    @Composable
    fun MyComposeList() {
        //val simpleListDataItems:List<String> = ("a".."z").toList()
        // Use LazyRow when making horizontal lists
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            items(nmList) { data ->
                MySimpleListItem(data)
                Divider(color = Color.DarkGray)
            }
        }
    }

    // The UI for each list item can be generated by a reusable composable
    @Composable
    fun MySimpleListItem(t: String) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .clickable(onClick = { println("----------------------- $t ---------------------------") })
                .background(color = backgroundColor),
        ) {
            Text(
                text = t,
                style = TextStyle(fontSize = 24.sp),
                color = Color.Red,
                modifier = Modifier.clickable(onClick = { println("----------------------- $t ---------------------------") })
            )
        }


    }

    @Composable
    fun LazyColumnDemo() {
        val list = listOf("A", "B", "C", "D") + ((0..100).map { it.toString() })
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            items(items = list, itemContent = { item ->
                println("Rendered item: $item")
                Text(text = item, style = TextStyle(fontSize = 80.sp))
                Divider(color = Color.DarkGray)
                /*when (item) {
                    "A" -> {
                        Text(text = item, style = TextStyle(fontSize = 80.sp))
                    }
                    "B" -> {
                        Button(onClick = { println(item)}) {
                            Text(text = item, style = TextStyle(fontSize = 80.sp))
                        }
                    }
                    "C" -> {
                        Text(text = item, style = TextStyle(fontSize = 80.sp, color = Color.Magenta))
                    }
                    "D" -> {
                        Text(text = item, style = TextStyle(fontSize = 80.sp, color = Color.Red))
                    }
                    else -> {
                        Text(text = item, style = TextStyle(fontSize = 80.sp))
                    }
                }*/

            })
        }
    }


    var nmList: List<String> = listOf(
        "Wally",
        "Jan",
        "Mike",
        "Kevin",
        "Richard",
        "Diane",
        "Jay",
        "Bill",
        "Paul",
        "Sally",
        "Kelly",
        "Marvin",
        "Tim",
        "Laura",
        "Leigh",
        "Sam",
        "William",
        "George",
        "Carol",
        "Jackie",
        "David",
        "Julie",
        "Patricia",
        "Warren",
        "Maureen",
        "Fiona",
        "Kiera",
        "Margaret",
        "Robin",
        "Katie",
        "Eva",
        "Maeve",
        "Ian",
        "Katherine",
        "Myrtle",
    )

    fun getRndName(): String {


        var rndName = nmList[(nmList.indices).random()]
        return rndName
    }

    //-------------------------------------------------------------------------------------------------
    @Composable
    fun ExpandingCard(title: String, body: String) {
        var expanded by remember { mutableStateOf(false) }
        // describe the card for the current state of expanded
        Card {
            Column(
                Modifier
                    .width(280.dp)
                    .animateContentSize() // automatically animate size when it changes
                    .padding(top = 5.dp, start = 5.dp, end = 5.dp)
            ) {
                Text(text = title)

                // content of the card depends on the current value of expanded
                if (expanded) {
                    Text(text = body, Modifier.padding(top = 2.dp))
                    // change expanded in response to click events
                    IconButton(
                        onClick = {
                            expanded = false
                            thisInsult = getInsult()
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Filled.ArrowDropDown, contentDescription = "foo")
                    }
                } else {
                    // change expanded in response to click events
                    IconButton(
                        onClick = {
                            expanded = true
                            thisInsult = getInsult()
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Outlined.Close, contentDescription = "foo")
                    }
                }
            }
        }
    }

    fun getInsult(): String {
        var listInsults = listOf<String>(
            "Eat peanut butter",
            "Sod off",
            "Go Pound Tar",
            "Take a hike",
            "You wanker",
            "Go pound salt",
            "Hello Kitty",
            "Pass the dwarf",
            "Sure, See You Next Tuesday",
            "Time for beddies",
            "Ice cream time",
            "Buh Bye Felicia",
        )
        var insult = listInsults[(0..11).random()]
        println(insult)
        return insult
    }

    @Composable
    fun FooText(insult: String) {
        var clicks by remember { mutableStateOf(0) }
        var fu by remember { mutableStateOf(insult) }
        Text(
            "$fu [$clicks]",
            Modifier.clickable(onClick = {
                clicks++
                fu = getInsult()
                println("Hi there!$clicks")
            })
        )
    }

    @Composable
    fun Counter() {
        var clicks by remember { mutableStateOf(0) }
        ndx = clicks
        Column {
            Row {
                Button(onClick = { clicks-- }) {
                    Text("I've been clicked $clicks times")
                }
                Text(text = "count: $clicks")
                Button(onClick = { clicks++ }) {
                    Text("I've been clicked $clicks times")
                }
            }
        }
    }


    @Composable
    fun ClickCounter(clicks: Int, onClick: () -> Unit) {
        Button(onClick = onClick) {
            Text("I've been clicked $clicks times")
        }
    }

    @Composable
    fun ButtonExample() {
        var clicks by remember { mutableStateOf(ndx) }
        Button(
            onClick = {
                ndx++
                println("ButtonExample $clicks!")
            }, colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Red
            )
        ) {
            Text("Button $clicks!")
        }
    }

    fun doClick() {
        println("****************$isTrue****************")
        isTrue = !isTrue
        println("****************$isTrue****************")
    }


    @Composable
    fun TextWithPaddingFromBaseline() {
        var clicks by remember { mutableStateOf(ndx) }
        Box(Modifier.background(Color.Yellow)) {
            if (!isTrue) {
                Text(
                    "Hi there! $clicks#",
                    Modifier
                        .paddingFromBaseline(top = 32.dp)
                        .clickable(onClick = { println("Hi there!$clicks#") })
                )
            } else {
                Text(
                    "Hi there asshole! $clicks@",
                    Modifier
                        .paddingFromBaseline(top = 32.dp)
                        .clickable(onClick = { println("Hi there asshole!$clicks@") })
                )
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(
            text = "Hello $name! $ndx",
            color = Color.Red,
            fontSize = 60.sp,
            modifier = Modifier.clickable(onClick = {
                println("Hello")
            })
        )
    }

    @Composable
    fun SimpleText(displayText: String) {
        Text(text = displayText)
    }

    @Composable
    fun BostonBruins() {
        var clicks by remember { mutableStateOf(this.ndx) }
        for (n in 1..7) {
            this.ndx++
        }
        Text(
            text = "Bruins ${this.ndx} Capitals ${this.ndx}",
            color = Color.Blue,
            fontSize = 60.sp,
            modifier = Modifier.clickable(onClick = {
                println("Bruins are playing Caps!")
            }),
        )
    }

    var tobble = true

    @ExperimentalAnimationApi
    @Composable
    fun WelcomeScreen(navController: NavController, testViewModel: TestViewModel) {
        var name by rememberSaveable { mutableStateOf(testViewModel.name.value) }
        var toggle by rememberSaveable { mutableStateOf(true) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ) {


            if (name != "") {
                Text(text = "Welcome $name to the WELCOME screen!")
            } else {
                Text(text = "Welcome to the WELCOME screen!")
            }


            Row{
                Button(onClick = { navController.navigate("secondScreen") }) {
                    println("testViewModel.name.value-----> [[${name}]]")
                    Text(text = "Next")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(onClick = { navController.navigate("thirdScreen") }) {
                    Text(text = "Animate Me!")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(onClick = { navController.navigate("sixthScreen") }) {
                    Text(text = "The 6th")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row{
                Button(onClick = { navController.navigate("seventhScreen") }) {
                    Text(text = "Lucky #7")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(onClick = { navController.navigate("eighthScreen") }) {
                    Text(text = "8 Ball")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(onClick = { navController.navigate("tenthScreen") }) {
                    Text(text = "Scaffold")
                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            Row{

                Button(onClick = { navController.navigate("eleventhScreen") }) {
                    Text(text = "Images")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(onClick = { navController.navigate("twelvthScreen") }) {
                    Text(text = "Special Effects")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(onClick = { navController.navigate("thirteenthScreen") }) {
                    Text(text = "Icons!")
                }

            }

            Spacer(modifier = Modifier.height(16.dp))

           Row{

               Button(onClick = { navController.navigate("menuTwo") }) {
                   Text(text = "Menu Too!")
               }

               Spacer(modifier = Modifier.width(16.dp))

               Button(onClick = { toggle = !toggle }) {
                   Text(text = "Animate Text? $toggle")
               }

               Spacer(modifier = Modifier.width(16.dp))

           }

            Spacer(modifier = Modifier.height(16.dp))

            AnimatedVisibility(
                visible = toggle, enter = slideInVertically(
                    // Enters by sliding down from offset -fullHeight to 0.
                    initialOffsetY = { fullHeight -> -fullHeight },
                    animationSpec = tween(
                        durationMillis = 1000,
                        easing = FastOutLinearInEasing
                    ) //LinearOutSlowInEasing
                ),
                exit = slideOutVertically(
                    // Exits by sliding up from offset 0 to -fullHeight.
                    targetOffsetY = { fullHeight -> -fullHeight },
                    animationSpec = tween(durationMillis = 1000, easing = FastOutLinearInEasing)
                )
            ) {
                Text("Animated? $toggle")
            }

            Spacer(modifier = Modifier.height(16.dp))

            AnimatedVisibility(
                visible = toggle, enter = slideInHorizontally(
                    // Enters by sliding down from offset -fullHeight to 0.
                    initialOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(
                        durationMillis = 1000,
                        easing = FastOutLinearInEasing
                    ) //LinearOutSlowInEasing
                ),
                exit = slideOutHorizontally(
                    // Exits by sliding up from offset 0 to -fullHeight.
                    targetOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(durationMillis = 1000, easing = FastOutLinearInEasing)
                )
            ) {
                Text("Animated? $toggle")
            }


        }
    }


    @ExperimentalAnimationApi
    @Composable
    fun SecondScreen(navController: NavController, testViewModel: TestViewModel) {
        var init by remember { mutableStateOf(tobble) }
        var blue by remember { mutableStateOf(true) }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.LightGray)
        ) {
            tobble = !tobble

            println("[tobble: $tobble] [init: $init] ")
            println("testViewModel.name.value-----> ${testViewModel.name.value}")

            Column {

                Text(text = "Second screen!")

                HelloScreen(testViewModel)

                Button(onClick = { navController.navigate("welcome") }) {
                    Text(text = "Back")
                }
            }
        }

    }

    @Composable
    fun ThirdScreen(navController: NavController, testViewModel: TestViewModel) {
        Column {

            Text(text = "Third screen!")

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.navigate("welcome") }) {
                Text(text = "Home")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.navigate("fourthScreen") }) {
                Text(text = "4th Screen")
            }

            Spacer(modifier = Modifier.height(16.dp))

            testAnimate.AnimateAsStateDemo()
        }
    }

    @Composable
    fun FourthScreen(navController: NavController, testViewModel: TestViewModel) {

        var currentColor by remember { mutableStateOf(MyColors.Red) }
        var toggle by remember { mutableStateOf(true) }

        Crossfade(targetState = currentColor, animationSpec = tween(3000)) { selectedColor ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(selectedColor.color)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .border(width = 2.dp, color = Color.Black, shape = RectangleShape)
                    .background(Color.White)
            ) {
                Button(
                    onClick = {
                        toggle = !toggle
                        currentColor = if (toggle) {
                            MyColors.Red
                        } else {
                            MyColors.Green
                        }
                    },
                ) {
                    Text("change?")
                }
                Button(
                    onClick = {
                        navController.navigate("welcome")
                    },
                ) {
                    Text("Home")

                    Button(
                        onClick = {
                            navController.navigate("fifthScreen")
                        },
                    ) {
                        Text("5th Screen")
                    }
                }

            }

            //testAnimate.CrossfadeDemo()
        }
    }

    @Composable
    fun FifthScreen(navController: NavController, testViewModel: TestViewModel) {
        testCanvas.Squares(navController)
        testCanvas.CircleShapeDemo(navController)
    }

    @Composable
    fun SixthScreen(navController: NavController, testViewModel: TestViewModel) {
        testCanvas.EmptyCanvas()
    }

    @Composable
    fun SeventhScreen(navController: NavController, testViewModel: TestViewModel) {
        testCanvas.MyRect()
    }

    @Composable
    fun EighthScreen(navController: NavController, testViewModel: TestViewModel) {
        testRow.ThisTestRow(navController)
        Crossfade(targetState = this, animationSpec = tween(3000)) {
            println(it)
        }
    }

    @Composable
    fun NinthScreen(navController: NavController, testViewModel: TestViewModel) {
        testDrawer.ThisDrawer(navController)
    }

    @Composable
    fun TenthScreen(navController: NavController, testViewModel: TestViewModel) {
        testScaffold.makeTestScaffold(navController)
    }

    @Composable
    fun EleventhScreen(navController: NavController, testViewModel: TestViewModel) {
        TestImage.addImage()
    }

    @Composable
    fun TwelvthScreen(navController: NavController, testViewModel: TestViewModel) {
        TestEffects.LandingScreen { foo(navController) }
    }

    fun foo(navController: NavController) {
        println("Foo!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
        navController.navigate("welcome")
    }

    @ExperimentalFoundationApi
    @Composable
    fun ThirteenthScreen(navController: NavController, testViewModel: TestViewModel) {
        TestIcons.doIcons(navController)
    }

    @Composable
    fun MenuTwo(navController: NavController, testViewModel: TestViewModel) {
        MenuTwo.ShowMenu(navController, testViewModel)
    }

    @ExperimentalFoundationApi
    @Composable
    fun FourteenthScreen(navController: NavController, testViewModel: TestViewModel) {
        TestStateHoisting.AllComposables()
    }

    @Composable
    fun FifthteenthScreen(navController: NavController, testViewModel: TestViewModel) {
        TestState.MakeState()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    @Composable
    fun SixteenthScreen(navController: NavController, testViewModel: TestViewModel) {
        TestCheckbox.MakeCheckboxes()
    }

    @Composable
    fun SeventeenthScreen(navController: NavController, testViewModel: TestViewModel) {
        TestingText.MakeText()
    }

    @Composable
    fun EighteenthScreen(navController: NavController, testViewModel: TestViewModel) {
        val db = FirebaseFirestore.getInstance()
        val testFirestore = TestFirestore(db)
        testFirestore.FirestoreCompose()
    }

    @Composable
    fun NineteenthScreen(navController: NavController, testViewModel: TestViewModel) {
        FooAnimate.ImageAnimation(navController)
    }

    @ExperimentalAnimationApi
    @Composable
    fun TwentiethScreen(navController: NavController, testViewModel: TestViewModel) {
        var testAnimate = TestAnimate()
        testAnimate.CrossfadeDemo()
        //MitchHeart.doAnimationShit()
    }

    @Composable
    fun TwentyFirstScreen(navController: NavController, testViewModel: TestViewModel) {
        RocketMan.LaunchRocket()
    }

    @Composable
    fun TwentySecondScreen(navController: NavController, testViewModel: TestViewModel) {
        SpinningMan.DoTheSpin()
    }

    @Composable
    fun TwentyThirdScreen(navController: NavController, testViewModel: TestViewModel) {
        TestDragDrop.DoDragDrop()
    }

    @Composable
    fun TwentyFourthScreen(navController: NavController, testViewModel: TestViewModel) {
        TestSinWave.App()
    }

    @Composable
    fun TwentyFifthScreen(navController: NavController, testViewModel: TestViewModel) {
        var newSineWave = NewSineWave()
        newSineWave.WaveSetUp()
    }

    @Composable
    fun TwentySixthScreen(navController: NavController, testViewModel: TestViewModel) {
        var canvasWork = CanvasWork()
        canvasWork.doInit()
    }

    @Composable
    fun TwentySeventhScreen(navController: NavController, testViewModel: TestViewModel) {
        var dynamicSineWave = DynamicSineWave()
        dynamicSineWave.DoDynamic()
    }

    @Composable
    fun TwentyEightScreen(navController: NavController, testViewModel: TestViewModel) {
        var zineWave = ZineWave()
        zineWave.DoZineWave()
    }

    @Composable
    fun TwentyNinthScreen(navController: NavController, testViewModel: TestViewModel) {
        var composeClock = ComposeClock()
        composeClock.TickTock()
    }

    @Composable
    fun ThirtiethScreen(navController: NavController, testViewModel: TestViewModel) {
        var animateAs = AnimateAs()
        animateAs.DoStateAnimations()
    }

    @Composable
    fun ThirtyFirstScreen(navController: NavController, testViewModel: TestViewModel) {
        var testInlineFun = TestInlineFun()
        testInlineFun.StartTheShow()
    }

    @ExperimentalAnimationApi
    @Composable
    fun ThirtySecondScreen(navController: NavController, testViewModel: TestViewModel,
    ) {
        var testTransition = TestTransition()
        testTransition.DoTransition(navController, testViewModel)
    }

    @Composable
    fun ThirtyThirdScreen(navController: NavController, testViewModel: TestViewModel,
    ) {
        var transitionTo = TransitionTo()
        transitionTo.NewTransition(navController, testViewModel)
    }

    @Composable
    fun ThirtyFourthScreen(navController: NavController, testViewModel: TestViewModel,
    ) {
        var testSealedClass = TestSealedClass()
        testSealedClass.DoTest(navController, testViewModel)
    }

    @ExperimentalAnimationApi
    @Composable
    fun FirstAnimationScreen(navController: NavController, testViewModel: TestViewModel) {
        var firstTransitionScreen = FirstTransitionScreen()
        firstTransitionScreen.ShowScreen(navController, testViewModel)
    }

    @ExperimentalAnimationApi
    @Composable
    fun SecondAnimationScreen(navController: NavController, testViewModel: TestViewModel) {
        var secondTransitionScreen = SecondTransitionScreen()
        secondTransitionScreen.ShowScreen(navController, testViewModel)
    }

    @Composable
    fun NHLScreen(navController: NavController, testViewModel: TestViewModel) {
        var anotherNHL = AnotherNHL()
        anotherNHL.ThisTest()
    }

    @Composable
    fun ManagingState(navController: NavController, testViewModel: TestViewModel) {
        var managingState = ManagingState()
        managingState.DoManagingState(navController)
    }

    @Composable
    fun RoomDatabase(navController: NavController, testViewModel: TestViewModel) {
        var testingRoom = TestingRoom()
        testingRoom.DoTestRoom(navController)
    }

} // end class

enum class MyColors(val color: Color) {
    Red(Color.Red), Green(Color.Green), Blue(Color.Blue)
}










