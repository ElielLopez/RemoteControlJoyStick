package com.example.ex32.view

import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.ex32.R
import com.example.ex32.vm.FlightGearViewModel

// manual activity contain the features for the user to control the
// aircraft. implementing seek bars of rudder and throttle and the Joystick component.
// the joystick have its own view but will be drawn alongside the seek bars.
class ManualActivity: AppCompatActivity() {

    private lateinit var viewModel: FlightGearViewModel

    var rudderBarView: SeekBar? = null
    var throttleBarView: SeekBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joystick)

        viewModel = ViewModelProviders.of(this)
            .get(FlightGearViewModel::class.java)

        rudderBarView = findViewById(R.id.rudderBar)
        rudderBarView?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                Toast.makeText(applicationContext, "seekbar progress: $progress", Toast.LENGTH_SHORT).show()
                viewModel.setRudder(progress / 100.0F)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(applicationContext, "seekbar touch started!", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(applicationContext, "seekbar touch stopped!", Toast.LENGTH_SHORT).show()
            }
        })

        throttleBarView = findViewById(R.id.throttleBar)
        throttleBarView?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                Toast.makeText(applicationContext, "seekbar progress: $progress", Toast.LENGTH_SHORT).show()
                viewModel.setThrottle(progress / 100.0F)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(applicationContext, "seekbar touch started!", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(applicationContext, "seekbar touch stopped!", Toast.LENGTH_SHORT).show()
            }
        })

        // calling onChange method with 2 float numbers: aileron and elevator
        val joystick: JoystickView = findViewById(R.id.joystick)
        joystick.onChange = {a : Float, e : Float ->
            viewModel.setAileron(a)
            viewModel.setElevator(e)
        }
    }

}