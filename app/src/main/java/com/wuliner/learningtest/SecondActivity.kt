package com.wuliner.learningtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.wuliner.learningtest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = SharedModelProvider.get(this)
        viewModel.number.observe(this) {
            binding.result.text = it.toString()
        }

        binding.result.text = viewModel.getNumber().toString()

        binding.addButton.setOnClickListener {
            viewModel.addOne()
            binding.result.text = it.toString()

        }
    }

}