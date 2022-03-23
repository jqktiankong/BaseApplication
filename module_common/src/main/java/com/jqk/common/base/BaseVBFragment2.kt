package com.jqk.common.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 *  author : jiqingke
 *  date : 2021/06/09 10:04
 *  description :
 */
abstract class BaseVBFragment2(@LayoutRes id: Int) : Fragment(id) {
    private var isFragmentViewInit = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isFragmentViewInit) {
            initView(savedInstanceState)
            addLiveData()
            initData()

            isFragmentViewInit = true
        }
    }

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initData()

    abstract fun addLiveData()
}