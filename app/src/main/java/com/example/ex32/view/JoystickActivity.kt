package com.example.ex32.view

//import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
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

    //-----


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

//        var intent2 = Intent(this, JoystickTestActivity::class.java)
//        startActivity(intent2)
//        val joystick: JoystickTestActivity = findViewById(R.id.joystick)
//        joystick.onChange = {a : Float, e : Float ->
//            viewModel.setAileron(a)
//            viewModel.setElevator(e)
//        }

        val joystick: JoystickView = findViewById(R.id.joystick)
        joystick.onChange = {a : Float, e : Float ->
            viewModel.setAileron(a)
            viewModel.setElevator(e)
        }
    }

//    class JoystickTestActivity @JvmOverloads constructor(
//        context: Context, attrs: AttributeSet? = null,
//        defStyleAtrr: Int = 0
//    ) : View(context, attrs, defStyleAtrr){
//
//        lateinit var onChange: (Float, Float) -> Unit
//        private var center: PointF = PointF()
//        private var radius: Float =  0.0F
//
//
//        private val externalCircle = Paint().apply {
//            color = Color.BLACK
//            style = Paint.Style.FILL_AND_STROKE
//            isAntiAlias = true
//        }
//        override fun onDraw(canvas: Canvas) {
//            canvas.drawCircle(center.x, center.y, radius, externalCircle)
//        }
//
//        override fun onTouchEvent(event: MotionEvent?): Boolean{
//            when(event?.action){
//                MotionEvent.ACTION_MOVE -> touchMove(event.x, event.y)
//            }
//            return true
//        }
//
//        fun touchMove(x: Float, y: Float){
//
//        }
//    }
}