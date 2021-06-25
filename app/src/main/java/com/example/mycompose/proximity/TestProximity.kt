package com.example.mycompose.proximity

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
import com.example.mycompose.accelerometer.MyBinder
import com.example.mycompose.models.TestViewModel

/**
 * The proximity sensor is usually used to determine how far away a person's head is from the
 * face of a handset device (for example, when a user is making or receiving a phone call).
 * Most proximity sensors return the absolute distance, in cm,
 * but some return only near and far values. <- Me!
 *
 * Note: Some proximity sensors return binary values that represent "near" or "far."
 * In this case, the sensor usually reports its maximum range value in the far state and
 * a lesser value in the near state. Typically, the far value is a value > 5 cm, but
 * this can vary from sensor to sensor. You can determine a sensor's maximum range by using
 * the getMaximumRange() method.
 *
 * On my phone (Pixel 4a) the sensor activates when something comes within 5cm, then again when
 * that object moves out greater than 5cm (near and far)
 */

class TestProximity(
    val navController: NavController,
    testViewModel: TestViewModel,
    private val sensorManager: SensorManager
) {

    private lateinit var proximityListener: SensorEventListener

    @RequiresApi(Build.VERSION_CODES.N)
    @Composable
    fun TestKotlinProximity() {

        var listProximity = remember { mutableStateListOf<String>() }
        var proximityValue by remember { mutableStateOf("-------------------------") }
        val scrollState = rememberScrollState()
        var ndx = 0
        var showHeader by remember { mutableStateOf(true) }

        Column {

            Row {
                Button(onClick = {
                    setUp() {
                        if (showHeader) {
                            showHeader = false
                            listProximity.add(it) // once only show the proximity hardware
                        }
                        listProximity.add(it)
                        //proximityValue = it
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
                listProximity.forEach { message ->
                    Text(message)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(proximityValue)
        }
    }

    private fun removeListener() {
        sensorManager.unregisterListener(proximityListener)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setUp(callback: (String) -> Unit) {

        proximityListener = MyProximityListener {
            callback(it)
        }

        sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)?.also { proximity ->
            sensorManager.registerListener(
                proximityListener,
                proximity,
                SensorManager.SENSOR_DELAY_FASTEST
            )
            callback(proximity.toString())
        }

    }

}

class MyProximityListener(val callback: (String) -> Unit) : Service(), SensorEventListener {

    var toggle = true

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_PROXIMITY) {
            if(toggle){
                callback("proximity FAR")
            }else{
                callback("     proximity NEAR")
            }
            toggle = !toggle
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        println("PROXIMITY")
        println(sensor?.type.toString())
    }

    override fun onBind(intent: Intent?): IBinder? {
        println("-------------------------------- PROXIMITY onBind ------------------------------------")
        println(intent.toString())
        return MyBinder()
    }

}