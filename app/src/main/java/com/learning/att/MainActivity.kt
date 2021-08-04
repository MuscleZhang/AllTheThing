package com.learning.att

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var mRecyclerView: RecyclerView
    override fun onResume() {
        super.onResume()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.recycler_main)
        val adapter = MainAdapter(this)
        adapter.data = listOf("知识点测试", "ViewPager","当 try、catch 中有 return 时，finally 中的代码依然会继续执行")
        adapter.itemListener = arrayOf(
            object : ItemClickCallBack {
                override fun onItemClick() {
                    Log.d("zjj", "onResume sleep start");
                    Thread.sleep(20000)
                    Log.d("zjj", "onResume sleep end");
//                    Log.d("zjj", "cur item click first")
//                    var obj: Array<String?> = arrayOf(null,null)
//                    try {
//                        obj.get(2)!!.length
//                        Log.d("zjj", "try return go")
//                        return
//                    } catch (e: Exception) {
//                        Log.d("zjj", "catch go")
//                        return
//                    } finally {
//                        Log.d("zjj", "finally go")
//                    }
                }
            },
            object : ItemClickCallBack {
                override fun onItemClick() {
                    Log.d("zjj", "cur item click second")
                    startActivity(Intent(this@MainActivity, ViewPagerActivity::class.java))
                }
            })
        mRecyclerView.adapter = adapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)

    }
}