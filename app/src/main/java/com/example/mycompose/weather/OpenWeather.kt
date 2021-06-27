package com.example.mycompose.weather

import java.text.DecimalFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycompose.R
import com.example.mycompose.compassRose.Bearing
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
 *
 * cnvert K to Fahrenheit
 * (xK − 273.15) × 9/5 + 32
 */

class OpenWeather(navController: NavController, testViewModel: TestViewModel) {

    @Composable
    fun DoOpenWeather(){
        var listWeather = remember{ mutableStateListOf<String>() }
        var ndx = 0
        val scrollState = rememberScrollState()

        var altColor = Color(0xFFF47A38)
        var bgColor = Color(0xff48484a)

        Column{
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
                    .background(bgColor, RectangleShape)
                    .border(2.dp, color = Color.Black)
                    .clickable {
                        getCurrentData() {
                            it.forEach { data ->
                                println("${data.first} ${data.second}")
                                listWeather.add("${data.first} ${data.second}")
                            }

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

            Column(modifier = Modifier.verticalScroll(scrollState)){
                listWeather.forEach { data ->
                    Text(data)
                    }
                }
            }

        }



    private fun getCurrentData(callback:(MutableList<Pair<String,String>>) -> Unit) {

//        DataHeading.values().forEach {
//            println(it)
//        }

        //https://api.openweathermap.org/data/2.5/weather?lat=41.61626448849655&lon=-70.44671000806197&appid=330aa600b4d24eb3a29f1fccdc436e93

        val baseUrl = "https://api.openweathermap.org/"
        val lat = "41.61626448849655"
        val lon = "-70.44671000806197"
        val appId = "330aa600b4d24eb3a29f1fccdc436e93"
        val units = "imperial"

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(WeatherService::class.java)
        val call = service.getCurrentWeatherData(lat, lon, appId, units)
        val weatherData:MutableList<Pair<String,String>> = mutableListOf()

        call!!.enqueue(object : Callback<WeatherResponse?> {

            override fun onResponse(
                call: Call<WeatherResponse?>,
                response: Response<WeatherResponse?>
            ) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!

                    weatherData.add(Pair("country",weatherResponse.sys?.country!!))
                    weatherData.add(Pair("sunrise",weatherResponse.sys?.sunrise!!.toString()))
                    weatherData.add(Pair("sunset",weatherResponse.sys?.sunset!!.toString()))
                    weatherData.add(Pair("temp","${weatherResponse.main?.temp!!} ℉"))
                    weatherData.add(Pair("humidity",weatherResponse.main?.humidity!!.toString()))
                    weatherData.add(Pair("temp_max","${weatherResponse.main?.temp_max!!} ℉"))
                    weatherData.add(Pair("temp_min","${weatherResponse.main?.temp_min!!} ℉"))
                    weatherData.add(Pair("feels_like","${weatherResponse.main?.feels_like!!} ℉"))
                    weatherData.add(Pair("pressure",weatherResponse.main?.pressure!!.toString()))
                    weatherData.add(Pair("lat",weatherResponse.coord?.lat!!.toString()))
                    weatherData.add(Pair("lon",weatherResponse.coord?.lon!!.toString()))
                    weatherData.add(Pair("weather id",weatherResponse.weather.get(0).id.toString()))
                    weatherData.add(Pair("main",weatherResponse.weather.get(0).main.toString()))
                    weatherData.add(Pair("description",weatherResponse.weather.get(0).description.toString()))
                    weatherData.add(Pair("icon",weatherResponse.weather.get(0).icon.toString()))
                    weatherData.add(Pair("wind speed",weatherResponse.wind?.speed.toString()))
                    weatherData.add(Pair("wind deg",Bearing.findBearing(weatherResponse.wind?.deg)))
                    weatherData.add(Pair("wind gust",weatherResponse.wind?.gust.toString()))
                    weatherData.add(Pair("clouds all",weatherResponse.clouds?.all.toString()))
                    weatherData.add(Pair("clouds dt",weatherResponse.clouds?.dt.toString()))
                    weatherData.add(Pair("timezone",weatherResponse.timezone!!.toString()))
                    weatherData.add(Pair("id",weatherResponse.id!!.toString()))
                    weatherData.add(Pair("name",weatherResponse.name!!.toString()))
                    weatherData.add(Pair("cod",weatherResponse.cod!!.toString()))
                    weatherData.add(Pair("visibility",weatherResponse.visibility!!.toString()))
                    callback(weatherData)
                }
            }

            override fun onFailure(call: Call<WeatherResponse?>, t: Throwable) {
                println(t.message)
            }
        })
    }

    fun convertKelvinFahrenheit(kelvin:Float):String{
        val dec = DecimalFormat("###")
        return "${dec.format(((kelvin - 273.15) * 9/5 + 32))} °F"
    }


}// end class

/*
sample weather data JSON
{
"coord":{"lon":-70.4467,"lat":41.6163},
"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],
"base":"stations",
"main":{"temp":298.31,"feels_like":299.15,"temp_min":295.31,"temp_max":302.29,"pressure":1022,"humidity":87},
"visibility":10000,
"wind":{"speed":10.29,"deg":230,"gust":13.89},
"clouds":{"all":90},"dt":1624822509,
"sys":{"type":1,"id":4119,"country":"US","sunrise":1624784972,"sunset":1624839604},
"timezone":-14400,
"id":4933989,
"name":"Cotuit",
"cod":200
}
 */

interface WeatherService {
    @GET("data/2.5/weather?")
    fun getCurrentWeatherData(
        @Query("lat") lat: String?,
        @Query("lon") lon: String?,
        @Query("APPID") app_id: String?,
        @Query("units") units: String?
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
    var dt: Float? = 0f,
    var id: Int? = 0,
    var name: String? = null,
    var cod: Float? = 0f,
    var timezone: Float? = 0f,
    var visibility:Float? = 0f
)

data class Weather (
    var id: Int = 0,
    var main: String? = null,
    var description: String? = null,
    var icon: String? = null
)

data class Clouds (
    var all: Float = 0f,
    var dt: Float = 0f
)

data  class Rain (
    var h3: Float = 0f
)

data class Wind (
    var speed: Float = 0f,
    var deg: Float = 0f,
    var gust: Float = 0f
)

data class Main (
    var temp: Float = 0f,
    var humidity: Float = 0f,
    var pressure: Float = 0f,
    var temp_min: Float = 0f,
    var temp_max: Float = 0f,
    var feels_like: Float = 0f
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

enum class DataHeading (item: String){
    COUNTRY("country"),
    SUNRISE("sunrise"),
    SUNSET("sunset"),
    TEMP("temp"),
    HUMIDITY("humidity"),
    TEMP_MAX("temp_max"),
    TEMP_MIN("temp_min"),
    FEELS_LIKE("feels_like"),
    PRESSURE("atm pressure"),
    LAT("latitude"),
    LON("longitude"),
    ID("id"),
    MAIN("main"),
    DESCRIPTION("description"),
    ICON("icon code"),
    SPEED("wind speed"),
    DEG("wind direction"),
    GUST("wind gust"),
    ALL("clouds all"),
    DT("clouds dt"),
    TIMEZONE("timezone"),
    ALT_ID("id"),
    NAME("name"),
    COD("cod"),
    VISIBILITY("visiility")
}


