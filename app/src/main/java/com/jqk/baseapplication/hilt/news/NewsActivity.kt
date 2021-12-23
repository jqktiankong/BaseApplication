package com.jqk.baseapplication.hilt.news

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jqk.baseapplication.databinding.ActivityNewsBinding
import com.jqk.common.arouter.RouterProvider
import com.jqk.common.arouter.bean.ParamData
import com.jqk.common.base.BaseVBActivity
import com.jqk.common.db.User
import com.jqk.common.network.retrofit.bean.News
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Route(path = NewsActivity.PATH)
class NewsActivity : BaseVBActivity<ActivityNewsBinding>() {
    companion object {
        const val PATH = "/app/news"
    }

    private val viewModel: NewsViewModel by viewModels()

    private val data = mutableListOf<News.Result.Data>()

    private val adapter by lazy {
        NewsAdapter(this@NewsActivity, data)
    }

    override fun initViewBinding() = ActivityNewsBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        ARouter.getInstance().inject(this)

        initRecyclerView()

        binding.apply {
            load.setOnClickListener {
                viewModel.getNews()
            }

            insert.setOnClickListener {
                viewModel.insert(User(1, "", "", 22, ""))
            }

            update.setOnClickListener {

            }

            query.setOnClickListener {

            }

            delete.setOnClickListener {

            }

            login.setOnClickListener {
                RouterProvider.loginRouter?.showLoginUI("我是参数", ParamData("我是参数2"))
            }

            widget.changeText()
        }
    }

    override fun initData() {
        viewModel.getNews()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun addLiveData() {
        viewModel.apply {
            newsLiveData.observe(this@NewsActivity, Observer {
                it.data?.result?.data?.let { news ->
                    data.clear()
                    data.addAll(news)
                    adapter.notifyDataSetChanged()
                }
            })

            insertLiveData.observe(this@NewsActivity, Observer {
                Log.d("Insert", "$it")
            })
        }
    }

    private fun initRecyclerView() {
        binding.rvNews.layoutManager = LinearLayoutManager(this@NewsActivity)
        binding.rvNews.adapter = adapter
    }
}