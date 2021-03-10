package com.jqk.baseapplication

import android.os.Bundle
import com.jqk.common.base.BaseVBActivity
import com.jqk.baseapplication.databinding.ActivityMainBinding

class MainActivity2 : BaseVBActivity<ActivityMainBinding>() {

    override fun initViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        mBinding.text.text = "fdsadfsafd"
    }

    override fun initData() {

    }

    override fun addLiveData() {
        TODO("Not yet implemented")
    }
}