package com.jqk.common.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding

abstract class BaseVBActivity<T : ViewBinding> : BaseActivity() {
    lateinit var mBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = initViewBinding()
        setContentView(mBinding.root)
        addLiveData()
        initView(savedInstanceState)
        initData()
    }

    abstract fun initViewBinding(): T

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initData()

    abstract fun addLiveData()
}