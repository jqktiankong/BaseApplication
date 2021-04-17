package com.jqk.baseapplication.hilt.news

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jqk.baseapplication.databinding.ActivityNewsBinding
import com.jqk.common.arouter.RouterProvider
import com.jqk.common.arouter.bean.ParamData
import com.jqk.common.base.BaseVBActivity
import com.jqk.common.db.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Route(path = NewsActivity.PATH)
class NewsActivity : BaseVBActivity<ActivityNewsBinding>() {
    companion object {
        const val PATH = "/app/news"
    }

    private val viewModel: NewsViewModel by viewModels()

    override fun initViewBinding() = ActivityNewsBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        ARouter.getInstance().inject(this)

        binding.load.setOnClickListener {
            viewModel.getNews()
        }

        binding.insert.setOnClickListener {
            viewModel.insert(User(1, "", "", 22, ""))
        }

        binding.update.setOnClickListener {

        }

        binding.query.setOnClickListener {

        }

        binding.delete.setOnClickListener {

        }

        binding.login.setOnClickListener {
            RouterProvider.loginRouter?.showLoginUI("我是参数", ParamData("我是参数2"))
        }

        binding.widget.changeText()
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