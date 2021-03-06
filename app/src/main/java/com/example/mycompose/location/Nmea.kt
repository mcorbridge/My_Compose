package com.example.mycompose.location

import android.annotation.SuppressLint
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.OnNmeaMessageListener
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mycompose.models.TestViewModel
import kotlinx.coroutines.launch

/**
 * this is a bit messy
 * and I will probably clean it up at some point, but it currently gets the job done
 * my task was to find a way to get actual elevation fro NMEA data...
 * I'm only 1/2 way there
 */

class Nmea(
    navController: NavController,
    testViewModel: TestViewModel,
    var locationManager: LocationManager
) {

    companion object {
        private const val PERMISSION_REQUEST_CODE = 1
        var counter = 0
    }

    private var mOnNmeaMessageListener: OnNmeaMessageListener? = null


    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.N)
    @Composable
    fun doNmea() {

        var listAltitude = remember{ mutableStateListOf<String>()}
        var ndx = 0
        val scrollState = rememberScrollState()

        Column {
            FunWithLocation()

            StartNmea() {
                addNmeaListenerAndroidN(){
                    listAltitude.add("${ndx++} : $it")
                }
            }

            Column(modifier = Modifier.verticalScroll(scrollState)){
                listAltitude.forEach { message ->
                    Text(message)
                }
            }
        }


    }

    @SuppressLint("MissingPermission")
    private suspend fun getLocation(callback: (Location) -> Unit) {
        locationManager.requestLocationUpdates(
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


        var stopLocationOnClick: () -> Unit = {
            //managerLocation.removeUpdates(managerLocation)
            println("this is supposed to clear the LocationManager... but I'm not quite sure how")
        }

        val getLocationOnClick: () -> Unit = {
            locationInfo = "pending..."
            coroutineScope.launch {
                val location = getLocation() {
                }
            }
        }

        Column {

            Row {
                Button(onClick = getLocationOnClick) {
                    Text("Detect Location")
                }
                Button(onClick = stopLocationOnClick) {
                    Text("Stop Location")
                }
            }

        }


    }

    @Composable
    fun StartNmea(callback: () -> Unit) {
        Button(onClick = {
            callback()
        }) {
            Text("Start")
        }
    }

    /**
     * h = height above ellipsoid
     * H = elevation, orthometric height <- this is what we want
     * N = geoidal separation (some books call this the geoidal height)
     * H = h ??? N
     */
    private fun nmeaProgress(rawNmea: String, callback: (String) -> Unit) {
        println(rawNmea)
        if (rawNmea.contains("GNGGA")) {
            var tmp: Sequence<String> = rawNmea.trim().splitToSequence(',')

            var H = tmp.elementAt(9).toFloat() - tmp.elementAt(11).toFloat()

            callback("Num Satellites ${tmp.elementAt(7)}, " +
                    "Altitude Mean sea level altitude: ${ tmp.elementAt(9) }m, " +
                    "Geoidal Separation: ${ tmp.elementAt(11) }m " +
                    "elevation: ${H.toString()} ft")
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("MissingPermission")

    private fun addNmeaListenerAndroidN(callback: (String) -> Unit) {
        if (mOnNmeaMessageListener == null) {
            mOnNmeaMessageListener = OnNmeaMessageListener { message, timestamp ->
                nmeaProgress(message){
                    callback(it)
                }
            }
        }
        locationManager.addNmeaListener(mOnNmeaMessageListener!!)
    }


}