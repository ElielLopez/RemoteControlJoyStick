package com.example.ex32.vm

import android.widget.TextView
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

    // Making this function returning a Boolean value, helps to determine if
    // the connections was successful and a message with the status will be shown
    fun connectFG(): Boolean{
        //TODO try and catch and check for valid values
        if(ipAddress.value != null && portNumber.value != null){
            FlightGearModel.connect(ipAddress.value.toString(), (portNumber.value.toString()).toInt())
            return true
        }
        return false
    }

    fun setRudder(rudder: Float){
        FlightGearModel.rudderChanged(rudder)
    }

    fun setThrottle(throttle: Float){
        FlightGearModel.throttleChanged(throttle)
    }

    fun setElevator(elevator: Float){
        FlightGearModel.elevatorChanged(elevator)
    }

    fun setAileron(aileron: Float){
        FlightGearModel.aileronChanged(aileron)
    }

    fun disconnectFG() {
        FlightGearModel.disconnect()
    }
}