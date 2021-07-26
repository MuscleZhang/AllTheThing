package com.learning.att.viewPager

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter

class BasePagerAdapter(var views: Array<View>,var titles: Array<String>): PagerAdapter() {
    override fun getCount(): Int {
        return views.size
    }

    // 用于ViewPager 中的子标签，PagerTitleStrip，PagerTabStrip
    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var curPager = views[position]
        container.addView(curPager)
        return curPager
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(views[position])
    }
}