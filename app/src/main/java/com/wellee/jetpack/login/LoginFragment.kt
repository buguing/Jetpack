package com.wellee.jetpack.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.wellee.jetpack.R
import com.wellee.jetpack.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var viewModel: LoginViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java).apply {
            loginOk.observe(this@LoginFragment, Observer {
                if (it) {
                    Navigation.findNavController(activity!!, R.id.nav_host_main).navigateUp()
                }
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(inflater)
        binding.vm = viewModel
        return binding.root
    }

}