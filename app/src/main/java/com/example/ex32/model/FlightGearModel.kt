package com.example.ex32.model

object FlightGearModel {

    fun connect(ip: String, port: Int) {
        println("inside model! IP is : $ip")
        println("inside model! port number is : $port")
    }

    fun rudderChanged(rudder: Float){
        println("Model Rudder is: $rudder")
    }

    fun throttleChanged(throttle: Float) {
        println("Model throttle is: $throttle")
    }
}