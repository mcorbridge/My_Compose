package com.example.mycompose.sensors

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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.io.FileDescriptor

class TestAndroidSensors(var navController: NavController, var sensorManager: SensorManager) {

    private lateinit var pressureListener:SensorEventListener

    @Composable
    fun DoTest(){
        SensorNavigation()
    }

    @Composable
    fun SensorNavigation(){

        var listPressure = remember{ mutableStateListOf<String>() }
        val scrollState = rememberScrollState()
        var ndx = -1

        Column{
            Row{
                Button(onClick = {
                    setUp {
                        ndx++
                        if(ndx == 0){
                            listPressure.add(it)
                        }else if(ndx >= 10){
                            ndx = -1
                        }
                    }
                }) {
                    Text("setup")
                }

                Spacer(modifier=Modifier.width(16.dp))

                Button(onClick = {
                    removeListener()
                }) {
                    Text("Stop")
                }

                Spacer(modifier=Modifier.width(16.dp))

                Button(onClick = {
                    navController.navigate("welcome")
                }) {
                    Text("Main Menu")
                }
            }

            Column(modifier = Modifier.verticalScroll(scrollState)){
                listPressure.forEach { message ->
                    Text(message)
                }
            }
        }
    }

    private fun removeListener(){
        println("Remove sensor listener")
        sensorManager.unregisterListener(pressureListener)
    }

    private fun setUp(callback: (String) -> Unit){

        pressureListener = MyPressureListener {
            callback(it)
        }

        sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)?.also { pressure ->
            sensorManager.registerListener(pressureListener, pressure, SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI)
            callback(pressure.toString())
        }

    }
}

class MyAccelerometerListener : Service(), SensorEventListener{
    override fun onSensorChanged(event: SensorEvent?) {
        println("--------------------------------Accelerometer onSensorChanged------------------------------------")
        println(event.toString())
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        println("--------------------------------Accelerometer onAccuracyChanged------------------------------------")
        println(sensor.toString())
    }

    override fun onBind(intent: Intent?): IBinder? {
        println("--------------------------------Pressure onAccuracyChanged------------------------------------")
        println(intent.toString())
        return MyBinder()
    }

}

class MyPressureListener(val callback: (String) -> Unit) : Service(), SensorEventListener{

    override fun onSensorChanged(event: SensorEvent?) {
        if(event?.sensor?.type == Sensor.TYPE_PRESSURE) {
            callback("----------------------> ${event.values[0]} hPa (millibar)")
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            println("--------------------------------Pressure onAccuracyChanged------------------------------------")
            println(sensor?.type.toString())
    }

    override fun onBind(intent: Intent?): IBinder? {
        println("--------------------------------Pressure onBind------------------------------------")
        println(intent.toString())
        return MyBinder()
    }

}

class MyBinder : IBinder{
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