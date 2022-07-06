package com.leandroid.system.mygymroutines.ui.view.days

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle)
{
    override fun getItemCount(): Int {
        return 6
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> MondayFragment()
            1 -> TuesdayFragment()
            2 -> WednesdayFragment()
            3 -> ThursdayFragment()
            4 -> FridayFragment()
            5 -> SaturdayFragment()
            else -> return MondayFragment()
        }
    }

}