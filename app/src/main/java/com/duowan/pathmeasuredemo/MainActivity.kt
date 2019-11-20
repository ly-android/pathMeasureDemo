package com.duowan.pathmeasuredemo

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        tv1.setOnClickListener {
            startActivity(Intent(this, Demo1::class.java))
        }
        tv2.setOnClickListener {
            startActivity(Intent(this, Demo2::class.java))
        }
        tv3.setOnClickListener {
            startActivity(Intent(this, Demo3::class.java))
        }
        tv4.setOnClickListener {
            startActivity(Intent(this, Demo4::class.java))
        }
        tv5.setOnClickListener {
            startActivity(Intent(this, Demo5::class.java))
        }
        tv6.setOnClickListener {
            startActivity(Intent(this, Demo6::class.java))
        }
        tv7.setOnClickListener {
            startActivity(Intent(this, Demo7::class.java))
        }
        tv8.setOnClickListener {
            startActivity(Intent(this, Demo8::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
