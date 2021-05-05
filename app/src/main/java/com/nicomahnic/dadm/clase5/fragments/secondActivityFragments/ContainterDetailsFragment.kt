package com.nicomahnic.dadm.clase5.fragments.secondActivityFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.nicomahnic.dadm.clase5.R
import com.nicomahnic.dadm.clase5.activities.SecondActivity
import com.nicomahnic.dadm.clase5.adapter.TabsViewPagerAdapter
import com.nicomahnic.dadm.clase5.databinding.FragmentContainterDetailsBinding
import com.nicomahnic.dadm.clase5.databinding.FragmentDeviceDetailsBinding
import kotlinx.android.synthetic.main.fragment_containter_details.*


class ContainterDetailsFragment : Fragment(R.layout.fragment_containter_details) {

    private lateinit var binding: FragmentContainterDetailsBinding
    private lateinit var v: View
    private val args: ContainterDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContainterDetailsBinding.bind(view)

        viewPager.adapter = TabsViewPagerAdapter(requireActivity())

        val serviceName = args.deviceName
        val description = args.description
        Log.d("NM","CONTAINER ${SecondActivity.User.name} $serviceName ,$description")

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Tab1"
                1 -> tab.text = "Tab2"
                else -> tab.text = "undefined"
            }
        }.attach()
    }

}