package com.jqk.setting

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jqk.common.arouter.irouter.ISettingRouter

@Route(path = SettingRouter.PATH)
class SettingRouter : ISettingRouter {
    companion object {
        const val PATH = "/setting/provider"
    }

    override fun init(context: Context?) {
    }

    override fun showSettingUI() {
        ARouter.getInstance().build(SettingActivity.PATH).navigation()
    }
}