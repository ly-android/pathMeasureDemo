package com.duowan.pathmeasuredemo

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View


/**
 * Created by liyong on 2019-08-03.
 */
class Demo3 : AppCompatActivity() {

    companion object {
        const val TAG = "Demo3"
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

        init {
            paint.strokeWidth = 5f
            paint.style = Paint.Style.STROKE
        }

        override fun onDraw(canvas: Canvas) {
            paint.color = Color.RED
            canvas.drawLine(width / 2f, 0f, width / 2f, height * 1f, paint)
            canvas.drawLine(0f, height / 2f, width * 1f, height / 2f, paint)
            canvas.translate(width / 2f, height / 2f)

            paint.color = Color.BLUE
            path.addRect(-200f, -200f, 200f, 200f, Path.Direction.CW) //顺时针，起始点在左上角

            pathMeasure.setPath(path, false) //关联path
            //截取200--600的片段,并使用 moveTo 保持截取得到的 Path 第一个点的位置不变
            dst.lineTo(-300f, -300f)
            pathMeasure.getSegment(1000f, 1400f, dst, false)
            paint.color = Color.GREEN
            canvas.drawPath(dst, paint)
        }
    }
}