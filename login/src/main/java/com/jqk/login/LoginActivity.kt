package com.jqk.login

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.jqk.common.arouter.ARouterPath
import com.jqk.common.base.BaseVBActivity
import com.jqk.login.databinding.LoginActivityLoginBinding

@Route(path = ARouterPath.activity_login)
class LoginActivity : BaseVBActivity<LoginActivityLoginBinding>() {
    override fun initViewBinding(): LoginActivityLoginBinding {
        return LoginActivityLoginBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun initData() {

    }

    override fun addLiveData() {

    }
}