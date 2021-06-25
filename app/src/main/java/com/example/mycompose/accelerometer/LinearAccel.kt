

package com.example.mycompose.accelerometer

import android.app.Service
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.IBinder
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

/**
 * The linear acceleration sensor provides you with a three-dimensional vector representing
 * acceleration along each device axis, excluding gravity. You can use this value to perform
 * gesture detection. The value can also serve as input to an inertial navigation system,
 * which uses dead reckoning. The following code shows you how to get an instance of the default
 * linear acceleration sensor:
 */

class LinearAccel(val navController: NavController, val sensorManager: SensorManager) {

    private lateinit var accelListener: SensorEventListener

    @Composable
    fun TestKotlinLinAccel() {

        var listAccel = remember { mutableStateListOf<String>() }
        val scrollState = rememberScrollState()
        var ndx = 0

        Column {
            Row {

                Button(onClick = {
                    setUp() {
                        ndx++
                        if(ndx == 1){
                            listAccel.add(it)
                        }else if(ndx >= 10){
                            ndx = 0
                        }
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
                listAccel.forEach { message ->
                    Text(message)
                }
            }
        }
    }

    private fun removeListener() {
        sensorManager.unregisterListener(accelListener)
    }

    private fun setUp(callback: (String) -> Unit) {

        accelListener = MyLinAccelListener {
            callback(it)
        }

        sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)?.also { accelerometer ->
            sensorManager.registerListener(
                accelListener,
                accelerometer,
                SensorManager.SENSOR_DELAY_NORMAL,
                SensorManager.SENSOR_DELAY_UI
            )
            println(accelerometer)
            callback(accelerometer.toString())
        }

    }


}

class MyLinAccelListener(val callback: (String) -> Unit) : Service(), SensorEventListener {

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_LINEAR_ACCELERATION) {
            callback("x-axis ${event.values[0]}  y-axis ${event.values[1]} z-axis ${event.values[2]}")
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        println("--------------------------------accelerometer onAccuracyChanged------------------------------------")
        println(sensor?.type.toString())
    }

    override fun onBind(intent: Intent?): IBinder? {
        println("--------------------------------accelerometer onBind------------------------------------")
        println(intent.toString())
        return MyBinder()
    }

}
