package com.wellee.jetpack.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.wellee.jetpack.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var viewModel: MainViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java).apply {
            liveList.observe(this@MainFragment, Observer {
                adapter.submitList(it)
                adapter.notifyDataSetChanged()
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater)
        binding.vm = viewModel
            return binding.root
    }
}