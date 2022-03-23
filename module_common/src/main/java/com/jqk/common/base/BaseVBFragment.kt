package com.jqk.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.NullPointerException

abstract class BaseVBFragment<VB : ViewBinding> : Fragment() {
    private var isFragmentViewInit = false
    var lastView: View? = null

    private var _binding: VB? = null
    val binding: VB
        get() {
            if (_binding == null) {
                kotlin.runCatching {
                    throw NullPointerException()
                }
            }

            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (lastView == null) {
            _binding = initViewBinding(
                inflater,
                container
            )
            lastView = binding.root
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

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    abstract fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): VB

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initData()

    abstract fun addLiveData()
}