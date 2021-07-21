package com.learning.att

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var mRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.recycler_main)
        val adapter = MainAdapter(this)
        adapter.data = listOf("test", "测试")
        adapter.itemListener = arrayOf(
            object : ItemClickCallBack {
                override fun onItemClick() {
                    Log.d("zjj","cur item click first")
                    startActivity(Intent(this@MainActivity, ViewPagerActivity::class.java))
                }
            },
            object : ItemClickCallBack {
                override fun onItemClick() {
                    Log.d("zjj","cur item click second")
                }
            })
        mRecyclerView.adapter = adapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)

    }
}