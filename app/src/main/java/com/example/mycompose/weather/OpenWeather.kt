package com.example.mycompose.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycompose.R
import com.example.mycompose.models.TestViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * my own personal weather station
 */

class OpenWeather(navController: NavController, testViewModel: TestViewModel) {

    @Composable
    fun DoOpenWeather(){

       // 48484aff
        var altColor = Color(0xFFF47A38)
        var bgColor = Color(0xff48484a)

        Box(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .background(bgColor, RectangleShape)
                .border(2.dp, color= Color.Black)
                .clickable {
                    getCurrentData(){
                        println(it)
                    }
                }
        ) {
            Image(
                painterResource(R.drawable.openweather),
                contentDescription = "retrofit",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }

    }


    private fun getCurrentData(callback:(String) -> Unit) {

        //https://api.openweathermap.org/data/2.5/weather?lat=41.61626448849655&lon=-70.44671000806197&appid=330aa600b4d24eb3a29f1fccdc436e93

        val baseUrl = "https://api.openweathermap.org/"
        val lat = "41.61626448849655"
        val lon = "-70.44671000806197"
        val appId = "330aa600b4d24eb3a29f1fccdc436e93"

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(WeatherService::class.java)
        val call = service.getCurrentWeatherData(lat, lon, appId)

        call!!.enqueue(object : Callback<WeatherResponse?> {

            override fun onResponse(
                call: Call<WeatherResponse?>,
                response: Response<WeatherResponse?>
            ) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!
                    val stringBuilder = """
                    Country: ${weatherResponse.sys!!.country}
                    Temperature: ${weatherResponse.main!!.temp}
                    Temperature(Min): ${weatherResponse.main!!.temp_min}
                    Temperature(Max): ${weatherResponse.main!!.temp_max}
                    Humidity: ${weatherResponse.main!!.humidity}
                    Pressure: ${weatherResponse.main!!.pressure}
                    """.trimIndent()
                    callback(stringBuilder)
                }
            }

            override fun onFailure(call: Call<WeatherResponse?>, t: Throwable) {
                println(t.message)
            }
        })
    }


}// end class

interface WeatherService {
    @GET("data/2.5/weather?")
    fun getCurrentWeatherData(
        @Query("lat") lat: String?,
        @Query("lon") lon: String?,
        @Query("APPID") app_id: String?
    ): Call<WeatherResponse?>?
}

data class WeatherResponse (
    var coord: Coord? = null,
    var sys: Sys? = null,
    var weather: ArrayList<Weather> = ArrayList<Weather>(),
    var main: Main? = null,
    var wind: Wind? = null,
    var rain: Rain? = null,
    var clouds: Clouds? = null,
    var dt: Float = 0f,
    var id: Int = 0,
    var name: String? = null,
    var cod: Float = 0f,
)

data class Weather (
    var id: Int = 0,
    var main: String? = null,
    var description: String? = null,
    var icon: String? = null
)

data class Clouds (
    var all: Float = 0f
)

data  class Rain (
    var h3: Float = 0f
)

data class Wind (
    var speed: Float = 0f,
    var deg: Float = 0f
)

data class Main (
    var temp: Float = 0f,
    var humidity: Float = 0f,
    var pressure: Float = 0f,
    var temp_min: Float = 0f,
    var temp_max: Float = 0f
)

data class Sys (
    var country: String? = null,
    var sunrise: Long = 0,
    var sunset: Long = 0,
)

data class Coord (
    var lon: Float = 0f,
    var lat: Float = 0f
)

