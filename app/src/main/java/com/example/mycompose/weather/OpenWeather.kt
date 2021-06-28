package com.example.mycompose.weather

import android.annotation.SuppressLint
import android.app.Service
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import com.example.mycompose.secrets.SECRET_VALUES
import com.google.accompanist.glide.rememberGlidePainter
import com.google.accompanist.imageloading.ImageLoadState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.text.DecimalFormat

/**
 * my own personal weather station
 *
 * cnvert K to Fahrenheit
 * (xK − 273.15) × 9/5 + 32
 */

class OpenWeather(
    navController: NavController,
    testViewModel: TestViewModel,
    val locationManager: LocationManager
) {

    lateinit var myLocationListener:LocationListener

    @SuppressLint("MissingPermission")
    @Composable
    fun DoOpenWeather(){


        var currentLocation:Pair<String,String>
        var listWeather = remember{ mutableStateListOf<String>() }
        var ndx = 0
        val scrollState = rememberScrollState()
        var weatherIcon by remember { mutableStateOf("")}
        var isLocation by remember { mutableStateOf(false)}
        var altColor = Color(0xFFF47A38)
        var bgColor = Color(0xff48484a)

        val cotuit:Pair<String,String> = Pair ("41.61626448849655", "-70.44671000806197")
        val denver:Pair<String,String> = Pair ("39.61786349866042", "-104.9018568687661")
        val toronto:Pair<String,String> = Pair ("43.69188879277894", "-79.39273640987554")

        myLocationListener = MyLocationListener(){
            currentLocation = Pair("${it.latitude}", "${it.longitude}")
            isLocation = true
            getCurrentData(currentLocation.first, currentLocation.second) {
                it.forEach { data ->
                    println("${data.first} ${data.second}")
                    listWeather.add("${data.first}: ${data.second}")
                    if (data.first == "icon") {
                        weatherIcon = data.second
                    }
                }
            }

            removeLocationListener()
        }

        if(!isLocation){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, myLocationListener)
        }

        Column{

                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                        .background(bgColor, RectangleShape)
                        .border(2.dp, color = Color.Black)
                        .clickable {
                            getCurrentData(cotuit.first, cotuit.second) {
                                it.forEach { data ->
                                    println("${data.first} ${data.second}")
                                    listWeather.add("${data.first}: ${data.second}")
                                    if (data.first == "icon") {
                                        weatherIcon = data.second
                                    }
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

            if(weatherIcon != ""){
                val painter = rememberGlidePainter("https://openweathermap.org/img/w/$weatherIcon.png", fadeIn = true)

                Image(
                    painter = painter,
                    contentDescription = "openweathermap",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp))

                when (painter.loadState) {
                    is ImageLoadState.Loading -> {
                        // Display a circular progress indicator whilst loading
                        CircularProgressIndicator(Modifier.align(Alignment.CenterHorizontally))
                    }
                    is ImageLoadState.Error -> {
                        // If you wish to display some content if the request fails
                    }
                }
            }

            Column(modifier = Modifier.verticalScroll(scrollState)){
                listWeather.forEach { data ->
                    Text(data)
                    }
                }
            }

        }

    private fun removeLocationListener(){
        println("-------------------> locationManager.removeUpdates(myLocationListener)")
        locationManager.removeUpdates(myLocationListener)
    }


    private fun getCurrentData(lat:String, lon:String, callback:(MutableList<Pair<String,String>>) -> Unit) {

        val baseUrl = "https://api.openweathermap.org/"
        //val lat = "41.61626448849655"
        val lat = lat
        //val lon = "-70.44671000806197"
        val lon = lon
        val appId = SECRET_VALUES.OPEN_WEATHER_TOKEN
        val units = "imperial"

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(WeatherService::class.java)
        val call = service.getCurrentWeatherData(lat, lon, appId, units)
        val weatherData:MutableList<Pair<String,String>> = mutableListOf()

        call!!.enqueue(object : Callback<WeatherResponse?> {

            @RequiresApi(Build.VERSION_CODES.O)
            override fun onResponse(
                call: Call<WeatherResponse?>,
                response: Response<WeatherResponse?>
            ) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!

                    weatherData.add(Pair("country",weatherResponse.sys?.country!!))
                    weatherData.add(Pair("sunrise", unixTimestampConversion(weatherResponse.sys?.sunrise!! + weatherResponse.timezone!!)))
                    weatherData.add(Pair("sunset", unixTimestampConversion(weatherResponse.sys?.sunset!! + weatherResponse.timezone!!)))
                    weatherData.add(Pair("current temp","${weatherResponse.main?.temp!!} ℉"))
                    weatherData.add(Pair("humidity","${weatherResponse.main?.humidity!!} %"))
                    weatherData.add(Pair("max temp","${weatherResponse.main?.temp_max!!} ℉"))
                    weatherData.add(Pair("min temp","${weatherResponse.main?.temp_min!!} ℉"))
                    weatherData.add(Pair("feels like","${weatherResponse.main?.feels_like!!} ℉"))
                    weatherData.add(Pair("pressure","${weatherResponse.main?.pressure!!}  hPa"))
                    weatherData.add(Pair("lat",weatherResponse.coord?.lat!!.toString()))
                    weatherData.add(Pair("lon",weatherResponse.coord?.lon!!.toString()))
                    weatherData.add(Pair("weather id",weatherResponse.weather.get(0).id.toString()))
                    //weatherData.add(Pair("main",weatherResponse.weather.get(0).main.toString()))
                    weatherData.add(Pair("description",weatherResponse.weather.get(0).description.toString()))
                    weatherData.add(Pair("icon",weatherResponse.weather.get(0).icon.toString()))
                    weatherData.add(Pair("wind speed",weatherResponse.wind?.speed.toString()))
                    weatherData.add(Pair("winds from",Bearing.findBearing(weatherResponse.wind?.deg)))
                    weatherData.add(Pair("wind gust",weatherResponse.wind?.gust.toString()))
                    weatherData.add(Pair("clouds all","${weatherResponse.clouds?.all.toString()} %"))
                    weatherData.add(Pair("clouds dt",weatherResponse.clouds?.dt.toString()))
                    weatherData.add(Pair("timezone",weatherResponse.timezone!!.toString()))
                    weatherData.add(Pair("id",weatherResponse.id!!.toString()))
                    weatherData.add(Pair("location",weatherResponse.name!!.toString()))
                    weatherData.add(Pair("response code",weatherResponse.cod!!.toString()))
                    weatherData.add(Pair("visibility","${weatherResponse.visibility!!.toString()} m"))
                    callback(weatherData)
                }
            }

            override fun onFailure(call: Call<WeatherResponse?>, t: Throwable) {
                println(t.message)
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun unixTimestampConversion(epochSecond: Float):String{
        return java.time.format.DateTimeFormatter.ISO_INSTANT.format(java.time.Instant.ofEpochSecond(
            epochSecond.toLong()
        ))
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

class MyLocationListener(val callback: (Location) -> Unit) : LocationListener {

    override fun onLocationChanged(location: Location) {
        callback(location)
    }

}


