package com.example.ex32.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ex32.model.FlightGearModel
import androidx.databinding.Observable
import androidx.lifecycle.LiveData


class FlightGearViewModel: ViewModel(), Observable {

    val _ipAddress = MutableLiveData<String>()
    val _portNumber = MutableLiveData<String>()

    val ipAddress: LiveData<String> = _ipAddress
    val portNumber: LiveData<String> = _portNumber

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}
    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}

    fun connectFG(){
        println("inside view model connect method")
        println("IP is: ${ipAddress.value}")
        println("port number is: ${portNumber.value}")

//TODO keep for backup
//        if(ipAddress.value != null && portNumber.value != null) {
//            FlightGearModel.connect(ipAddress.value.toString(), (portNumber.value.toString()).toInt())
//            println("inside view model if condition")
//        }

        //TODO try and catch and check for valid values

        FlightGearModel.connect(ipAddress.value.toString(), (portNumber.value.toString()).toInt())
    }

    fun setRudder(rudder: Float){
        println("VM rudder is: $rudder")
        FlightGearModel.rudderChanged(rudder)
    }

    fun setThrottle(throttle: Float){
        println("VM throttle is: $throttle")
        FlightGearModel.rudderChanged(throttle)
    }
}