package ru.way2mars.exampledi.presentation

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    init{
        Log.e("404", "ViewModel created")
    }

    override fun onCleared() {
        Log.e("404", "ViewModel cleared")
        super.onCleared()
    }
}