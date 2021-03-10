package com.jqk.common.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.jqk.common.base.BaseActivity

abstract class BaseCommonActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initContentViewID())

        initView(savedInstanceState)
        initData()
    }

    @LayoutRes
    abstract fun initContentViewID(): Int

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initData()
}