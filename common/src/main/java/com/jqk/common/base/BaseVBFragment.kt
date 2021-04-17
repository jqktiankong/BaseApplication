package com.jqk.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.blankj.utilcode.util.LogUtils

abstract class BaseVBFragment<T : ViewBinding> : Fragment() {
    private var isFragmentViewInit = false
    var lastView: View? = null
    lateinit var binding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (lastView == null) {
            LogUtils.d("创建视图")
            binding = initViewBinding(
                inflater,
                container
            )
            lastView = binding.root
        } else {
            LogUtils.d("视图存在，不用重复创建")
        }

        return lastView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isFragmentViewInit) {
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