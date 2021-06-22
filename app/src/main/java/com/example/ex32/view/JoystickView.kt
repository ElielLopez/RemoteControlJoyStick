package com.example.ex32.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

class JoystickView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAtrr: Int = 0
) : View(context, attrs, defStyleAtrr){

    private var aileron: Float = 0.0f
    private var elevator: Float = 0.0f

    lateinit var onChange: (Float, Float) -> Unit
    private var radiusExternalCircle: Float =  0.0F
    private var centerExternalCircle: PointF = PointF()
    private var radiusInternalCircle: Float =  0.0F
    private var centerInternalCircle: PointF = PointF()


    private val externalCircle = Paint().apply {
        style = Paint.Style.FILL_AND_STROKE //.STROKE
        color = Color.BLACK // Color.parseColor('#FFC107')
        isAntiAlias = true
    }
    private val internalCircle = Paint().apply {
        style = Paint.Style.FILL_AND_STROKE //.STROKE
        color = Color.TRANSPARENT // Color.parseColor('#FFC107')
        isAntiAlias = true
    }

    override fun onSizeChanged(width: Int, height: Int, oldw: Int, oldh: Int){
        radiusExternalCircle = 0.3f* min(width,height).toFloat()
        centerExternalCircle = PointF(width/2.0f, height/2.0f)
        radiusInternalCircle = 0.1f* min(width,height).toFloat()
        centerInternalCircle = PointF(width/2.0f, height/2.0f)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(centerExternalCircle.x, centerExternalCircle.y, radiusExternalCircle, externalCircle)
        canvas.drawCircle(centerInternalCircle.x, centerInternalCircle.y, radiusInternalCircle, internalCircle)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean{
        if(event == null) return true

        when(event?.action){
            MotionEvent.ACTION_MOVE -> touchMove(event.x, event.y)
            MotionEvent.ACTION_UP -> touchUp(event.x, event.y)//TODO()
            MotionEvent.ACTION_DOWN -> touchDown(event.x, event.y) //TODO()
        }
        return true
    }

    private fun touchMove(x: Float, y: Float){
        // TODO ("Update positions and properties of drawn items")
        val distance = calcDist(x, y)

        // the loc is inside bound
        if(distance < radiusExternalCircle) {
            centerInternalCircle.x = x
            centerInternalCircle.y = y
        } else if(radiusExternalCircle < distance) {
            // TODO check this line
            invalidate()
        }
        aileron = (x - centerExternalCircle.x) / radiusExternalCircle
        elevator = (y - centerExternalCircle.y) / radiusExternalCircle

        try{
            onChange(aileron, elevator)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        // will render again the screen
        invalidate()
    }

    private fun touchUp(x: Float, y: Float) {
        centerInternalCircle.x = centerExternalCircle.x
        centerInternalCircle.y = centerExternalCircle.y
        invalidate()
    }
    private fun touchDown(x: Float, y: Float) {
        centerExternalCircle.x = centerInternalCircle.x
        centerExternalCircle.y = centerInternalCircle.y
        invalidate()
    }

    private fun calcDist(x: Float, y: Float) : Float {
        var dx = (x - centerExternalCircle.x)
        dx = dx.pow(2)

        var dy = (y - centerExternalCircle.y)
        dy = dy.pow(2)

        return sqrt(dx + dy)
    }
}