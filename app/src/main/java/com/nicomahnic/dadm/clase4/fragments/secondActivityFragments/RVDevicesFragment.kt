package com.nicomahnic.dadm.clase5.fragments.secondActivityFragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicomahnic.dadm.clase5.R
import com.nicomahnic.dadm.clase5.activities.SecondActivity
import com.nicomahnic.dadm.clase5.adapter.DevicesAdapter
import com.nicomahnic.dadm.clase5.databinding.FragmentRvDevicesBinding
import com.nicomahnic.dadm.clase5.entities.Device

/**
 * A simple [Fragment] subclass.
 * Use the [RVDevicesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RVDevicesFragment : Fragment(R.layout.fragment_rv_devices) {

    private lateinit var binding: FragmentRvDevicesBinding
    private lateinit var v: View

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var devicesAdapter: DevicesAdapter

    var devices: List<Device> = listOf(
        Device("Dormitorio","Hay una cama"),
        Device("Cocina","Cocina2"),
        Device("Lavadero","Lavarropas")
    )
    


    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRvDevicesBinding.bind(view)

        v = view

        Log.d("NM", "Singleton ${SecondActivity.User.name}")
    }

    override fun onStart() {
        super.onStart()

        binding.rvDevices.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        binding.rvDevices.layoutManager = linearLayoutManager

        devicesAdapter = DevicesAdapter(devices) { pos ->
            Log.d("NM", pos.toString())
            val action =
                    RVDevicesFragmentDirections.actionRvDevicesFragmentToContainterDetailsFragment(
                            deviceName = devices[pos].name,
                            description = devices[pos].description
                    )

            v.findNavController().navigate(action)
        }
        binding.rvDevices.adapter = devicesAdapter
    }
}