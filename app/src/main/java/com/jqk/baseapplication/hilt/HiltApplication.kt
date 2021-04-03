package com.jqk.baseapplication.hilt

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.AppUtils
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initARouter(this)
    }

    private fun initARouter(app: Application) {
        try {
            if (AppUtils.isAppDebug()) {
                ARouter.openLog()
                ARouter.openDebug()
            }
            ARouter.init(app)
        } catch (e: Exception) {
            ARouter.openDebug()
            ARouter.init(app)
        }
    }
}