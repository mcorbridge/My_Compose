package com.example.mycompose.menu

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycompose.models.TestViewModel

class MenuTwo {

    companion object {


        @Composable
        fun ShowMenu(navController: NavController, testViewModel: TestViewModel) {

            println("screen dims: ${testViewModel.getScreenDims()}")

            Column(modifier = Modifier.offset(x = 0.dp)) {

                Row {
                    Button(onClick = { navController.navigate("fourteenthScreen") }) {
                        Text(text = "State Hoisting")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = { navController.navigate("fifthteenthScreen") }) {
                        Text(text = "State Test")
                    }

                }

                Spacer(modifier = Modifier.height(16.dp))

                Row {

                    Button(onClick = { navController.navigate("sixteenthScreen") }) {
                        Text(text = "Checkbox")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = { navController.navigate("seventeenthScreen") }) {
                        Text(text = "Text")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = { navController.navigate("eighteenthScreen") }) {
                        Text(text = "Firestore")
                    }
                }


                Spacer(modifier = Modifier.height(16.dp))

                Row {

                    Button(onClick = { navController.navigate("nineteenthScreen") }) {
                        Text(text = "Dots!")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = { navController.navigate("twentyFirstScreen") }) {
                        Icon(
                            Icons.Filled.Radio,
                            "Whoosh",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "Lift Off!")
                    }

                    Spacer(modifier = Modifier.width(16.dp))


                    Button(onClick = { navController.navigate("twentySecondScreen") }) {
                        Icon(
                            Icons.Filled.Timer,
                            "Spin!!",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "Spin!")
                    }

                }

                Spacer(modifier = Modifier.height(16.dp))


                Row {

                    Button(onClick = { navController.navigate("twentyThirdScreen") }) {
                        Icon(
                            Icons.Filled.Dry,
                            "What a drag!",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "drag!")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = { navController.navigate("twentyFourthScreen") }) {
                        Icon(
                            Icons.Filled.Star,
                            "Sine",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "Sine")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = { navController.navigate("twentyFifthScreen") }) {
                        Icon(
                            Icons.Filled.Kayaking,
                            "Cosine",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "Cosine")
                    }

                }

                Spacer(modifier = Modifier.height(16.dp))

                Row {


                    Button(onClick = { navController.navigate("twentySixthScreen") }) {
                        Icon(
                            Icons.Filled.SmartButton,
                            "Smiley",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "Smiley")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = { navController.navigate("twentySeventhScreen") }) {
                        Icon(
                            Icons.Filled.Paragliding,
                            "ooops",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "More Sine")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                }

                Spacer(modifier = Modifier.height(16.dp))

                Row {


                    Button(onClick = { navController.navigate("twentyEightScreen") }) {
                        Icon(
                            Icons.Filled.Coffee,
                            "Zine",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "Zine")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = { navController.navigate("twentyNinthScreen") }) {
                        Icon(
                            Icons.Filled.Timer,
                            "clock",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "clock")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = { navController.navigate("thirtiethScreen") }) {
                        Icon(
                            Icons.Filled.Air,
                            "as",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "as")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row {

                    Button(onClick = { navController.navigate("thirtyFirstScreen") }) {
                        Icon(
                            Icons.Filled.Star,
                            "as",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "inLine")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = {
                        // Kotlin delay implementation
                        Handler(Looper.getMainLooper()).postDelayed({
                            navController.navigate("thirtySecondScreen")
                        }, 3000)

                    }) {
                        Icon(
                            Icons.Filled.Tapas,
                            "trans",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "transition")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = {
                        navController.navigate("firstAnimationScreen")
                    }) {
                        Icon(
                            Icons.Filled.TaskAlt,
                            "->",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "->")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row {

                    Button(onClick = {
                        navController.navigate("thirtyFourthScreen")
                    }) {
                        Icon(
                            Icons.Filled.Segment,
                            "sealed",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "sealed")
                    }

                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = {
                        navController.navigate("secondAnimationScreen")
                    }) {
                        Icon(
                            Icons.Filled.Quiz,
                            "<-",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "<-")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = {
                        navController.navigate("nhlScreen")
                    }) {
                        Icon(
                            Icons.Filled.IceSkating,
                            "NHL",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "NHL")
                    }

                }

                Spacer(modifier = Modifier.height(16.dp))

                Row {

                    Button(onClick = {
                        navController.navigate("managingState")
                    }) {
                        Icon(
                            Icons.Filled.ManageAccounts,
                            "managingState",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "Manage")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = {
                        navController.navigate("roomDatabase")
                    }) {
                        Icon(
                            Icons.Filled.Room,
                            "roomDatabase",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "Room")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = {
                        navController.navigate("kotlinHash")
                    }) {
                        Icon(
                            Icons.Filled.Handyman,
                            "kotlinHash",
                            tint = Color.White,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "map")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {


            }
        }


    } // end companion object


} //  end class