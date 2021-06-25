package com.example.mycompose.geomagnetic

import com.example.mycompose.accelerometer.MyBinder
import android.app.Service
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/**
Azimuth (degrees of rotation about the -z axis). This is the angle between the device's
current compass direction and magnetic north. If the top edge of the device faces magnetic north,
the azimuth is 0 degrees; if the top edge faces south, the azimuth is 180 degrees. Similarly, if
the top edge faces east, the azimuth is 90 degrees, and if the top edge faces west, the azimuth is
270 degrees.

Pitch (degrees of rotation about the x axis). This is the angle between a plane parallel to the
device's screen and a plane parallel to the ground. If you hold the device parallel to the ground
with the bottom edge closest to you and tilt the top edge of the device toward the ground, the pitch
angle becomes positive. Tilting in the opposite direction— moving the top edge of the device away
from the ground—causes the pitch angle to become negative. The range of values is -180 degrees to
180 degrees.

Roll (degrees of rotation about the y axis). This is the angle between a plane perpendicular to the
device's screen and a plane perpendicular to the ground. If you hold the device parallel to the
ground with the bottom edge closest to you and tilt the left edge of the device toward the ground,
the roll angle becomes positive. Tilting in the opposite direction—moving the right edge of the
device toward the ground— causes the roll angle to become negative. The range of values is -90
degrees to 90 degrees.
 */

class AndroidGeomagnetic (val navController: NavController, private val sensorManager: SensorManager) {


    private lateinit var geomagneticListener: SensorEventListener

    @RequiresApi(Build.VERSION_CODES.N)
    @Composable
    fun TestKotlinGeomagnetic() {

        var listGeomagnetic = remember { mutableStateListOf<String>() }
        var geomagneticValue by remember { mutableStateOf("")}
        val scrollState = rememberScrollState()
        var ndx = 0
        var showHeader by remember { mutableStateOf(true) }

        Column {

            Row {
                Button(onClick = {
                    setUp() {

                        if(showHeader){
                            showHeader = false
                            listGeomagnetic.add(it) // once only show the gravity hardware
                        }

                        if(ndx == 10){
                            //listGeomagnetic.add(it)
                            geomagneticValue = it
                            ndx = 0
                        }
                        ndx++
                    }
                }) {
                    Text("Start")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(onClick = { removeListener() }) {
                    Text("Stop")
                }
            }


            Column(modifier = Modifier.verticalScroll(scrollState)) {
                listGeomagnetic.forEach { message ->
                    Text(message)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(geomagneticValue)
        }
    }

    private fun removeListener() {
        sensorManager.unregisterListener(geomagneticListener)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setUp(callback: (String) -> Unit) {

        geomagneticListener = MyGeomagneticListener {
            callback(it)
        }

        sensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR)?.also { geomagnet ->
            sensorManager.registerListener(
                geomagneticListener,
                geomagnet,
                SensorManager.SENSOR_DELAY_NORMAL)
            callback(geomagnet.toString())
        }

    }

}

class MyGeomagneticListener(val callback: (String) -> Unit) : Service(), SensorEventListener {

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR) {
            callback("Pitch:${event.values[0]} Roll:${event.values[1]} Azimuth:${event.values[2]}")
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        println("GEOMAGNETIC")
        println(sensor?.type.toString())
    }

    override fun onBind(intent: Intent?): IBinder? {
        println("-------------------------------- GEOMAGNETIC onBind ------------------------------------")
        println(intent.toString())
        return MyBinder()
    }

}