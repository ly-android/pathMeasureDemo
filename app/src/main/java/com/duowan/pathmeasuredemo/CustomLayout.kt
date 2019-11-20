package com.duowan.pathmeasuredemo

import android.content.Context
import android.graphics.Rect
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent

/**
 * Created by liyong on 2019-11-20.
 */
class CustomLayout(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

  companion object {
    const val TAG = "CustomLayout"
  }

  constructor(context: Context) : this(context, null)


  override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
    when (ev.actionMasked) {
      MotionEvent.ACTION_DOWN -> {
        Log.d(TAG, "parent action down")
      }
      MotionEvent.ACTION_MOVE -> {
        Log.d(TAG, "parent action move")
      }
      MotionEvent.ACTION_UP -> {
        Log.d(TAG, "parent action up")
      }
    }
    return super.dispatchTouchEvent(ev)
  }

  override fun onTouchEvent(event: MotionEvent): Boolean {
    return true
  }

  var hasSecond = false
//  override fun onTouchEvent(event: MotionEvent): Boolean {
//    val index = event.actionIndex
//    when (event.actionMasked) {
//      MotionEvent.ACTION_DOWN -> {
//        if (!touchChildView(0, event)) {
//          //处理父类的触摸
//          Log.d(TAG, "处理父类的down")
//        }
//        Log.d(TAG, "parent action down")
//      }
//      MotionEvent.ACTION_POINTER_DOWN -> {
//        hasSecond = true
//        if (event.getPointerId(index) == 1) { //第二个手指
//          touchChildView(1, event)
//        }
//        Log.d(TAG, "parent action point down")
//      }
//      MotionEvent.ACTION_MOVE -> {
//        Log.d(TAG, "parent action move " + event.getPointerId(event.actionIndex))
//        //不论是第一个手指，第二个手指都会执行move,这里处理父类的move
//        //如果move发生在子view，不处理
//        if (hasSecond) {
//          if (touchChildView(
//              event.findPointerIndex(0), event
//            ) || touchChildView(event.findPointerIndex(0), event)
//          ) {
//            Log.d(TAG, "child view move")
//          } else {
//            //这里处理父类的move
//            Log.d(TAG, "处理父类的move")
//          }
//        } else {
//          //这里处理父类的move
//          if (!touchChildView(0, event)) {
//            Log.d(TAG, "处理父类的move")
//          }
//        }
//      }
//      MotionEvent.ACTION_UP -> {
//        Log.d(TAG, "parent action up")
//      }
//      MotionEvent.ACTION_POINTER_UP -> {
//        hasSecond = false
//        Log.d(TAG, "parent action point up")
//      }
//    }
//    return true
//  }
//
//  fun touchChildView(pointIndex: Int, event: MotionEvent): Boolean {
//    for (i in 0..childCount) {
//      getChildAt(i)?.apply {
//        val rec = Rect(left, top, right, bottom)
//        if (rec.contains(event.getX(pointIndex).toInt(), event.getY(pointIndex).toInt())) {
//          Log.d(TAG, "find child")
//          if (event.actionMasked != MotionEvent.ACTION_MOVE) {
//            //处理点击,和弹起
//            Log.d(TAG, "需要处理子view")
//          }
//          return true
//        }
//      }
//
//    }
//    return false
//  }
}
