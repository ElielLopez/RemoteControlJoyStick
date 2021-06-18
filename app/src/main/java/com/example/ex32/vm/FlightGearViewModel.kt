package com.example.ex32.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class FlightGearViewModel: ViewModel() {
    private val _ipAddress = MutableLiveData<String>()
    private val _portNumber = MutableLiveData<String>()

    val ipAddress: LiveData<String> = _ipAddress
    val portNumber: LiveData<String> = _portNumber

    //val popularity: LiveData<Popularity> = Transformations.map(connected)

    fun connectFG(){
        
    }
}