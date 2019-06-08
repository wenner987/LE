package com.wenner.github.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.wenner.github.fragment.*
import java.util.ArrayList

class FragmentAdapter (fm: FragmentManager) :
    FragmentPagerAdapter(fm) {
    private var fragments: ArrayList<Fragment>? = null
    init{
        fragments = ArrayList()
        fragments?.add(ssFragment())
        fragments?.add(kFragment())
        fragments?.add(wdFragment())
        fragments?.add(vFragment())
        fragments?.add(glFragment())
    }
    override fun getItem(position: Int): Fragment {
        return fragments!![position]
    }
    override fun getCount(): Int {
        return fragments!!.size
    }
}
