package com.nicomahnic.dadm.clase5.fragments.firstActivityFragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import com.nicomahnic.dadm.clase5.R
import com.nicomahnic.dadm.clase5.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var binding: FragmentSplashBinding
    private val SPLASH_TIME_OUT:Long = 2000 // 3 sec

    lateinit var v: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)

        v = view
        Run.after(SPLASH_TIME_OUT) {
            val action = SplashFragmentDirections.actionSplashFragmentToLogin()
            v.findNavController().navigate(action)
        }

    }


    companion object Run {
        fun after(delay: Long, process: () -> Unit) {
            Handler(Looper.getMainLooper()).postDelayed({
                process()
            }, delay)
        }
    }


}