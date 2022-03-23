package com.jqk.baseapplication.app

import android.app.Application
import android.util.Log
import com.jqk.common.app.BaseAppInit
import com.jqk.common.koin.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 *  author : jiqingke
 *  date : 2022/03/23 16:34
 *  description :
 */
class BaseApplicationInit : BaseAppInit {
    override fun onInitCreate(application: Application) {
        initKoin(application)
    }

    private fun initKoin(application: Application) {
        startKoin {
            androidLogger(Level.INFO)
            androidContext(application)
            modules(appModule)
        }
    }
}