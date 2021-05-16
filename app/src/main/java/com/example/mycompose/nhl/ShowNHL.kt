package com.example.mycompose.nhl

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp


class ShowNHL {


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

                    val arrColors: MutableList<Color> = mutableListOf()

                    teamColors.listTeam.forEach {

                        //callback
                        if (it.name == team.replace("Las", "").replace(" ", "").replace(".", "")) {

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
            Text(team, modifier = Modifier.clickable { callback() })
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

        Column(modifier = Modifier.padding(4.dp)){
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
        }

    }


}