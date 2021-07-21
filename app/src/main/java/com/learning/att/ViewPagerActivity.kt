package com.learning.att

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.learning.att.viewPager.BaseViewPagerFragment

class ViewPagerActivity :AppCompatActivity() {
    lateinit var baseViewPager: Button
    lateinit var content : FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("zjj","onCreate")
        setContentView(R.layout.layout_viewpager)
        baseViewPager = findViewById(R.id.viewpager_base)
        content = findViewById(R.id.fragment_content)
        baseViewPager.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                content.visibility = View.VISIBLE
                var transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_content, BaseViewPagerFragment())
                transaction.addToBackStack(null)
                transaction.commit()
            }
        })
    }
}