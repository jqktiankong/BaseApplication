package com.jqk.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseVBFragment<T : ViewBinding> : Fragment() {
    private var isFragmentViewInit = false
    var lastView: View? = null
    lateinit var mBinding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (lastView == null) {
            mBinding = initViewBinding(
                inflater,
                container
            )
            lastView = mBinding.root
        }

        return lastView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (!isFragmentViewInit) {
            super.onViewCreated(view, savedInstanceState)

            initView(savedInstanceState)
            addLiveData()
            initData()

            isFragmentViewInit = true
        }
    }

    abstract fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): T

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initData()

    abstract fun addLiveData()
}