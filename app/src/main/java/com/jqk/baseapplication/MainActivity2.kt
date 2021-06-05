package com.jqk.baseapplication

import android.os.Bundle
import com.blankj.utilcode.util.LogUtils
import com.cvnavi.settings.expand.setOnThrottledClickListener
import com.jqk.common.base.BaseVBActivity
import com.jqk.baseapplication.databinding.ActivityMainBinding
import com.jqk.baseapplication.dialog.MDialog

class MainActivity2 : BaseVBActivity<ActivityMainBinding>() {

    override fun initViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        binding.btShowDialog.setOnThrottledClickListener {
            MDialog.show(supportFragmentManager)
            MDialog.instance.setOnDialogClickListener({
                LogUtils.d("1")
            }, {
                LogUtils.d("2")
            }, {
                LogUtils.d("3")
            })
        }
    }

    override fun initData() {

    }

    override fun addLiveData() {

    }
}