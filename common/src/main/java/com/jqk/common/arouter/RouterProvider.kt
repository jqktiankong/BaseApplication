package com.jqk.common.arouter

import com.alibaba.android.arouter.launcher.ARouter

/**
 * 可以自定义拦截器（登录拦截器），降级服务（指向统一错误页面）
 */
object RouterProvider {
    val loginRouter by lazy {
        navigation(ILoginRouter::class.java)
    }

    private fun <T> navigation(service: Class<out T>?): T? {
        return ARouter.getInstance().navigation(service)
    }
}