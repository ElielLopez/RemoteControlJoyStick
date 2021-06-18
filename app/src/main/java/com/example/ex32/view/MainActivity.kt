package com.example.ex32.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.ex32.R
import com.example.ex32.databinding.ActivityMainBinding
import com.example.ex32.vm.FlightGearViewModel
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var viewModel: FlightGearViewModel

    //TODO unmark this line if needed
    //@SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProviders.of(this)
            .get(FlightGearViewModel::class.java)

        dataBinding.lifecycleOwner = this
        dataBinding.viewmodel = viewModel

//        var connectButton = findViewById<Button>(R.id.connectButton)
//        connectButton.setOnClickListener{
//            //when the button is clicked, connect to flightGear and start the joystick activity
////            if(viewModel.connectFG()){
////                //var intent = Intent(this, JoystickActivity::class.java)
////                //startActivity(intent)
////                println("Test")
////            }
//            viewModel.connectFG()
//        }
    }
}