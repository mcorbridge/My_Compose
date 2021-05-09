/*
 * Copyright (c) 2021. Michael D. Corbridge
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains the property of Michael D. Corbridge. The intellectual and technical concepts contained herein are proprietary to Michael D. Corbridge and may be covered by U.S. and Foreign Patents, patents in process, and are protected by trade secret or copyright law. Dissemination of this information or reproduction of this material is strictly forbidden unless prior written permission is obtained from Michael D. Corbridge.
 */

package com.example.mycompose.firebase

import android.content.ContentValues
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Alarm
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mycompose.R
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore


// Firestore CRUD .... IS DONE!!!!!!!!!!!!!!
// Firestore LOGIN mechanism... IS DONE!!!!!!!!!!!!!!
class TestFirestore(db: FirebaseFirestore) {

    // doTestFirestore() //R <- done
    // getDataWhereEqualTo("Patrice")
    // writeData() //C <- done
    // deleteData() //D <- done
    // updateData() //U <- done
    //getLogin()

    val deebee = db


    @Composable
    fun FirestoreCompose() {

        val isLoggedIn = remember { mutableStateOf(false) }
        val loginStatus = remember { mutableStateOf("") }
        val testEmail0 = "mikecorbridge@gmail.com" // <- passes authentication
        val testEmail1 = "m_corbridge@hotmail.com" // <- fails authentication
        var email by rememberSaveable { mutableStateOf("") }
        var loginStatusTxtColor = remember { mutableStateOf(Color.Green) }

        Column {

            Text(loginStatus.value, style = TextStyle(loginStatusTxtColor.value))

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = { Text("enter email") },
                leadingIcon = { Icon("Email") },
            )

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = { Text("Enter password") },
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = { Icon("Lock") },
            )


            Button(onClick = {
                doLogin(email) {
                    if (it) {
                        isLoggedIn.value = true
                        loginStatus.value = "SUCCESS"
                    } else {
                        loginStatus.value = "login failure"
                        loginStatusTxtColor.value = Color.Red
                        email = "" // clear the email field
                    }
                }
            }) {
                Text(text = "submit")
            }

            DoFirestoreImage()

            ErrorTextField()

            Text("foo")


        }
    }

    @Composable
    fun ErrorTextField() {
        var text by remember { mutableStateOf("") }
        val isValid = text.count() > 5 && '@' in text
            OutlinedTextField(
                value = text,
                onValueChange = {
                    text = it
                },
                label = {
                    val label = if (isValid) "Email" else "Email*"
                    Text(label)
                },
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = { Icon("Alarm") })
        }

    @Composable
    fun Icon(type: String) {

        when (type) {
            "Lock" -> {
                Icon(
                    Icons.Filled.Lock,
                    "password",
                    tint = Color.LightGray,
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                        .clickable { })
            }
            "Email" -> {
                Icon(
                    Icons.Filled.Email,
                    "email",
                    tint = Color.LightGray,
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                        .clickable { })
            }
            "Alarm" -> {
                Icon(
                    Icons.Outlined.Alarm,
                    "email",
                    tint = Color.LightGray,
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                        .clickable { })
            }
        }


    }

    private fun doTestFirestore() {

        var playerList: MutableList<HockeyPlayer> = mutableListOf()

        deebee.collection("hockey")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {

                    println(document)

                    var fname = ""
                    var mname = ""
                    var lname = ""
                    println()
                    document.data.map {
                        when (it.key) {
                            "firstName" -> fname = it.value.toString()
                            "middleName" -> mname = it.value.toString()
                            "lastName" -> lname = it.value.toString()
                        }
                    }
                    playerList.add(HockeyPlayer(fname, mname, lname))
                }
                showPlayerList(playerList)
            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents: ", exception)
            }
    }

    private fun writeData() {

        val docData = hashMapOf(
            "firstName" to "Matthew",
            "middleName" to "Anderson",
            "lastName" to "Grzelcyk",
        )

        deebee.collection("hockey").document("fourthPlayer")
            .set(docData)
            .addOnSuccessListener { println("DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> println("Error writing document $e") }

    }

    private fun updateData() {

        val hockeyRef = deebee.collection("hockey").document("fourthPlayer")

        hockeyRef
            .update("firstName", "zzzzzzzzzzzzzzyyy")
            .addOnSuccessListener { println("DocumentSnapshot successfully updated!") }
            .addOnFailureListener { e -> println("Error updating document $e") }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun getDataWhereEqualTo(firstName: String) {

        var hkyref: DocumentSnapshot

        val hockeyRef = deebee.collection("hockey").whereEqualTo("firstName", firstName)
            .get()
            .addOnSuccessListener { q ->
                println("DocumentSnapshot successfully retrieved!")

                var ndx = 0
                q.documents.forEach { d ->
                    hkyref = d
                    if (ndx == 0) {
                        showDocumentSnapshot(d)
                    }
                    ndx++
                }
            }
            .addOnFailureListener { e -> println("Error retrieving document $e") }

    }

    private fun deleteData() {
        deebee.collection("hockey").document("fourthPlayer")
            .delete()
            .addOnSuccessListener { println("DocumentSnapshot successfully deleted!") }
            .addOnFailureListener { e -> println("Error deleting document $e") }
    }

    private fun showDocumentSnapshot(d: DocumentSnapshot) {
        println(d.data)
    }

    private fun showPlayerList(list: MutableList<HockeyPlayer>) {
        list.forEach {
            println(it)
        }
    }

    private fun getLogin() {
        deebee.collection("hockey").document("login").collection("emails").get()
            .addOnSuccessListener {
                it.documents.forEach {
                    println(it.data)
                }
            }
            .addOnFailureListener { e ->
                println("Error retrieving login document $e")
            }
    }

    private fun doLogin(email: String, doLogin: (isLogin: Boolean) -> Unit) {

        deebee.collection("hockey").document("login").collection("emails")
            .whereEqualTo("email", email)
            .get()
            .addOnSuccessListener {
                println("+++++++++++++++++++++++>>>>>> ${it.documents.size}")
                when (it.documents.size) {
                    1 -> doLogin(true)
                    else -> doLogin(false)
                }
            }
            .addOnFailureListener { e ->
                println("Error retrieving login document $e")
                doLogin(false)
            }
    }

    @Composable
    fun DoFirestoreImage() {
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .background(Color.Cyan, CircleShape)
        ) {
            Image(
                painterResource(R.drawable.firestore),
                contentDescription = "firestore",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }


} // end class

data class HockeyPlayer(val firstName: String, val middleName: String, val lastName: String)