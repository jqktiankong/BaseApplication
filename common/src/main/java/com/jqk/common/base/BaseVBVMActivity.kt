package com.jqk.common.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseVBVMActivity<T : ViewBinding, VM : ViewModel> : BaseActivity() {
    lateinit var mBinding: T
    lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = initViewBinding()
        setContentView(mBinding.root)
        mViewModel = initViewModel()
        addLiveData()
        initView(savedInstanceState)
        initData()
    }

    abstract fun initViewBinding(): T

    abstract fun initViewModel(): VM

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initData()

    abstract fun addLiveData()
}