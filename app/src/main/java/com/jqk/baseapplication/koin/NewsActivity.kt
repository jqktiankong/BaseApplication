package com.jqk.baseapplication.koin

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.LogUtils
import com.jqk.baseapplication.databinding.ActivityNewsBinding
import com.jqk.common.arouter.RouterProvider
import com.jqk.common.arouter.bean.ParamData
import com.jqk.common.base.BaseVBActivity
import com.jqk.common.db.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
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

        this.lifecycleScope.launch {
            viewModel.newsLiveData3.collect {
                LogUtils.d("News3 = $it")
            }
        }
    }

    override fun addLiveData() {
        viewModel.apply {
            newsLiveData.observe(this@NewsActivity, Observer {
                LogUtils.d("News = $it")
            })

            insertLiveData.observe(this@NewsActivity, Observer {
                LogUtils.d("Insert = $it")
            })

            newsLiveData2.observe(this@NewsActivity, {
                LogUtils.d("News2 = $it")
            })
        }
    }
}