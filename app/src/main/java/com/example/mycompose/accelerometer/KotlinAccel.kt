package com.example.mycompose.accelerometer

import android.app.Service
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.IBinder
import android.os.IInterface
import android.os.Parcel
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
import java.io.FileDescriptor

class KotlinAccel(val navController: NavController, val sensorManager: SensorManager) {

    private lateinit var accelListener: SensorEventListener

    @Composable
    fun TestKotlinAccel() {

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

        accelListener = MyAccelListener {
            callback(it)
        }

        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also { accelerometer ->
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

class MyAccelListener(val callback: (String) -> Unit) : Service(), SensorEventListener {

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
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

class MyBinder : IBinder {
    override fun getInterfaceDescriptor(): String? {
        TODO("Not yet implemented")
    }

    override fun pingBinder(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isBinderAlive(): Boolean {
        TODO("Not yet implemented")
    }

    override fun queryLocalInterface(descriptor: String): IInterface? {
        TODO("Not yet implemented")
    }

    override fun dump(fd: FileDescriptor, args: Array<out String>?) {
        TODO("Not yet implemented")
    }

    override fun dumpAsync(fd: FileDescriptor, args: Array<out String>?) {
        TODO("Not yet implemented")
    }

    override fun transact(code: Int, data: Parcel, reply: Parcel?, flags: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun linkToDeath(recipient: IBinder.DeathRecipient, flags: Int) {
        TODO("Not yet implemented")
    }

    override fun unlinkToDeath(recipient: IBinder.DeathRecipient, flags: Int): Boolean {
        TODO("Not yet implemented")
    }

}