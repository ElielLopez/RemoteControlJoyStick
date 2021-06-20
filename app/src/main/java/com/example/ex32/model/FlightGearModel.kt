package com.example.ex32.model

//import com.example.ex32.vm.FlightGearViewModel
import java.io.IOException
import java.io.PrintWriter
import java.net.Socket
import java.util.concurrent.BlockingDeque
import java.util.concurrent.LinkedBlockingDeque

object FlightGearModel {

    //private lateinit var viewModel: FlightGearViewModel

    private lateinit var out: PrintWriter
    var dispatchQueue: BlockingDeque<Runnable> = LinkedBlockingDeque<Runnable>()

    fun connect(ip: String, port: Int) {
        Thread(Runnable {
            val fg = Socket(ip, port)
            out = PrintWriter(fg.getOutputStream(),true)
            while(true) {
                try {
                    dispatchQueue.take().run()
                    //viewModel.showConnectionMessage("connection succeed")
                } catch (e: InterruptedException) { }
            }
        }).start()
    }

    fun rudderChanged(rudder: Float){
        //println("Model Rudder is: $rudder")
//        dispatchQueue.put(Runnable {
//            out.print("set /controls/flight/rudder $rudder \r\n")
//            out.flush()
//        })
        sendCommand("rudder", rudder)
    }

    fun throttleChanged(throttle: Float) {
        //println("Model throttle is: $throttle")
//        dispatchQueue.put(Runnable {
//            out.print("set /controls/engines/current-engine/throttle $throttle \r\n")
//            out.flush()
//        })
        sendCommand("throttle", throttle)
    }

    fun elevatorChanged(elevator: Float){
//        dispatchQueue.put(Runnable {
//            out.print("set /controls/flight/elevator $elevator \r\n")
//            out.flush()
//        })
        sendCommand("elevator", elevator)
    }

    fun aileronChanged(aileron: Float){
//        dispatchQueue.put(Runnable {
//            out.print("set /controls/flight/aileron $aileron \r\n")
//            out.flush()
//        })
        sendCommand("aileron", aileron)
    }

    fun sendCommand(feature: String,value: Float){
        var command = ""

        if(feature == "rudder") {
            command = "set /controls/flight/rudder $value \r\n"
        }else if(feature == "throttle") {
            command = "set /controls/engines/current-engine/throttle $value \r\n"
        }else if(feature == "elevator") {
            command = "set /controls/flight/elevator $value \r\n"
        }else if(feature == "aileron") {
            command = "set /controls/flight/aileron $value \r\n"
        }
        try{
            dispatchQueue.put(Runnable {
                out.print(command)
                out.flush()
            })
        }catch (e: IOException){
            e.printStackTrace()
        }
    }
}