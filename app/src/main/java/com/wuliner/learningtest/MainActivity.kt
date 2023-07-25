package com.wuliner.learningtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wuliner.learningtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //取出保存的值，显示到界面
        if (savedInstanceState != null) {
           number = savedInstanceState.getInt("numberKey")
            binding.result.text = number.toString()
        }
        binding.addButton.setOnClickListener {
            number++
            binding.result.text = number.toString()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("numberKey", number)
        super.onSaveInstanceState(outState)
    }
}