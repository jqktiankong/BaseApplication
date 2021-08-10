package com.jqk.baseapplication.hilt

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.LogUtils
import com.jqk.baseapplication.koin.appModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@HiltAndroidApp
class HiltApplication : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        initMultiDex()
    }

    override fun onCreate() {
        super.onCreate()
        initARouter(this)
        initKoin()

        LogUtils.getConfig().setBorderSwitch(false)
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

    private fun initMultiDex() {
        MultiDex.install(this)
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@HiltApplication)
            modules(appModule)
        }
    }
}