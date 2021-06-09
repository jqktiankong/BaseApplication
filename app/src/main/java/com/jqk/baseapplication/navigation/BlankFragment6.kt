package com.jqk.baseapplication.navigation

import android.os.Bundle
import com.jqk.baseapplication.R
import com.jqk.baseapplication.databinding.FragmentBlank6Binding
import com.jqk.common.base.BaseVBFragment2
import com.jqk.common.expand.viewBinding

/**
 *  author : jiqingke
 *  date : 2021/06/09 10:12
 *  description :
 */
class BlankFragment6 : BaseVBFragment2(R.layout.fragment_blank6) {
    private val binding by viewBinding(FragmentBlank6Binding::bind)

    override fun initView(savedInstanceState: Bundle?) {
        binding.tv.text = "123456"
    }

    override fun initData() {
    }

    override fun addLiveData() {
    }
}