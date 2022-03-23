package com.jqk.common.app

import android.app.Application

/**
 *  author : jiqingke
 *  date : 2022/03/23 16:31
 *  description :
 */
interface BaseAppInit {
    fun onInitCreate(application: Application)
}