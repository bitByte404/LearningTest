package com.wuliner.learningtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wuliner.learningtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = SharedModelProvider.get(this)

        //观察数据变化
        viewModel.number.observe(this) {
            binding.result.text = it.toString()
        }


        /**
        //取出保存的值，显示到界面
        if (savedInstanceState != null) {
        number = savedInstanceState.getInt("numberKey")
        binding.result.text = number.toString()
        }
        binding.addButton.setOnClickListener {
        number++
        binding.result.text = number.toString()
        }
         */

        binding.addButton.setOnClickListener {
            viewModel.addOne()
            binding.result.text = viewModel.getNumber().toString()
        }

        binding.nextButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        //outState.putInt("numberKey", number)
        super.onSaveInstanceState(outState)
    }
}