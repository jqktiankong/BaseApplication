package com.jqk.baseapplication.koin

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jqk.baseapplication.databinding.ActivityNewsBinding
import com.jqk.common.arouter.RouterProvider
import com.jqk.common.arouter.bean.ParamData
import com.jqk.common.base.BaseVBActivity
import com.jqk.common.db.User
import org.koin.androidx.viewmodel.ext.android.viewModel

@Route(path = NewsActivity.PATH)
class NewsActivity : BaseVBActivity<ActivityNewsBinding>() {
    companion object {
        const val PATH = "/app/news_koin"
    }

    private val viewModel: NewsViewModel by viewModel()

    override fun initViewBinding() = ActivityNewsBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        ARouter.getInstance().inject(this)

        mBinding.load.setOnClickListener {
            viewModel.getNews()
        }

        mBinding.insert.setOnClickListener {
            viewModel.insert(User(1, "", "", 22, ""))
        }

        mBinding.update.setOnClickListener {

        }

        mBinding.query.setOnClickListener {

        }

        mBinding.delete.setOnClickListener {

        }

        mBinding.login.setOnClickListener {
            RouterProvider.loginRouter?.showLoginUI("我是参数", ParamData("我是参数2"))
        }

        mBinding.mWidget.changeText()
    }

    override fun initData() {
        viewModel.getNews()
    }

    override fun addLiveData() {
        viewModel.apply {
            newsLiveData.observe(this@NewsActivity, Observer {
                Log.d("News", "$it")
            })

            insertLiveData.observe(this@NewsActivity, Observer {
                Log.d("Insert", "$it")
            })
        }
    }
}