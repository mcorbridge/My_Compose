package com.example.mycompose.nhl

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mycompose.R
import com.example.mycompose.icons.TestIcons


class ShowNHL {


    var teamName: String = ""
    var isClicked = false


    @Composable
    fun ShowTeamColor() {

        val primaryColor = remember { mutableStateOf(Color.Transparent) }
        val secondaryColor = remember { mutableStateOf(Color.Transparent) }
        val tertiaryColor = remember { mutableStateOf(Color.Transparent) }
        val quaternaryColor = remember { mutableStateOf(Color.Transparent) }
        val quinaryColor = remember { mutableStateOf(Color.Transparent) }
        val senaryColor = remember { mutableStateOf(Color.Transparent) }
        val septenaryColor = remember { mutableStateOf(Color.Transparent) }
        val octenaryColor = remember { mutableStateOf(Color.Transparent) }


        Row {

            ShowTeamList {

                println("||||||||||||||||||||||||||||||||||||| I just clicked a team")

                // reset all colors to transparent
                primaryColor.value = Color.Transparent
                secondaryColor.value = Color.Transparent
                tertiaryColor.value = Color.Transparent
                quaternaryColor.value = Color.Transparent
                quinaryColor.value = Color.Transparent
                senaryColor.value = Color.Transparent
                septenaryColor.value = Color.Transparent
                octenaryColor.value = Color.Transparent

                primaryColor.value = it[0]
                secondaryColor.value = it[1]
                if (it.size >= 3)
                    tertiaryColor.value = it[2]
                if (it.size >= 4)
                    quaternaryColor.value = it[3]
                if (it.size >= 5)
                    quinaryColor.value = it[4]
                if (it.size >= 6)
                    senaryColor.value = it[5]
                if (it.size >= 7)
                    septenaryColor.value = it[6]
                if (it.size >= 8)
                    octenaryColor.value = it[7]
            }


            // yeah, yeah .... this should probably be a List
            TeamColors(
                primaryColor.value,
                secondaryColor.value,
                tertiaryColor.value,
                quaternaryColor.value,
                quinaryColor.value,
                senaryColor.value,
                septenaryColor.value,
                octenaryColor.value,
            )
        }


    }

    @Composable
    fun ShowTeamList(callback: (MutableList<Color>) -> Unit) {

        val teamColors = TeamColors()
        teamColors.setTeams()

        val teamList: List<String> = listOf(
            "Anaheim",
            "Arizona",
            "Boston",
            "Buffalo",
            "Calgary",
            "Carolina",
            "Chicago",
            "Colorado",
            "Columbus",
            "Dallas",
            "Detroit",
            "Edmonton",
            "Florida",
            "Los Angeles",
            "Minnesota",
            "Montreal",
            "Nashville",
            "New Jersey",
            "New York Islanders",
            "New York Rangers",
            "Ottawa",
            "Philadelphia",
            "Pittsburgh",
            "St. Louis",
            "San Jose",
            "Seattle",
            "Tampa Bay",
            "Toronto",
            "Vancouver",
            "Las Vegas",
            "Washington",
            "Winnipeg",
        )
        Column {
            teamList.forEach { team ->

                TeamItem(team) {

                    println("================================== team $team was clicked")

                    val arrColors: MutableList<Color> = mutableListOf()

                    teamColors.listTeam.forEach {

                        //callback
                        if (it.name == team.replace("Las", "").replace(" ", "").replace(".", "")) {

                            // place currently selected team into class scope
                            teamName = it.name

                            arrColors.add(it.primaryColor) // team MUST have a primary color
                            arrColors.add(it.secondaryColor) // team MUST have a secondary color

                            if (it.tertiaryColor != null)
                                arrColors.add(it.tertiaryColor)

                            if (it.quaternaryColor != null)
                                arrColors.add(it.quaternaryColor)

                            if (it.quinaryColor != null)
                                arrColors.add(it.quinaryColor)

                            if (it.senaryColor != null)
                                arrColors.add(it.senaryColor)

                            if (it.septenaryColor != null)
                                arrColors.add(it.septenaryColor)

                            if (it.octenaryColor != null)
                                arrColors.add(it.octenaryColor)

                        }
                    }

                    callback(arrColors)
                }
            }
        }


    }

    @Composable
    fun TeamItem(team: String, callback: () -> Unit) {
        Column(modifier = Modifier.padding(1.dp)) {
            Text(team, modifier = Modifier.clickable {
                println("----------------------------------- team $team was clicked")
                callback()
            })
        }
    }

    @Composable
    fun TeamColors(
        primaryColor: Color,
        secondaryColor: Color,
        tertiaryColor: Color,
        quaternaryColor: Color,
        quinaryColor: Color,
        senaryColor: Color,
        septenaryColor: Color,
        octenaryColor: Color,
    ) {

        val isClicked = remember { mutableStateOf(false)}

        val listTeamLogo: List<Int> = listOf(
                            R.drawable.ana_d,//        "Anaheim",
                            R.drawable.ari_d,//        "Arizona",
                            R.drawable.bos_d,//        "Boston",
                            R.drawable.buf_d,//        "Buffalo",
                            R.drawable.cgy_d,//        "Calgary",
                            R.drawable.car_d,//        "Carolina",
                            R.drawable.chi_d,//        "Chicago",
                            R.drawable.col_d,//        "Colorado",
                            R.drawable.cbj_d,//        "Columbus",
                            R.drawable.dal_d,//        "Dallas",
                            R.drawable.det_d,//        "Detroit",
                            R.drawable.edm_d,//        "Edmonton",
                            R.drawable.fla_d,//        "Florida",
                            R.drawable.lak_d,//        "Los Angeles",
                            R.drawable.min_d,//        "Minnesota",
                            R.drawable.mtl_l,//        "Montreal",
                            R.drawable.nsh_d,//        "Nashville",
                            R.drawable.njd_d,//        "New Jersey",
                            R.drawable.nyi_d,//        "New York Islanders",
                            R.drawable.nyr_d,//        "New York Rangers",
                            R.drawable.ott_d,//        "Ottawa",
                            R.drawable.phi_d,//        "Philadelphia",
                            R.drawable.pit_d,//        "Pittsburgh",
                            R.drawable.stl_l,//        "St. Louis",
                            R.drawable.sjs_d,//        "San Jose",
                            R.drawable.sea,//        "Seattle",
                            R.drawable.tbl_l,//        "Tampa Bay",
                            R.drawable.tor_l,//        "Toronto",
                            R.drawable.van_l,//        "Vancouver",
                            R.drawable.vgk_l,//        "Las Vegas",
                            R.drawable.wsh_l,//        "Washington",
                            R.drawable.wpg_l,//        "Winnipeg",
        )

        Column(modifier = Modifier.padding(4.dp)) {
            if (primaryColor != Color.Transparent) {
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(color = primaryColor)
                        .border(width = 2.dp, color = Color.Black, shape = RectangleShape)
                ) {
                    Text("")
                }
            }

            if (secondaryColor != Color.Transparent) {
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(color = secondaryColor)
                        .border(width = 2.dp, color = Color.Black, shape = RectangleShape)
                ) {
                    Text("")
                }
            }

            if (tertiaryColor != Color.Transparent) {
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(color = tertiaryColor)
                        .border(width = 2.dp, color = Color.Black, shape = RectangleShape)
                ) {
                    Text("")
                }
            }

            if (quaternaryColor != Color.Transparent) {
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(color = quaternaryColor)
                        .border(width = 2.dp, color = Color.Black, shape = RectangleShape)
                ) {
                    Text("")
                }
            }

            if (quinaryColor != Color.Transparent) {
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth()
                        .height(30.dp)
                        .background(color = quinaryColor)
                        .border(width = 2.dp, color = Color.Black, shape = RectangleShape)
                ) {
                    Text("")
                }
            }

            if (senaryColor != Color.Transparent) {
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth()
                        .height(25.dp)
                        .background(color = senaryColor)
                        .border(width = 2.dp, color = Color.Black, shape = RectangleShape)
                ) {
                    Text("")
                }
            }

            if (septenaryColor != Color.Transparent) {
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth()
                        .height(12.dp)
                        .background(color = septenaryColor)
                        .border(width = 2.dp, color = Color.Black, shape = RectangleShape)
                ) {
                    Text("")
                }
            }

            if (octenaryColor != Color.Transparent) {
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth()
                        .height(6.dp)
                        .background(color = octenaryColor)
                        .border(width = 2.dp, color = Color.Black, shape = RectangleShape)
                ) {
                    Text("")
                }
            }

            if(!isClicked.value){
                Icon(
                    Icons.Filled.QuestionAnswer, "menu", tint = Color.Black,
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .clickable { isClicked.value = true })
            }else{
                when (teamName) {
                    "Anaheim" -> TeamLogo(listTeamLogo[0])
                    "Arizona" -> TeamLogo(listTeamLogo[1])
                    "Boston" -> TeamLogo(listTeamLogo[2])
                    "Buffalo" -> TeamLogo(listTeamLogo[3])
                    "Calgary" -> TeamLogo(listTeamLogo[4])
                    "Carolina" -> TeamLogo(listTeamLogo[5])
                    "Chicago" -> TeamLogo(listTeamLogo[6])
                    "Colorado" -> TeamLogo(listTeamLogo[7])
                    "Columbus" -> TeamLogo(listTeamLogo[8])
                    "Dallas" -> TeamLogo(listTeamLogo[9])
                    "Detroit" -> TeamLogo(listTeamLogo[10])
                    "Edmonton" -> TeamLogo(listTeamLogo[11])
                    "Florida" -> TeamLogo(listTeamLogo[12])
                    "LosAngeles" -> TeamLogo(listTeamLogo[13])
                    "Minnesota" -> TeamLogo(listTeamLogo[14])
                    "Montreal" -> TeamLogo(listTeamLogo[15])
                    "Nashville" -> TeamLogo(listTeamLogo[16])
                    "NewJersey" -> TeamLogo(listTeamLogo[17])
                    "NewYorkIslanders" -> TeamLogo(listTeamLogo[18])
                    "NewYorkRangers" -> TeamLogo(listTeamLogo[19])
                    "Ottawa" -> TeamLogo(listTeamLogo[20])
                    "Philadelphia" -> TeamLogo(listTeamLogo[21])
                    "Pittsburgh" -> TeamLogo(listTeamLogo[22])
                    "StLouis" -> TeamLogo(listTeamLogo[23])
                    "SanJose" -> TeamLogo(listTeamLogo[24])
                    "Seattle" -> TeamLogo(listTeamLogo[25])
                    "TampaBay" -> TeamLogo(listTeamLogo[26])
                    "Toronto" -> TeamLogo(listTeamLogo[27])
                    "Vancouver" -> TeamLogo(listTeamLogo[28])
                    "Vegas" -> TeamLogo(listTeamLogo[29])
                    "Washington" -> TeamLogo(listTeamLogo[30])
                    "Winnipeg" -> TeamLogo(listTeamLogo[31])
                }
            }
        }
    }

    @Composable
    fun TeamLogo(drawable: Int) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
        ) {
            Image(
                painterResource(drawable),
                contentDescription = "Leafs",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .size(64.dp)
                    .clip(CircleShape)                       // clip to the circle shape
                    .border(5.dp, Color.Black, CircleShape)
            )
        }
    }


}