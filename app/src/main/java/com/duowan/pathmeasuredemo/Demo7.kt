package com.duowan.pathmeasuredemo

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator


/**
 * Created by liyong on 2019-08-03.
 */
class Demo7 : AppCompatActivity() {

    companion object {
        const val TAG = "Demo7"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(View1(this))
        title = TAG
    }

    class View1(context: Context) : View(context) {

        private val path = Path()
        private val dst = Path()
        private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        private val pathMeasure = PathMeasure()
        private var mBitmap: Bitmap? = null
        private var currentStep = 0f

        val anim = ValueAnimator.ofFloat(0f, (Math.PI * 200).toFloat())

        init {
            paint.strokeWidth = 10f
            paint.style = Paint.Style.STROKE
            val options = BitmapFactory.Options()
            options.inSampleSize = 2       // 缩放图片
            mBitmap = BitmapFactory.decodeResource(context.resources, R.mipmap.arrow, options)

            anim.repeatMode = ValueAnimator.RESTART
            anim.repeatCount = ValueAnimator.INFINITE
            anim.duration = 1500
            anim.interpolator = AccelerateDecelerateInterpolator()
            anim.addUpdateListener { animation ->
                currentStep = animation.animatedValue as Float
                invalidate()
            }
            anim.startDelay = 500
            anim.start()
        }

        override fun onDraw(canvas: Canvas) {
            paint.color = Color.GRAY
            canvas.translate(width / 2f, height / 2f)
            paint.color = Color.parseColor("#008577")
            path.addCircle(0f, 0f, 100f, Path.Direction.CW)

            dst.reset()
            pathMeasure.setPath(path, true)
            if (currentStep <= 10) {
                pathMeasure.getSegment(currentStep, currentStep + 10, dst, true)
            } else {
                pathMeasure.getSegment(
                    currentStep, currentStep + 50, dst,
                    true
                )
            }
            canvas.drawPath(dst, paint)
        }

        override fun onDetachedFromWindow() {
            super.onDetachedFromWindow()
            anim.cancel()
        }
    }
}