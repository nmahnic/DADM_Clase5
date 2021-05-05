package com.nicomahnic.dadm.clase5.fragments.secondActivityFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.nicomahnic.dadm.clase5.R
import com.nicomahnic.dadm.clase5.databinding.FragmentDeviceDetailsBinding

class DeviceDetailsFragment : Fragment(R.layout.fragment_device_details) {

    private lateinit var binding: FragmentDeviceDetailsBinding
    private lateinit var v: View

    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDeviceDetailsBinding.bind(view)

        //Los datos estan llegando al container no entiendo como pasrlos a este fragmetne
        binding.txtServiceTitle.text = "serviceName"
        binding.txtDescription.text = "description"

//        Log.d("NM","HOLA ${SecondActivity.User.name} $serviceName ,$description")
//        Log.d("NM","HOLA ${SecondActivity.User.name}")
    }

}