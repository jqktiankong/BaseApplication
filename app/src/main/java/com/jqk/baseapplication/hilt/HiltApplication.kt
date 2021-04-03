package com.jqk.baseapplication.hilt

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.AppUtils
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (AppUtils.isAppDebug()) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化
    }
}