package com.jqk.common.arouter

import com.alibaba.android.arouter.launcher.ARouter
import com.jqk.common.arouter.irouter.ILoginRouter
import com.jqk.common.arouter.irouter.ISettingRouter

object RouterProvider {
    val loginRouter by lazy {
        navigation(ILoginRouter::class.java)
    }

    val settingRouter by lazy {
        navigation(ISettingRouter::class.java)
    }

    private fun <T> navigation(service: Class<out T>?): T? {
        return ARouter.getInstance().navigation(service)
    }
}