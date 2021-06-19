package com.example.ex32.model

//import com.example.ex32.vm.FlightGearViewModel
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
        dispatchQueue.put(Runnable {
            out.print("set /controls/flight/rudder $rudder \r\n")
            out.flush()
        })
    }

    fun throttleChanged(throttle: Float) {
        //println("Model throttle is: $throttle")
        dispatchQueue.put(Runnable {
            out.print("set /controls/engines/current-engine/throttle $throttle \r\n")
            out.flush()
        })
    }

    fun elevatorChanged(elevator: Float){
        dispatchQueue.put(Runnable {
            out.print("set /controls/flight/elevator $elevator \r\n")
            out.flush()
        })
    }

    fun aileronChanged(aileron: Float){
        dispatchQueue.put(Runnable {
            out.print("set /controls/flight/aileron $aileron \r\n")
            out.flush()
        })
    }
}