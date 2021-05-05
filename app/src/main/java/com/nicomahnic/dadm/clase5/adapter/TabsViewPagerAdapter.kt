package com.nicomahnic.dadm.clase5.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nicomahnic.dadm.clase5.fragments.secondActivityFragments.DeviceDetailsFragment
import com.nicomahnic.dadm.clase5.fragments.secondActivityFragments.DeviceOptionsFragment

class TabsViewPagerAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> DeviceDetailsFragment()
            1 -> DeviceOptionsFragment()
            else -> DeviceDetailsFragment()
        }
    }

    override fun getItemCount(): Int {
        return TAB_COUNT
    }

    companion object {
        private const val TAB_COUNT = 2
    }
}