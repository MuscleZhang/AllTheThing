package com.learning.att.viewPager

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.learning.att.R

class BaseViewPagerFragment : Fragment() {

    lateinit var views: Array<View>
    lateinit var viewPager: ViewPager
    lateinit var titles: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("zjj", "BaseViewPagerFragment onCreate")
        var infalter = LayoutInflater.from(context)

        views = arrayOf(
            infalter.inflate(R.layout.layout_first_pager, null),
            infalter.inflate(R.layout.layout_second_pager, null)
        )
        titles = arrayOf("First","Second")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("zjj", "onCreateView")
        val v = inflater.inflate(R.layout.layout_base_viewpager, container, false)
        viewPager = v.findViewById(R.id.viewpager_base)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewPager.adapter = BasePagerAdapter(views, titles)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("zjj", "BaseViewPagerFragment onDestroy")
    }
}


