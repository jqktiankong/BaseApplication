package com.jqk.login

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jqk.common.arouter.irouter.ILoginRouter
import com.jqk.common.arouter.bean.ParamData

@Route(path = LoginRouter.PATH)
class LoginRouter : ILoginRouter {
    companion object {
        const val PATH = "/login/provider"
    }

    override fun init(context: Context?) {
    }

    override fun showLoginUI(param: String, param2: ParamData) {
        ARouter
            .getInstance()
            .build(LoginActivity.PATH)
            .withString(LoginActivity.EXTRA_PARAM, param)
            .withParcelable(LoginActivity.EXTRA_PARAM2, param2)
            .navigation()
    }
}