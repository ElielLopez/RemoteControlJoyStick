package com.example.ex32.view

//import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.ex32.R
import com.example.ex32.vm.FlightGearViewModel

class JoystickActivity: AppCompatActivity() {

    private lateinit var viewModel: FlightGearViewModel

    var rudderBarView: SeekBar? = null
    var throttleBarView: SeekBar? = null

    //@SuppressLint("ClickableViewAccessibility")
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
    }
}