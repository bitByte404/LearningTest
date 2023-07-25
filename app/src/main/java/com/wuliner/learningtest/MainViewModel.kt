package com.wuliner.learningtest

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    //不希望界面旋转或者跳转而丢失的数据
     var number: Int = 0

    fun addOne() {
        number++
    }
}