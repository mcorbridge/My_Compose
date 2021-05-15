package com.example.mycompose.nhl

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class ShowNHL {

    @Composable
    fun ShowTeamColor(){

        val teamList:List<String> = listOf(
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
            "LosAngeles",
            "Minnesota",
            "Montreal",
            "Nashville",
            "NewJersey",
            "NewYorkIslanders",
            "NewYorkRangers",
            "Ottawa",
            "Philadelphia",
            "Pittsburgh",
            "StLouis",
            "SanJose",
            "Seattle",
            "TampaBay",
            "Toronto",
            "Vancouver",
            "Vegas",
            "Washington",
            "Winnipeg",
        )
        Column{
            teamList.forEach { team ->
                TeamItem(team){
                    println("***************** $team *****************")
                }
            }
        }


    }

    @Composable
    fun TeamItem(team:String, callback:() -> Unit){
        Column{
            Text(team, modifier = Modifier.clickable {  callback() })
        }

    }
}