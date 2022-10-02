package com.leandroid.system.mygymroutines.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.leandroid.system.mygymroutines.databinding.ActivityHomeBinding
import com.leandroid.system.mygymroutines.ui.days.ViewPagerAdapter


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    var tabTitle = arrayOf("LUN","MAR","MIE","JUE","VIE","SAB")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var pager = binding.viewPager2
        var tl = binding.tabLayout
        pager.adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)

        TabLayoutMediator(tl, pager){
            tab, position ->
                tab.text = tabTitle[position]
        }.attach()
    }
}