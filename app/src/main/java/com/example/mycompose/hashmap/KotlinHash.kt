package com.example.mycompose.hashmap

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.*
import kotlin.collections.HashMap

/**
 *  A NOT SO simple example of HashMap class defined
 *  with empty "HashMap of <HockeyPlayer, PlayerInfo>"
 *  This PROBABLY not recommended!!
 */

class KotlinHash {

    var hashMap: HashMap<HockeyPlayer, PlayerInfo> = HashMap()

    lateinit var navController: NavController

    private fun doInit(){


        //printing the Empty hashMap
       // printHashMap(hashMap)

        //adding elements to the hashMap using
        // put() function
        hashMap[HockeyPlayer("Patrice Bergeron",BirthPlace("L'Ancienne-Lorette, QC", "CAN"))] =
            PlayerInfo("Boston","Bruins",37, "C")
        hashMap[HockeyPlayer("Anton Blidh",BirthPlace("Molnlycke", "SWE"))] =
            PlayerInfo("Boston","Bruins",81, "LW")
        hashMap[HockeyPlayer("Charlie Coyle",BirthPlace("East Weymouth, MA", "USA"))] =
            PlayerInfo("Boston","Bruins",13, "C")
        hashMap[HockeyPlayer("Jake DeBrusk",BirthPlace("Edmonton, AB", "CAN"))] =
            PlayerInfo("Boston","Bruins",74, "LW")
        hashMap[HockeyPlayer("Trent Frederic",BirthPlace("St. Louis, MO", "USA"))] =
            PlayerInfo("Boston","Bruins",11, "C")
        hashMap[HockeyPlayer("Taylor Hall",BirthPlace("Calgary, AB", "CAN"))] =
            PlayerInfo("Boston","Bruins",71, "LW")
        hashMap[HockeyPlayer("Cameron Hughes",BirthPlace("Edmonton, AB", "CAN"))] =
            PlayerInfo("Boston","Bruins",53, "C")
        hashMap[HockeyPlayer("Ondrej Kase",BirthPlace("Kadan", "CZE"))] =
            PlayerInfo("Boston","Bruins",28, "RW")
        hashMap[HockeyPlayer("David Krejci",BirthPlace("Sternberk", "CZE"))] =
            PlayerInfo("Boston","Bruins",46, "C")
        hashMap[HockeyPlayer("Karson Kuhlman",BirthPlace("Esko, MN", "USA"))] =
            PlayerInfo("Boston","Bruins",83, "C")
        hashMap[HockeyPlayer("Sean Kuraly",BirthPlace("Dublin, OH", "USA"))] =
            PlayerInfo("Boston","Bruins",52, "C")
        hashMap[HockeyPlayer("Curtis Lazar",BirthPlace("Salmon Arm, BC", "CAN"))] =
            PlayerInfo("Boston","Bruins",20, "C")
        hashMap[HockeyPlayer("Brad Marchand",BirthPlace("Halifax, NS", "CAN"))] =
            PlayerInfo("Boston","Bruins",63, "LW")
        hashMap[HockeyPlayer("Greg McKegg",BirthPlace("St. Thomas, ON", "CAN"))] =
            PlayerInfo("Boston","Bruins",18, "C")
        hashMap[HockeyPlayer("David Pastrnak",BirthPlace("Havirov", "CZE"))] =
            PlayerInfo("Boston","Bruins",88, "RW")
        hashMap[HockeyPlayer("Nick Ritchie",BirthPlace("Orangeville, ON", "CAN"))] =
            PlayerInfo("Boston","Bruins",21, "LW")
        hashMap[HockeyPlayer("Zach Senyshyn",BirthPlace("Ottawa, ON", "CAN"))] =
            PlayerInfo("Boston","Bruins",19, "RW")
        hashMap[HockeyPlayer("Craig Smith",BirthPlace("Madison, WI", "USA"))] =
            PlayerInfo("Boston","Bruins",12, "C")
        hashMap[HockeyPlayer("Oskar Steen",BirthPlace("Karlstad", "SWE"))] =
            PlayerInfo("Boston","Bruins",62, "C")
        hashMap[HockeyPlayer("Jack Studnicka",BirthPlace("Windsor, ON", "CAN"))] =
            PlayerInfo("Boston","Bruins",23, "C")
        hashMap[HockeyPlayer("Chris Wagner",BirthPlace("Walpole, MA", "USA"))] =
            PlayerInfo("Boston","Bruins",14, "RW")
        hashMap[HockeyPlayer("Jack Ahcan",BirthPlace("Savage, MN", "USA"))] =
            PlayerInfo("Boston","Bruins",54, "R")
        hashMap[HockeyPlayer("Brandon Carlo",BirthPlace("Colorado Springs, CO", "USA"))] =
            PlayerInfo("Boston","Bruins",25, "R")
        hashMap[HockeyPlayer("Connor Clifton",BirthPlace("Long Branch, NJ", "USA"))] =
            PlayerInfo("Boston","Bruins",75, "L")
        hashMap[HockeyPlayer("Matt Grzelcyk",BirthPlace("Charlestown, MA", "USA"))] =
            PlayerInfo("Boston","Bruins",48, "L")
        hashMap[HockeyPlayer("Jeremy Lauzon",BirthPlace("Val-d'Or, QC", "CAN"))] =
            PlayerInfo("Boston","Bruins",55, "R")
        hashMap[HockeyPlayer("Charlie McAvoy",BirthPlace("Long Beach, NY", "USA"))] =
            PlayerInfo("Boston","Bruins",73, "R")
        hashMap[HockeyPlayer("Kevan Miller",BirthPlace("Los Angeles, CA", "USA"))] =
            PlayerInfo("Boston","Bruins",86, "L")
        hashMap[HockeyPlayer("John Moore",BirthPlace("Winnetka, IL", "USA"))] =
            PlayerInfo("Boston","Bruins",27, "L")
        hashMap[HockeyPlayer("Mike Reilly",BirthPlace("Chicago, IL", "USA"))] =
            PlayerInfo("Boston","Bruins",6, "L")
        hashMap[HockeyPlayer("Jarred Tinordi",BirthPlace("Millersville, MD", "USA"))] =
            PlayerInfo("Boston","Bruins",84, "L")
        hashMap[HockeyPlayer("Urho Vaakanainen",BirthPlace("Joensuu", "FIN"))] =
            PlayerInfo("Boston","Bruins",58, "L")
        hashMap[HockeyPlayer("Jakub Zboril",BirthPlace("Brno", "CZE"))] =
            PlayerInfo("Boston","Bruins",67, "L")
        hashMap[HockeyPlayer("Jaroslav Halak",BirthPlace("Bratislava", "SVK"))] =
            PlayerInfo("Boston","Bruins",41, "G")
        hashMap[HockeyPlayer("Tuukka Rask",BirthPlace("Savonlinna", "FIN"))] =
            PlayerInfo("Boston","Bruins",40, "G")
        hashMap[HockeyPlayer("Jeremy Swayman",BirthPlace("Anchorage, AK", "USA"))] =
            PlayerInfo("Boston","Bruins",1, "G")
        hashMap[HockeyPlayer("Dan Vladar",BirthPlace("Prague", "CZE"))] =
            PlayerInfo("Boston","Bruins",80, "G")

        // --------------------------------------------------------------------------------

        hashMap[HockeyPlayer("Pierre Engvall",BirthPlace("Ljungby", "SWE"))] =
            PlayerInfo("Toronto", "Maple Leafs", 47,"LW")
        hashMap[HockeyPlayer("Nick Foligno",BirthPlace("Buffalo, NY", "USA"))] =
            PlayerInfo("Toronto", "Maple Leafs", 71,"LW")
        hashMap[HockeyPlayer("Alex Galchenyuk",BirthPlace("MILWAUKEE, WI","USA"))] =
            PlayerInfo("Toronto", "Maple Leafs", 12,"C")
        hashMap[HockeyPlayer("Zach Hyman",BirthPlace("Toronto, ON", "CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs",11,"LW")
        hashMap[HockeyPlayer("Alexander Kerfoot",BirthPlace("Vancouver, BC","CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs",15,"C")
        hashMap[HockeyPlayer("Kalle Kossila",BirthPlace("Kauniainen","FIN"))] =
            PlayerInfo("Toronto", "Maple Leafs", 48,"C")
        hashMap[HockeyPlayer("Denis Malgin",BirthPlace("Olten","CZE"))] =
            PlayerInfo("Toronto", "Maple Leafs", 62,"C")
        hashMap[HockeyPlayer("Mitchell Marner",BirthPlace("Markham, ON","CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs",16,"RW")
        hashMap[HockeyPlayer("Auston Matthews",BirthPlace("San Ramon, CA","USA"))] =
            PlayerInfo("Toronto", "Maple Leafs",  34,"C")
        hashMap[HockeyPlayer("Ilya Mikheyev",BirthPlace("Omsk","RUS"))] =
            PlayerInfo("Toronto", "Maple Leafs", 65,"RW")
        hashMap[HockeyPlayer("Riley Nash",BirthPlace("Consort, AB","CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs", 20,"C")
        hashMap[HockeyPlayer("Stefan Noesen",BirthPlace("Plano, TX","USA"))] =
            PlayerInfo("Toronto", "Maple Leafs", 26,"RW")
        hashMap[HockeyPlayer("William Nylander",BirthPlace("Calgary, AB","CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs", 88,"RW")
        hashMap[HockeyPlayer("Scott Sabourin",BirthPlace("Orleans, ON", "CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs", 49,"RW")
        hashMap[HockeyPlayer("Wayne Simmonds",BirthPlace("Scarborough, ON","CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs", 24,"RW")
        hashMap[HockeyPlayer("Jason Spezza",BirthPlace("Toronto, ON","CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs", 19,"C")
        hashMap[HockeyPlayer("John Tavares",BirthPlace("Mississauga, ON","CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs", 91,"C")
        hashMap[HockeyPlayer("Joe Thornton",BirthPlace("London, ON","CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs", 97,"C")
        hashMap[HockeyPlayer("Zach Bogosian",BirthPlace("Massena, NY","USA"))] =
            PlayerInfo("Toronto", "Maple Leafs", 22,"D")
        hashMap[HockeyPlayer("TJ Brodie",BirthPlace("Chatham, ON","CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs", 78,"D")
        hashMap[HockeyPlayer("Travis Dermott",BirthPlace("Newmarket, ON","CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs",  23,"D")
        hashMap[HockeyPlayer("Justin Holl",BirthPlace("Tonka Bay, MN"," USA"))] =
            PlayerInfo("Toronto", "Maple Leafs", 3,"D")
        hashMap[HockeyPlayer("Mac Hollowell",BirthPlace("Niagara Falls, ON","CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs", 81,"D")
        hashMap[HockeyPlayer("Ben Hutton",BirthPlace("Brockville, ON","CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs", 55,"D")
        hashMap[HockeyPlayer("Martin Marincin",BirthPlace("Kosice","SVK"))] =
            PlayerInfo("Toronto", "Maple Leafs", 52,"D")
        hashMap[HockeyPlayer("Jake Muzzin",BirthPlace("Woodstock, ON","CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs", 8,"D")
        hashMap[HockeyPlayer("Morgan Rielly",BirthPlace("Vancouver, BC","CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs", 44,"D")
        hashMap[HockeyPlayer("Calle Rosen",BirthPlace("Vaxjo","SWE"))] =
            PlayerInfo("Toronto", "Maple Leafs", 48,"D")
        hashMap[HockeyPlayer("Rasmus Sandin",BirthPlace("Uppsala","SWE"))] =
            PlayerInfo("Toronto", "Maple Leafs", 38,"D")
        hashMap[HockeyPlayer("Frederik Andersen",BirthPlace("Herning", "DNK"))] =
            PlayerInfo("Toronto", "Maple Leafs", 31,"G")
        hashMap[HockeyPlayer("Jack Campbell",BirthPlace("Port Huron, MI","USA"))] =
            PlayerInfo("Toronto", "Maple Leafs",36,"G")
        hashMap[HockeyPlayer("Michael Hutchinson",BirthPlace("Barrie, ON","CAN"))] =
            PlayerInfo("Toronto", "Maple Leafs",30,"G")
        hashMap[HockeyPlayer("David Rittich",BirthPlace("Jihlava","CZE"))] =
            PlayerInfo("Toronto", "Maple Leafs", 33,"G")
        hashMap[HockeyPlayer("Veini Vehvilainen",BirthPlace("Jyväskylä","FIN"))] =
            PlayerInfo("Toronto", "Maple Leafs",35,"G")
        hashMap[HockeyPlayer("Joseph Woll",BirthPlace("Dardenne Prairie, MO","USA"))] =
            PlayerInfo("Toronto", "Maple Leafs", 60,"G")
        hashMap[HockeyPlayer("Wally Miller",BirthPlace("Cotuit, MA","USA"))] =
            PlayerInfo("Boston", "Bruins", 99,"G")

    }

    @Composable
    fun DoKotlinHash(navController: NavController) {

        this.navController = navController

        var isInit by remember { mutableStateOf(true) }
        var showInfo by remember { mutableStateOf(false) }
        var playerName by remember { mutableStateOf("") }
        val listHockeyPlayerName = remember { mutableStateListOf<String>() }

        if(isInit){
            doInit()
            //hashMap traversal using a for loop
            for (key in hashMap.keys) {
                println("Element at key $key : ${hashMap[key]}")
                listHockeyPlayerName.add(key.name)
            }
            isInit = false // <- why does Kotlin say this is never used??
        }

        DoColumnHockeyPlayerName(listHockeyPlayerName){
            if(!showInfo){
                showInfo = !showInfo
                playerName = it
            }
        }

        if(showInfo){

            val playerFullName = getPlayerFullName(playerName) // <- replaces case insensitive search value with proper name
            val pInfo:PlayerInfo = getValueFromName(playerFullName)
            val bInfo:BirthPlace = getBirthPlaceFromName(playerFullName)

            if(pInfo.city == null){ // <- in the event that the search returns nothing
                showInfo = !showInfo
            }

            BoxWithConstraints(modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
                .offset(10.dp, 10.dp)) {

                DoInfoBox(playerFullName, pInfo, bInfo) {
                    showInfo = !showInfo
                    if(it != "close"){
                        println("Searching for: $it")
                        playerName = it
                        showInfo = !showInfo
                    }
                }

            }
        }
    }

    @Composable
    fun DoInfoBox(playerName:String, pInfo:PlayerInfo, bInfo:BirthPlace, callback: (String) -> Unit){

            Box(modifier = Modifier
                .height(350.dp)
                .width(350.dp)
                .border(5.dp, color = Color.Black, shape = RectangleShape)
                .background(Color.White)
                )
            {
                var text by remember { mutableStateOf("") }

                Column(modifier = Modifier.offset(x=25.dp, y=25.dp)){
                    Text("player name: $playerName")
                    Text("**************************************")
                    Text("team: ${pInfo.team}")
                    Text("city: ${pInfo.city}")
                    Text("position: ${pInfo.position}")
                    Text("number: ${pInfo.num}")
                    Spacer(modifier = Modifier.height(10.dp))
                    Text("     Birth place")
                    Text("         city: ${bInfo.city}")
                    Text("         country: ${bInfo.country}")
                    Spacer(modifier = Modifier.height(10.dp))

                    // Search Field
                    TextField(
                        value = text,
                        onValueChange = {
                            text = it },
                        label = { Text("search") }
                    )
                }

                Button(modifier = Modifier.offset(x=25.dp, y=300.dp), onClick = {
                    callback(text) }) {
                    Text("search")
                }

                Button(modifier = Modifier.offset(x=250.dp, y=300.dp), onClick = { callback("close") }) {
                    Text("close")
                }
            }

    }


    @Composable
    fun DoColumnHockeyPlayerName(listHockeyPlayerName: MutableList<String>, callback: (String) -> Unit){
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollState).fillMaxWidth()){
            for (name in listHockeyPlayerName){
                TextHockeyPlayer(name){
                    callback(name)
                }
            }
        }

        Icon(
            Icons.Filled.Menu, "menu", tint = Color.Gray,
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .offset(x=250.dp, y=10.dp)
                .clickable { println(this.navController.navigate("welcome"))})
    }

    @Composable
    fun TextHockeyPlayer(name:String, callback: (String) -> Unit){
        Text(name, modifier = Modifier.clickable{
            callback(name)
        })
    }


    fun getPlayerFullName(name:String):String{
        var playerName = ""
        for (key in hashMap.keys) {
            if (key.name.equals(name, ignoreCase = true)){
                playerName = key.name!!
            }
        }
        return playerName
    }

    private fun getValueFromName(name: String): PlayerInfo {
        var playerInfo = PlayerInfo()
            for (key in hashMap.keys) {
                if (key.name.equals(name, ignoreCase = true)){
                    playerInfo = hashMap[key]!!
                }
            }
        return playerInfo
    }

    private fun getBirthPlaceFromName(name: String): BirthPlace {
        var birthPlace = BirthPlace()
        for (key in hashMap.keys) {
            if(key.name == name){
                birthPlace = key.birthPlace!!
            }
        }
        return birthPlace
    }

} // end class

data class HockeyPlayer(val name:String, val birthPlace:BirthPlace? = null)

data class PlayerInfo(val city:String? = null, val team:String?= null, val num:Int?= null, val position:String?= null)

data class BirthPlace(val city: String? = null, val country:String? = null)