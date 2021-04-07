package com.jqk.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.blankj.utilcode.util.LogUtils

abstract class BaseVBVMFragment<T : ViewBinding, VM : ViewModel> : Fragment() {
    private var isFragmentViewInit = false
    var lastView: View? = null
    lateinit var mBinding: T
    lateinit var mViewModel: VM

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
            mViewModel = initViewModel()
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

    abstract fun initViewModel(): VM

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initData()

    abstract fun addLiveData()
}