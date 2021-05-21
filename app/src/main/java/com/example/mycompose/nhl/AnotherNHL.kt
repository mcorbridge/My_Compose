package com.example.mycompose.nhl

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AnotherNHL {

    @Composable
    fun ThisTest() {

        val nhlTeamData = NHLTeamData()
        nhlTeamData.setTeams()
        val teamData = nhlTeamData.listTeam
        var showTeamLogo by remember { mutableStateOf(false) }
        var showTeamColors by remember { mutableStateOf(false) }
        var teamLogo by remember { mutableStateOf(0) }
        var currentTeam by remember { mutableStateOf(teamData[0]) }

        fun doShowTeamLogo() {
            showTeamLogo = !showTeamLogo
        }

        Row {

            Column {
                teamData.forEach { team ->
                    // team item onClick
                    TeamItem(team.displayName) {
                        currentTeam = team
                        showTeamColors = true
                        teamLogo = team.logo
                        showTeamLogo = false
                    }
                }
            }

            Column {

                if (showTeamColors) {
                    ShowTeamColors(currentTeam)
                }

                if (showTeamLogo) {
                    ThisLogo(teamLogo) {
                        doShowTeamLogo() // on logo click
                    }
                } else {
                    Text("?",
                        fontSize = 56.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        modifier = Modifier.clickable {
                            doShowTeamLogo()
                        })
                }
            }
        }
    }

    @Composable
    private fun ShowTeamColors(team: TeamData) {
        Column(modifier = Modifier.padding(5.dp)) {
            team.listColors.forEach {
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = it)
                        .border(1.dp, color = Color.Black, shape = RectangleShape)
                ) {
                }
            }
        }
    }

    @Composable
    private fun TeamItem(team: String, callback: (String) -> Unit) {
        Column(modifier = Modifier.padding(1.dp)) {
            Text(team, modifier = Modifier.clickable {
                callback(team)
            })
        }
    }

    @Composable
    private fun ThisLogo(logo: Int, fn: () -> Unit) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .clickable { fn() }
        ) {
            Image(
                painterResource(logo),
                contentDescription = "nhLogo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .size(100.dp)
                    .clip(CircleShape)                       // clip to the circle shape
                    .border(1.dp, Color.Black, CircleShape)
            )
        }
    }

}