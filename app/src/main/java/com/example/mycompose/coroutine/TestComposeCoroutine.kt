package com.example.mycompose.coroutine

import android.annotation.SuppressLint
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycompose.models.TestViewModel
import kotlinx.coroutines.launch

class TestComposeCoroutine(
    navController: NavController,
    testViewModel: TestViewModel,
    locationManager: LocationManager
) {

    var managerLocation: LocationManager = locationManager


    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun DoTestCoroutine() {
        //val testDestructuring = TestDestructuring()
        //testDestructuring.doTest()
        FunWithLocation()
    }

    /**
     * provider – a provider listed by getAllProviders()
     * minTimeMs – minimum time interval between location updates in milliseconds
     * minDistanceM – minimum distance between location updates in meters
     */
    @SuppressLint("MissingPermission")
    private suspend fun getLocation(callback: (Location) -> Unit) {
        managerLocation.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            5000,
            5f,
            LocationListener { location ->
                callback(location)
            })
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun FunWithLocation() {
        // Returns a scope that's cancelled when FunWithLocation is removed from composition
        val coroutineScope = rememberCoroutineScope()

        var locationInfo by remember { mutableStateOf("") }

        val (location, setLocation) = remember { mutableStateOf<Location?>(null) }

        val getLocationOnClick: () -> Unit = {
            locationInfo = "pending..."
            coroutineScope.launch {
                val location = getLocation() {

                    locationInfo = "longitude: ${it.longitude} \n" +
                            "latitude: ${it.latitude} \n" +
                            "altitude: ${it.altitude} \n" + // meters above the WGS 84 reference ellipsoid.
                            "accuracy: ${it.accuracy} \n" +
                            // Bearing is the horizontal direction of travel of this device, and is not related to the device orientation.
                            // It is guaranteed to be in the range (0.0, 360.0] if the device has a bearing.
                            "bearing: ${it.bearing} \n" +
                            "bearingAccuracyDegrees: ${it.bearingAccuracyDegrees} \n" +
                            "elapsedRealtimeNanos: ${it.elapsedRealtimeNanos} \n" +
                            "isFromMockProvider: ${it.isFromMockProvider} \n" +
                            "provider: ${it.provider} \n" +
                            "speed: ${it.speed} " // meters/second over ground.

                    println(locationInfo)

                    // lat 41.61717844, lon -70.44669206  (41.61717844, -70.44669206) (41°37'02.0"N 70°26'48.0"W)
                    // Orthometric height (height above EGM96 geoid which approximates mean sea level): 27.8m 91.2 ft
                }
            }
        }

        Column {

            Text(locationInfo)

            Button(onClick = getLocationOnClick) {
                Text("Detect Location")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Well, what is this all about?\n\n" +
                        "Very simply, I was flummoxed on how to include a call " +
                        "to a Kotlin coroutine from within a Composable. " +
                        "Every time I tried, I kept getting a compile time error " +
                        "That was something to the effect the 'A suspended function " +
                        "cannot be called inside a Composable' ... or something to that " +
                        "effect.  So, I needed to figure out how to incorporate a Kotlin " +
                        "Coroutine (including Launch & Suspend) in a Composable.\n\n" +
                        "And here is the result of that research\n\n" +
                        "Press 'Detect Location' to see it in action."
            )
        }


    }


}

