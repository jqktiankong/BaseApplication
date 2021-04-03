package com.jqk.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.blankj.utilcode.util.LogUtils
import com.jqk.common.base.BaseVBActivity
import com.jqk.login.databinding.LoginActivityLoginBinding

class LoginActivity : BaseVBActivity<LoginActivityLoginBinding>() {
    override fun initViewBinding(): LoginActivityLoginBinding {
        return LoginActivityLoginBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun initData() {
        val param = intent.getStringExtra(EXTRA_PARAM)
        LogUtils.d("param  = $param")
    }

    override fun addLiveData() {

    }

    companion object {
        private const val EXTRA_PARAM = "param"

        fun launch(context: Context, param: String) {
            val intent = Intent(context, LoginActivity::class.java)
            intent.putExtra(EXTRA_PARAM, param)
            context.startActivity(intent)
        }
    }
}