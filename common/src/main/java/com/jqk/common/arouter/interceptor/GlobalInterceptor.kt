package com.jqk.common.arouter.interceptor

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.SPUtils
import com.jqk.common.arouter.RouterProvider

@Interceptor(name = "/service/interceptor", priority = 9)
class GlobalInterceptor : IInterceptor {
    private var context: Context? = null

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {

        if (SPUtils.getInstance().getBoolean("login")) {
            LogUtils.d("不需要拦截")
            callback?.onContinue(postcard)
        } else {
            LogUtils.d("需要拦截")
            context?.let { RouterProvider.loginRouter?.showLoginUI(it, "woshicanshu") }
        }
    }

    override fun init(context: Context?) {
        LogUtils.d("拦截器初始化")
        this.context = context
    }
}