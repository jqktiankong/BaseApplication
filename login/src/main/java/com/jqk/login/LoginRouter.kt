package com.jqk.login

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.jqk.common.arouter.RouterPath
import com.jqk.common.arouter.ILoginRouter

@Route(path = RouterPath.login)
class LoginRouter : ILoginRouter {
    override fun init(context: Context?) {
    }

    override fun showLoginUI(context: Context, param: String) {
        LoginActivity.launch(context, param)
    }
}