package com.wuliner.learningtest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

object SharedModelProvider {

    private var vm: MainViewModel? = null

    fun get(owner: ViewModelStoreOwner): MainViewModel {
        if (vm == null) {
            vm = ViewModelProvider(owner).get(MainViewModel::class.java)
        }
        return vm!!
    }
}