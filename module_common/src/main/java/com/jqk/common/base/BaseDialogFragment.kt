package com.jqk.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.jqk.common.R

/**
 *  author : jiqingke
 *  date : 2021/06/05 10:30
 *  description :
 */
abstract class BaseDialogFragment<VB : ViewBinding> : DialogFragment() {
    lateinit var binding: VB

    var positiveClick: (() -> Unit)? = null
    var negativeClick: (() -> Unit)? = null
    var middleClick: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.TransparentDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = initViewBinding(
            inflater,
            container
        )

        initData()
        initView(savedInstanceState)

        return binding.root
    }

    abstract fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): VB

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initData()

    fun setOnDialogClickListener(positiveClick: (() -> Unit), negativeClick: (() -> Unit), middleClick: (() -> Unit)) {
        this.positiveClick = positiveClick
        this.negativeClick = negativeClick
        this.middleClick = middleClick
    }
}