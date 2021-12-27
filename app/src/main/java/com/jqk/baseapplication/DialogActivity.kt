package com.jqk.baseapplication

import android.os.Bundle
import com.cvnavi.settings.expand.setOnThrottledClickListener
import com.jqk.baseapplication.databinding.ActivityDialogBinding
import com.jqk.common.base.BaseVBActivity
import com.jqk.baseapplication.dialog.MDialog

class DialogActivity : BaseVBActivity<ActivityDialogBinding>() {

    // 测试内存泄漏
    companion object {
        var sActivity: DialogActivity? = null
    }

    override fun initViewBinding() = ActivityDialogBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        binding.btShowDialog.setOnThrottledClickListener {
            MDialog.show(supportFragmentManager, {}, {}, {})
        }

        binding.btFinish.setOnClickListener {
            finish()
        }

        sActivity = this
    }

    override fun initData() {

    }

    override fun addLiveData() {

    }
}