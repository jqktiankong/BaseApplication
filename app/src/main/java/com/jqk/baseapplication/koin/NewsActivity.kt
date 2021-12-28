package com.jqk.baseapplication.koin

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jqk.baseapplication.databinding.ActivityNewsBinding
import com.jqk.common.arouter.RouterProvider
import com.jqk.common.arouter.bean.ParamData
import com.jqk.common.base.BaseVBActivity
import com.jqk.common.db.User
import com.jqk.common.network.retrofit.bean.News
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

@Route(path = NewsActivity.PATH)
class NewsActivity : BaseVBActivity<ActivityNewsBinding>() {
    companion object {
        const val PATH = "/app/news_koin"
    }

    private val viewModel: NewsViewModel by viewModel()

    private val data = mutableListOf<News.Result.Data>()

    private val adapter by lazy {
        NewsAdapter(this@NewsActivity, data)
    }

    override fun initViewBinding() = ActivityNewsBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        ARouter.getInstance().inject(this)

        initRecyclerView()

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
//        viewModel.getNews()
        viewModel.getNewsByFlow()
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
                Log.d("news", "Insert = $it")
            })

            lifecycleScope.launch {
                this@NewsActivity.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    newStateFlow.collect {
                        Log.d("news", "News4 = $it")

                        it.data?.result?.data?.let { news ->
                            data.clear()
                            data.addAll(news)
                            adapter.notifyDataSetChanged()
                        }
                    }
                }
            }
        }
    }

    private fun initRecyclerView() {
        binding.rvNews.layoutManager = LinearLayoutManager(this@NewsActivity)
        binding.rvNews.adapter = adapter
    }
}