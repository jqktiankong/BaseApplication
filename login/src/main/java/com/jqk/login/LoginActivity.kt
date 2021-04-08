package com.jqk.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.LogUtils
import com.jqk.common.arouter.RouterProvider
import com.jqk.common.arouter.bean.ParamData
import com.jqk.common.base.BaseVBActivity
import com.jqk.login.databinding.LoginActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.login_activity_login.*

@AndroidEntryPoint
@Route(path = LoginActivity.PATH)
class LoginActivity : BaseVBActivity<LoginActivityLoginBinding>() {
    @JvmField
    @Autowired(name = EXTRA_PARAM)
    var param: String? = null

    @JvmField
    @Autowired(name = EXTRA_PARAM2)
    var param2: ParamData? = null

    private val viewModel: NewsViewModel by viewModels()

    override fun initViewBinding(): LoginActivityLoginBinding {
        return LoginActivityLoginBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        ARouter.getInstance().inject(this)

        btLogin.setOnClickListener {
            RouterProvider.settingRouter?.showSettingUI()
        }
    }

    override fun initData() {
        LogUtils.d("param  = $param")
        LogUtils.d("param2  = $param2")

        viewModel.getNews()
    }

    override fun addLiveData() {

    }

    companion object {
        const val EXTRA_PARAM = "extra_param"
        const val EXTRA_PARAM2 = "extra_param2"
        const val PATH = "/login/main"

        fun launch(context: Context, param: String) {
            val intent = Intent(context, LoginActivity::class.java)
            intent.putExtra(EXTRA_PARAM, param)
            context.startActivity(intent)
        }
    }
}