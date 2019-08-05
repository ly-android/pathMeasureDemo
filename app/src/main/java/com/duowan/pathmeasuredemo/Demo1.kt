package com.duowan.pathmeasuredemo

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View


/**
 * Created by liyong on 2019-08-03.
 */
class Demo1 : AppCompatActivity() {

    companion object {
        const val TAG = "Demo1"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(View1(this))
        title = TAG
    }

    class View1(context: Context) : View(context) {

        private val path = Path()
        private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        private val measure1 = PathMeasure(path, false)
        private val measure2 = PathMeasure(path, true)

        init {
            paint.strokeWidth = 10f
            paint.style = Paint.Style.STROKE
        }

        override fun onDraw(canvas: Canvas) {
            paint.color = Color.RED
            canvas.drawLine(width / 2f, 0f, width / 2f, height * 1f, paint)
            canvas.drawLine(0f, height / 2f, width * 1f, height / 2f, paint)
            canvas.translate(width / 2f, height / 2f)

            path.lineTo(0f, 200f)
            path.lineTo(200f, 200f)
            path.lineTo(200f, 0f)

            Log.e(TAG, "forceClosed=false---->" + measure1.length)
            Log.e(TAG, "forceClosed=true----->" + measure2.length)

            paint.color = Color.BLUE
            canvas.drawPath(path, paint)
        }
    }
}