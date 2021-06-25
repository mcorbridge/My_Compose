package com.example.mycompose.card

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

class TestCard(val navController: NavController) {

    @ExperimentalMaterialApi
    @Composable
    fun DoCard() {

        var cardClicked by remember { mutableStateOf(0)}

        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()){

            Column(){

                Card(shape = RoundedCornerShape(4.dp),
                    backgroundColor = Color.White,
                    modifier = Modifier.fillMaxWidth(0.8f).border(1.dp, color=Color.Black, shape = RoundedCornerShape(4.dp))){
                    Text("This is a textbook example of how to 'Think in Compose'")
                }

                DataCard("Jan", 1, cardClicked, cardColor = Color.LightGray, textColor = Color.Black){
                    cardClicked = it
                }

                DataCard("Mike", 2, cardClicked, cardColor = Color.LightGray, textColor = Color.Black){
                    cardClicked = it
                }

                DataCard("Wally", 3, cardClicked, cardColor = Color.LightGray, textColor = Color.Black){
                    cardClicked = it
                }

                DataCard("Fred", 4, cardClicked, cardColor = Color.LightGray, textColor = Color.Black){
                    cardClicked = it
                }

                DataCard("Stanley", 5, cardClicked, cardColor = Color.LightGray, textColor = Color.Black){
                    cardClicked = it
                }

                DataCard("Richard", 6, cardClicked, cardColor = Color.LightGray, textColor = Color.Black){
                    cardClicked = it
                }

                DataCard("Foo", 7, cardClicked, cardColor = Color.LightGray, textColor = Color.Black){
                    cardClicked = it
                }

            }
        }
    }

    @ExperimentalMaterialApi
    @Composable
    fun DataCard(dataName:String, cardNum:Int, cardClicked:Int, cardColor:Color, textColor:Color, callback:(Int) -> Unit){

        if(cardClicked == cardNum){
            Card(
                shape = RoundedCornerShape(4.dp),
                backgroundColor = Color.White,
                onClick = { callback(cardNum) },
                modifier = Modifier.fillMaxWidth(0.5f).border(5.dp, color=Color.Black, shape = RoundedCornerShape(4.dp))
            ) {
                Text(
                    dataName, style = TextStyle(
                        color = textColor,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    ), modifier = Modifier.padding(16.dp)
                )
            }
        }else{
            Card(
                shape = RoundedCornerShape(4.dp),
                backgroundColor = cardColor,
                onClick = {  callback(cardNum) },
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Text(
                    dataName, style = TextStyle(
                        color = textColor,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    ), modifier = Modifier.padding(16.dp)
                )
            }
        }
    }


}