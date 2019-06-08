package com.wenner.github.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioGroup
import com.example.myapplication.R
import com.wenner.github.adapter.FragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {
    var choose = 0
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        var current = 0
        when (checkedId) {
            R.id.radioButton1 -> current = 0
            R.id.radioButton2 -> current = 1
            R.id.radioButton3 -> current = 2
            R.id.radioButton4 -> current = 3
            R.id.radioButton5 -> current = 4
        }
        if (choose != current) {
            choose = current
            main_ViewPager.currentItem = current
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val index = menu?.add(Menu.NONE, Menu.FIRST, Menu.FIRST, "单词本")
        index?.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER)
        val pushsetting = menu?.addSubMenu(Menu.NONE, Menu.FIRST + 1, Menu.FIRST + 1, "考级专用")
        menu?.addSubMenu(Menu.NONE, Menu.FIRST + 2, Menu.FIRST + 2, "专项训练")
        menu?.addSubMenu(Menu.NONE, Menu.FIRST + 3, Menu.FIRST + 3, "设置")
        pushsetting?.add(Menu.NONE, Menu.FIRST + 4, Menu.FIRST + 4, "四级高频")
        pushsetting?.add(Menu.NONE, Menu.FIRST + 5, Menu.FIRST + 5, "六级高频")
        pushsetting?.add(Menu.NONE, Menu.FIRST + 6, Menu.FIRST + 6, "注销")
        pushsetting?.add(Menu.NONE, Menu.FIRST + 7, Menu.FIRST + 7, "退出")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_ViewPager.currentItem = 0
        main_ViewPager.adapter = FragmentAdapter(this.supportFragmentManager)
        main_ViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(i: Int, v: Float, i1: Int) {
            }

            override fun onPageSelected(position: Int) {
                val current = main_ViewPager.currentItem
                when (current) {
                    0 -> rg.check(R.id.radioButton1)
                    1 -> rg.check(R.id.radioButton2)
                    2 -> rg.check(R.id.radioButton3)
                    3 -> rg.check(R.id.radioButton4)
                    4 -> rg.check(R.id.radioButton5)
                }
            }
        })

        rg.check(R.id.radioButton1)
        rg.setOnCheckedChangeListener(this)
    }
}
