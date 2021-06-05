package com.jqk.common.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding

abstract class BaseVBActivity<VB : ViewBinding> : BaseActivity() {
    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initViewBinding()
        setContentView(binding.root)
        addLiveData()
        initView(savedInstanceState)
        initData()
    }

    abstract fun initViewBinding(): VB

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initData()

    abstract fun addLiveData()
}