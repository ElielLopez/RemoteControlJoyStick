package com.example.ex32.model

//import com.example.ex32.vm.FlightGearViewModel
import java.io.IOException
import java.io.PrintWriter
import java.net.Socket
import java.util.concurrent.BlockingDeque
import java.util.concurrent.LinkedBlockingDeque

object FlightGearModel {

    //private lateinit var viewModel: FlightGearViewModel
    private lateinit var fgSocket: Socket

    private lateinit var out: PrintWriter
    var dispatchQueue: BlockingDeque<Runnable> = LinkedBlockingDeque<Runnable>()

    // connecting to the simulator with the IP address and port which is already
    // configured at the simulator settings.
    fun connect(ip: String, port: Int) {
        Thread(Runnable {
            val fgSocket = Socket(ip, port)
            out = PrintWriter(fgSocket.getOutputStream(),true)
            while(true) {
                try {
                    dispatchQueue.take().run()
                    //viewModel.showConnectionMessage("connection succeed")
                } catch (e: InterruptedException) { }
            }
        }).start()
    }

    fun disconnect(){
        fgSocket.close()
        out.close()
    }

    fun rudderChanged(rudder: Float){
        sendCommand("rudder", rudder)
    }

    fun throttleChanged(throttle: Float) {
        sendCommand("throttle", throttle)
    }

    fun elevatorChanged(elevator: Float){
        sendCommand("elevator", elevator)
    }

    fun aileronChanged(aileron: Float){
        sendCommand("aileron", aileron)
    }

    // sending commands to the simulator with the relevant path and value.
    // afterwards, cleaning the command.
    fun sendCommand(feature: String,value: Float){
        var command = ""

        when(feature) {
            "rudder" -> command = "set /controls/flight/rudder $value \r\n"
            "throttle" -> command = "set /controls/engines/current-engine/throttle $value \r\n"
            "elevator" -> command = "set /controls/flight/elevator $value \r\n"
            "aileron" -> command = "set /controls/flight/aileron $value \r\n"
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