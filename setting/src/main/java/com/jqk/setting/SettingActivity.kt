package com.jqk.setting

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jqk.common.base.BaseVBActivity
import com.jqk.setting.databinding.SettingActivitySettingBinding

@Route(path = SettingActivity.PATH)
class SettingActivity : BaseVBActivity<SettingActivitySettingBinding>() {
    companion object {
        const val PATH = "/setting/main"
    }

    override fun initViewBinding(): SettingActivitySettingBinding {
        return SettingActivitySettingBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        ARouter.getInstance().inject(this)
    }

    override fun initData() {

    }

    override fun addLiveData() {

    }
}