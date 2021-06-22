package com.example.ex32.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.ex32.R
import com.example.ex32.databinding.ActivityMainBinding
import com.example.ex32.vm.FlightGearViewModel
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {
    var IPTextView: TextView? = null
    var portTextView: TextView? = null
    var connectButtonView: Button? = null

    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var viewModel: FlightGearViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProviders.of(this)
            .get(FlightGearViewModel::class.java)

        dataBinding.lifecycleOwner = this
        dataBinding.viewmodel = viewModel

        var connectButton = findViewById<Button>(R.id.connectButton)
        connectButton.setOnClickListener{
            if(viewModel.connectFG()){
                Toast.makeText(applicationContext, "Connected!", Toast.LENGTH_SHORT).show()
            } else if(!viewModel.connectFG()) {
                Toast.makeText(applicationContext, "Failed to connect!", Toast.LENGTH_SHORT).show()
            }

            viewModel.connectFG()

            // after inserting the IP and the port the views will disappear
            // until the user press on settings button which will make the views visible again.
            IPTextView = findViewById(R.id.IpText)
            IPTextView?.visibility = View.INVISIBLE
            portTextView = findViewById(R.id.PortText)
            portTextView?.visibility = View.INVISIBLE
            connectButtonView = findViewById(R.id.connectButton)
            connectButtonView?.visibility = View.INVISIBLE

            // calling to the new activity of Manual activity which contains
            // the seek bars of rudder and throttle
            // and the joystick component (aileron and elevator)
            openJoystickActivity()
        }
    }

    fun openJoystickActivity(){
        var intent = Intent(this, ManualActivity::class.java)
        startActivity(intent)
    }

    // changing visibility of the ip and port views.
    fun showSettings(view: View){
        IPTextView = findViewById(R.id.IpText)
        IPTextView?.visibility = View.VISIBLE
        portTextView = findViewById(R.id.PortText)
        portTextView?.visibility = View.VISIBLE
        connectButtonView = findViewById(R.id.connectButton)
        connectButtonView?.visibility = View.VISIBLE
    }
}