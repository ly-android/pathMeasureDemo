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
class Demo4 : AppCompatActivity() {

    companion object {
        const val TAG = "Demo4"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(View1(this))
        title = TAG
    }

    class View1(context: Context) : View(context) {

        private val path = Path()
        private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        private val pathMeasure = PathMeasure()

        init {
            paint.strokeWidth = 2f
            paint.style = Paint.Style.STROKE
        }

        override fun onDraw(canvas: Canvas) {
            paint.color = Color.GRAY
            canvas.drawLine(width / 2f, 0f, width / 2f, height * 1f, paint)
            canvas.drawLine(0f, height / 2f, width * 1f, height / 2f, paint)
            canvas.translate(width / 2f, height / 2f)

            paint.color = Color.BLACK
            paint.strokeWidth = 5f
            path.addRect(-100f, -100f, 100f, 100f, Path.Direction.CW)
            path.addRect(-200f, -200f, 200f, 200f, Path.Direction.CCW)
            canvas.drawPath(path, paint)

            pathMeasure.setPath(path, true) //关联path
            Log.d(TAG, "length1=${pathMeasure.length}")
            pathMeasure.nextContour()
            Log.d(TAG, "length2=${pathMeasure.length}")
        }
    }
}