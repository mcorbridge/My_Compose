package com.example.mycompose.retrofit

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycompose.R
import com.example.mycompose.models.TestViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/**
 * Retrofit is today one of the easiest ways to implement calls to REST webservices .
 *
 * Retrofit android is dead-simple to use. It essentially lets you treat API calls as simple
 * Java method calls, so you only define which URLs to hit and the types of the request/response
 * parameters as Java classes.
 * The entire network call + JSON/XML parsing is completely handled by it (with help from Gson for
 * JSON parsing), along with support for arbitrary formats with pluggable serialization/deserialization.
 *
 * https://www.elitechsystems.com/how-to-implement-retrofit-in-an-android-project-via-kotlin/
 */

class TestRetrofit(val navController: NavController, testViewModel: TestViewModel) {


    @ExperimentalMaterialApi
    @Composable
    fun DoRetrofit() {

        var listUsers = remember{ mutableStateListOf<User>() }
        var ndx = 0
        val scrollState = rememberScrollState()
        var cardClicked by remember { mutableStateOf(0) }

        Column {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
                    .background(Color.Cyan, RectangleShape)
            ) {
                Image(
                    painterResource(R.drawable.retrofit),
                    contentDescription = "retrofit",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Button(onClick = {
                main()
                doRetrofit(){
                    it.forEach { user ->
                        listUsers.add(user)
                    }
                }
            }) {
                Text("Start")
            }

            Column(modifier = Modifier.verticalScroll(scrollState)){
                listUsers.forEach { user ->
                    DataCard(user, ndx++, cardClicked, cardColor = Color.LightGray, textColor = Color.Black){
                        cardClicked = it
                    }
                }
            }
        }

    }

    private fun main() = runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine and continue
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }
        println("Hello") // main coroutine continues while a previous one is delayed
    }

    private fun doRetrofit(callback:(List<User>) -> Unit){
        val apiInterface = ApiInterface.create().getUsers()

        apiInterface.enqueue( object : Callback<List<User>> {

            override fun onFailure(call: Call<List<User>>?, t: Throwable?) {
                println("error")
            }

            override fun onResponse(call: Call<List<User>>, response: retrofit2.Response<List<User>>) {

                response.body()?.let { callback(it) }

            }
        })
    }

    @ExperimentalMaterialApi
    @Composable
    fun DataCard(user:User, cardNum:Int, cardClicked:Int, cardColor:Color, textColor:Color, callback:(Int) -> Unit){

        if(cardClicked == cardNum){
            Card(
                shape = RoundedCornerShape(4.dp),
                backgroundColor = Color.White,
                onClick = { callback(cardNum) },
                modifier = Modifier.fillMaxWidth(0.5f).border(5.dp, color=Color.Black, shape = RoundedCornerShape(4.dp))
            ) {
                Text(
                    user.name!!, style = TextStyle(
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
                    user.name!!, style = TextStyle(
                        color = textColor,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    ), modifier = Modifier.padding(16.dp)
                )
            }
        }
    }


} // end class

interface ApiInterface {

    @GET("users")
    fun getUsers() : Call<List<User>>

    companion object {

        var BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}

data class User(
    val id: Int? = null,
    val name: String? = null,
    val userName: String? = null,
    val email: String? = null,
    val address : Address? = null,
    val phone: String? = null,
    val website: String? = null
)

data class Address(
    val street: String? = null,
    val suite: String? = null,
    val city: String? = null,
    val zipCode: String? = null
)

data class Comment (
    val postId: Int = 0,
    val id: Int = 0,
    val name: String? = null,
    val email: String? = null,
    val body: String? = null
)

data class Post (
    val userId: Int = 0,
    val id: Int? = null,
    val title: String? = null,
    val body: String? = null
)


