package com.jqk.login

import android.os.Bundle
import com.jqk.common.base.BaseVBActivity
import com.jqk.login.databinding.LoginActivityLoginBinding

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