package com.example.mycompose.coroutine

import android.annotation.SuppressLint
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.example.mycompose.models.TestViewModel
import kotlinx.coroutines.launch

class TestComposeCoroutine(
    navController: NavController,
    testViewModel: TestViewModel,
    locationManager: LocationManager
) {

    var managerLocation:LocationManager = locationManager


    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun DoTestCoroutine(){
        //val testDestructuring = TestDestructuring()
        //testDestructuring.doTest()
        FunWithLocation()
    }

    @SuppressLint("MissingPermission")
    private suspend fun getLocation(callback: (Location) -> Unit) {
        println("*************************************** get location ***************************************")


        managerLocation.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, LocationListener { location ->
            callback(location)
        })
    }




    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun FunWithLocation() {
        // Returns a scope that's cancelled when FunWithLocation is removed from composition
        val coroutineScope = rememberCoroutineScope()

        val (location, setLocation) = remember { mutableStateOf<Location?>(null) }


        val getLocationOnClick: () -> Unit = {
            coroutineScope.launch {
                val location = getLocation(){
                    println("longitude ${ it.longitude } " +
                            "latitude ${ it.latitude } " +
                            "altitude ${ it.altitude } " +
                            "accuracy ${ it.accuracy } " +
                            "bearing ${ it.bearing } " +
                            "bearingAccuracyDegrees ${ it.bearingAccuracyDegrees } " +
                            "elapsedRealtimeNanos ${ it.elapsedRealtimeNanos } " +
                            "isFromMockProvider ${ it.isFromMockProvider } " +
                            "provider ${ it.provider } " +
                            "speed ${ it.speed } ")
                }
            }
        }

        Button(onClick = getLocationOnClick) {
            Text("detectLocation")
        }
    }


}

