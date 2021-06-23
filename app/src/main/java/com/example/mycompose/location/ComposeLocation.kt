package com.example.mycompose.location

import android.annotation.SuppressLint
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycompose.models.TestViewModel

class ComposeLocation(navController: NavController, testViewModel: TestViewModel, locationManager: LocationManager) {

    var managerLocation:LocationManager = locationManager

    @SuppressLint("MissingPermission")
    @Composable
    fun DoLocation(){

        var locationLongitude by remember { mutableStateOf("Longitude pending...") }
        var locationLatitude by remember { mutableStateOf("Latitude pending...") }
        var locationAltitude by remember { mutableStateOf("Altitude pending...") }
        var locationAccuracy by remember { mutableStateOf("Accuracy pending...") }
        var isLocationFound by remember { mutableStateOf(false) }
        var numLocations by remember { mutableStateOf(0)}

        /**
         * This is a good example of 'thinking in compose'
         * Normally in a imperative programming paradigm we would create ONE Text UI and update it
         * by using findViewById()
         * Compose is a declarative programming paradigm where any UI that displays a mutable value
         * is *recomposed* with the updated value
         */
        Column {
            if(!isLocationFound){
                LocationMessage(locationLongitude)
                LocationMessage(locationLatitude)
                LocationMessage(locationAltitude)
                LocationMessage(locationAccuracy)
            }else{
                LocationMessage(locationLongitude, true )
                LocationMessage(locationLatitude, true)
                LocationMessage(locationAltitude, true)
                LocationMessage(locationAccuracy, true)
                Text("Request Location Updates: $numLocations")
                Button(onClick = {
                    managerLocation.removeUpdates {
                        println("not sure how this works")
                    }
                }) {
                    Text("clear location")
                }
            }
        }

        managerLocation.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, LocationListener { location ->
                locationLongitude = "Longitude: ${location.longitude}"
                locationLatitude = "Latitude: ${location.latitude}"
                locationAltitude = "Altitude: ${location.altitude}"
                locationAccuracy = "Accuracy: ${location.accuracy}"
                isLocationFound = true
                numLocations++
        })
    }




    /**
     * we don't use this, but it is a good example of implementing a lambda
     */
    private fun onLocationChanged(location: Location, callback:(String) -> Unit) {
        val locationText = ("Latitude: ${location.latitude} Longitude: ${location.longitude} Altitude: ${location.altitude} Accuracy: ${location.accuracy}")
        println(locationText)
        callback(locationText)

    }

    @Composable
    fun LocationMessage(locationText:String, locationFound:Boolean = false){

        if(!locationFound){
            Text(locationText, color = Color.White, modifier = Modifier
                .background(Color.Gray)
                .fillMaxWidth())
        }else{
            Text(locationText, color = Color.Yellow, fontSize = 20.sp, modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth())
        }

    }


}