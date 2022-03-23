package com.jqk.jni

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jqk.common.arouter.irouter.IJNIRouter

@Route(path = JNIRouter.PATH)
class JNIRouter : IJNIRouter {
    companion object {
        const val PATH = "/jni/provider"
    }

    override fun init(context: Context?) {
    }

    override fun showJNIUI() {
        ARouter.getInstance().build(JNIMainActivity.PATH).navigation()
    }
}