package com.jqk.common.arouter.interceptor

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.jqk.common.util.utils.SPUtils

@Interceptor(name = LoginInterceptor.PATH, priority = 9)
class LoginInterceptor : IInterceptor {
    private var context: Context? = null

    companion object {
        const val PATH = "/common/interceptor"
    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        // 设置导航超时的时间
        postcard?.timeout = 1

        if (SPUtils.getInstance().getBoolean("login")) {
            // 不需要拦截
            callback?.onContinue(postcard)
        } else {
            // 需要拦截
        }

        callback?.onContinue(postcard)
    }

    override fun init(context: Context?) {
        this.context = context
    }
}