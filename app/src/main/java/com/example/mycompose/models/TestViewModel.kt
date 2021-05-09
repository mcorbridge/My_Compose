package com.example.mycompose.models

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

class TestViewModel : ViewModel() {


    // LiveData holds state which is observed by the UI
    // (state flows down from ViewModel)
    private val _name = MutableLiveData("")
    var name: LiveData<String> = _name

    // onNameChanged is an event we're defining that the UI can invoke
    // (events flow up from UI)
    fun onNameChanged(newName: String) {
        println("newName -----------> $newName")
        _name.value = newName
    }

    private val _color =  MutableLiveData(Color.Magenta)
    var color: LiveData<Color> = _color

    fun onColorChanged(newColor: Color){
        _color.value = newColor
    }

    private val _kounter =  MutableLiveData(0)
    var kounter: LiveData<Int> = _kounter

    fun onKounterChanged(newKount: Int){
        _kounter.value = newKount
    }

    private lateinit var _dims:Pair<Float, Float>

    fun setScreenDims(context: Context) {

        _dims = Pair(context.resources.displayMetrics.widthPixels / context.resources.displayMetrics.density,
            context.resources.displayMetrics.heightPixels / context.resources.displayMetrics.density)

    }

    fun getScreenDims():Pair<Float,Float>{
        return _dims
    }


}