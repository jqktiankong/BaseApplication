package com.jqk.baseapplication

import android.os.Bundle
import com.cvnavi.settings.expand.setOnThrottledClickListener
import com.jqk.baseapplication.databinding.ActivityDialogBinding
import com.jqk.common.base.BaseVBActivity
import com.jqk.baseapplication.dialog.MDialog

class DialogActivity : BaseVBActivity<ActivityDialogBinding>() {

    override fun initViewBinding() = ActivityDialogBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        binding.btShowDialog.setOnThrottledClickListener {
            MDialog.show(supportFragmentManager, {}, {}, {})
        }
    }

    override fun initData() {

    }

    override fun addLiveData() {

    }
}