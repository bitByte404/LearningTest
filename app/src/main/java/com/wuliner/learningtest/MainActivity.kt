package com.wuliner.learningtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.wuliner.learningtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //viewModel = MainViewModel() 不能这样创建 没有建立生命周期关系
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.result.text = viewModel.number.toString()


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
            binding.result.text = viewModel.number.toString()
        }

        binding.nextButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("testKey", viewModel.number)
            startActivity(intent)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        //outState.putInt("numberKey", number)
        super.onSaveInstanceState(outState)
    }
}