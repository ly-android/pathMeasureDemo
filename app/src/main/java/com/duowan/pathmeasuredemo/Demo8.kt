package com.duowan.pathmeasuredemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import kotlinx.android.synthetic.main.layout_demo8.*

/**
 * Created by liyong on 2019-11-20.
 */
class Demo8 : AppCompatActivity() {
  companion object {
    const val TAG = "Demo8"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.layout_demo8)
    tv.setOnTouchListener { v, event ->
      when (event.actionMasked) {
        MotionEvent.ACTION_DOWN -> {
          Log.d(TAG, "textview action down")
        }
        MotionEvent.ACTION_POINTER_DOWN -> {
          Log.d(TAG, "textview action point down")
        }
        MotionEvent.ACTION_MOVE -> {
          Log.d(TAG, "textview action move")
        }
        MotionEvent.ACTION_UP -> {
          Log.d(TAG, "textview action up")
        }
      }
      true
    }
  }
}
