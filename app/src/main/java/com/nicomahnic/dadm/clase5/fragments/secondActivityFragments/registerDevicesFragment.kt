package com.nicomahnic.dadm.clase5.fragments.secondActivityFragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import com.nicomahnic.dadm.clase5.database.appDatabase
import com.nicomahnic.dadm.clase5.domain.DeviceDao
import com.nicomahnic.dadm.clase5.entities.DeviceEntity
import com.nicomahnic.dadm.clase5.R
import com.nicomahnic.dadm.clase5.databinding.FragmentRegisterDevicesBinding

class registerDevicesFragment : Fragment(R.layout.fragment_register_devices) {

    private lateinit var binding: FragmentRegisterDevicesBinding
    private var db: appDatabase? = null
    private var deviceDao: DeviceDao? = null

    var btnDevice : Boolean = false
    var btnDescription : Boolean = false

    lateinit var v : View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterDevicesBinding.bind(view)

        v = view

        binding.edtDeviceName.apply { addTextChangedListener(deviceNameWatcher) }

        binding.edtDescription.apply { addTextChangedListener(descriptionWatcher) }

        binding.btnRegister.isEnabled = false
    }

    private val deviceNameWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            println("afterTextChanged -> $s")

            btnDevice = s.toString().isNotEmpty()
            binding.btnRegister.isEnabled = btnDescription && btnDevice

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    private val descriptionWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            println("afterTextChanged -> $s")

            btnDescription = s.toString().isNotEmpty()
            binding.btnRegister.isEnabled = btnDescription && btnDevice

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    override fun onStart() {
        super.onStart()
        db = appDatabase.getAppDataBase(v.context)
        deviceDao = db?.deviceDao()

        binding.btnRegister.setOnClickListener {
            deviceDao?.insertDevice(DeviceEntity(
                id = 0,
                name = binding.edtDeviceName.text.toString(),
                description = binding.edtDescription.text.toString())
            )
            v.findNavController().popBackStack()
        }
    }

}