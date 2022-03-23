package com.jqk.common.base

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.jqk.common.app.BaseAppInit
import com.jqk.common.util.utils.AppUtils
import com.jqk.common.util.utils.Utils

/**
 *  author : jiqingke
 *  date : 2022/03/23 13:33
 *  description :
 */

val moduleInitArr = arrayOf(
    "com.jqk.baseapplication.app.BaseApplicationInit",
    "com.jqk.login.app.LoginInit",
    "com.jqk.setting.app.SettingInit",
)

open class BaseApplication : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        initMultiDex()
    }

    override fun onCreate() {
        super.onCreate()

        initModuleApp(this)
        initARouter(this)
        Utils.init(this)
    }

    private fun initMultiDex() {
        MultiDex.install(this)
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

    private fun initModuleApp(application: Application) {
        try {
            for (appName in moduleInitArr) {
                val clazz = Class.forName(appName)
                val module = clazz.getConstructor().newInstance() as BaseAppInit
                module.onInitCreate(application)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}