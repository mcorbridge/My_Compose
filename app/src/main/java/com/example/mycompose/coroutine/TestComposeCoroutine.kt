package com.example.mycompose.coroutine

import android.annotation.SuppressLint
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.OnNmeaMessageListener
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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

    // mOnNmeaMessageListener = National Marine Electronics Association
    // What Exactly Is GPS NMEA Data? (https://www.gpsworld.com/what-exactly-is-gps-nmea-data/)
    // NMEA Message Structure:

    // $GPGGA,181908.00,3404.7041778,N,07044.3966270,
    // W,4,13,1.00,495.144,M,29.200,M,0.10,0000*40

    // GP represent that it is a GPS position (GL would denote GLONASS).
    // 181908.00 is the time stamp: UTC time in hours, minutes and seconds.
    // 3404.7041778 is the latitude in the DDMM.MMMMM format. Decimal places are variable.
    // N denotes north latitude.
    // 07044.3966270 is the longitude in the DDDMM.MMMMM format. Decimal places are variable.
    // W denotes west longitude.
    // 4 denotes the Quality Indicator:
    //      1 = Uncorrected coordinate
    //      2 = Differentially correct coordinate (e.g., WAAS, DGPS)
    //      4 = RTK Fix coordinate (centimeter precision)
    //      5 = RTK Float (decimeter precision.
    // 13 denotes number of satellites used in the coordinate.
    // 1.0 denotes the HDOP (horizontal dilution of precision).
    // 495.144 denotes altitude of the antenna.
    // M denotes units of altitude (eg. Meters or Feet)
    // 29.200 denotes the geoidal separation (subtract this from the altitude of the antenna to arrive at the Height Above Ellipsoid (HAE).
    // M denotes the units used by the geoidal separation.
    // 1.0 denotes the age of the correction (if any).
    // 0000 denotes the correction station ID (if any).
    // *40 denotes the checksum.

    private var mOnNmeaMessageListener: OnNmeaMessageListener? = null


    @SuppressLint("MissingPermission")
    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun DoTestCoroutine() {
        //val testDestructuring = TestDestructuring()
        //testDestructuring.doTest()
        FunWithLocation()

        //var nmea = Nmea()
        //nmea.doNmea(managerLocation)


//        mOnNmeaMessageListener?.let { managerLocation.addNmeaListener(it) }
//        mOnNmeaMessageListener?.onNmeaMessage("onNmeaMessage", System.currentTimeMillis())
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


        var stopLocationOnClick: () -> Unit = {
            //managerLocation.removeUpdates(managerLocation)
            println("this is supposed to clear the LocationManager... but I'm not quite sure how")
        }

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

                    // The altitude is the altitude above the WGS84 reference ellipsoid.
                    // It is not the altitude above ground level or sea level.

                    // You just need to calculate the difference between the ellipsoid and sea level. Which is non-trivial.
                }
            }
        }

        Column {

            Text(locationInfo)

            Row {
                Button(onClick = getLocationOnClick) {
                    Text("Detect Location")
                }
                Button(onClick = stopLocationOnClick) {
                    Text("Stop Location")
                }
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

