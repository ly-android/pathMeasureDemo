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
class Demo6 : AppCompatActivity() {

    companion object {
        const val TAG = "Demo6"
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
        private var mBitmap: Bitmap? = null
        private var currentStep = 0f

        private val pos: FloatArray = FloatArray(2)  // 当前点的实际位置
        private val tan: FloatArray = FloatArray(2)  // 当前点的tangent值,用于计算图片所需旋转的角度
        private val mMatrix = Matrix()
        val anim = ValueAnimator.ofFloat(0f, 1f)

        init {
            paint.strokeWidth = 5f
            paint.style = Paint.Style.STROKE
            val options = BitmapFactory.Options()
            options.inSampleSize = 2       // 缩放图片
            mBitmap = BitmapFactory.decodeResource(context.resources, R.mipmap.arrow, options)

            anim.repeatMode = ValueAnimator.RESTART
            anim.repeatCount = ValueAnimator.INFINITE
            anim.duration = 2000
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
            canvas.drawLine(width / 2f, 0f, width / 2f, height * 1f, paint)
            canvas.drawLine(0f, height / 2f, width * 1f, height / 2f, paint)
            canvas.translate(width / 2f, height / 2f)

            paint.color = Color.BLACK
            path.addCircle(0f, 0f, 200f, Path.Direction.CW)
            canvas.drawPath(path, paint)
            pathMeasure.setPath(path, false) //关联path

            // 获取当前位置的矩阵
            pathMeasure.getMatrix(
                pathMeasure.length * currentStep, mMatrix,
                PathMeasure.TANGENT_MATRIX_FLAG or PathMeasure.POSITION_MATRIX_FLAG
            )
            mMatrix.preTranslate(
                -mBitmap!!.width / 2f,
                -mBitmap!!.height / 2f
            )   // 将图片绘制中心调整到与当前点重合

            canvas.drawBitmap(mBitmap!!, mMatrix, paint)
        }

        override fun onDetachedFromWindow() {
            super.onDetachedFromWindow()
            anim.cancel()
        }
    }
}