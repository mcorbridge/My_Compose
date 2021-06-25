package com.example.mycompose.temperature

import android.app.Service
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycompose.accelerometer.MyBinder

/**
 * Temperature doesn't seem to work.
 * There is no temperature sensor?
 */

class AndroidTemp(val navController: NavController, private val sensorManager: SensorManager) {

    private lateinit var gravityListener: SensorEventListener

    @RequiresApi(Build.VERSION_CODES.N)
    @Composable
    fun TestKotlinTemp() {

        var listGravity = remember { mutableStateListOf<String>() }
        val scrollState = rememberScrollState()
        var ndx = 0

        Column {
            Row {

                Button(onClick = {
                    setUp() {
                        listGravity.add(it)
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
                listGravity.forEach { message ->
                    Text(message)
                }
            }
        }
    }

    private fun removeListener() {
        sensorManager.unregisterListener(gravityListener)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setUp(callback: (String) -> Unit) {

        gravityListener = MyGravityListener {
            callback(it)
        }

        sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)?.also { gravity ->
            sensorManager.registerListener(
                gravityListener,
                gravity,
                SensorManager.SENSOR_DELAY_NORMAL
            )
            callback(gravity.toString())
        }

    }


}

class MyGravityListener(val callback: (String) -> Unit) : Service(), SensorEventListener {

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_GRAVITY) {
            callback("x:${event.values[0]} y:${event.values[1]} z:${event.values[2]}")
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        println("GRAVITY")
        println(sensor?.type.toString())
    }

    override fun onBind(intent: Intent?): IBinder? {
        println("-------------------------------- GRAVITY onBind ------------------------------------")
        println(intent.toString())
        return MyBinder()
    }

}