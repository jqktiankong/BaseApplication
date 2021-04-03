package com.jqk.baseapplication.hilt.news

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.jqk.common.base.BaseVBVMActivity
import com.jqk.baseapplication.databinding.ActivityNewsBinding
import com.jqk.common.arouter.RouterProvider
import com.jqk.common.db.User
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_news.*

@AndroidEntryPoint
class NewsActivity : BaseVBVMActivity<ActivityNewsBinding, NewsViewModel>() {
    override fun initViewBinding() = ActivityNewsBinding.inflate(layoutInflater)

    override fun initViewModel(): NewsViewModel {
        return defaultViewModelProviderFactory.create(NewsViewModel::class.java)
    }

    override fun initView(savedInstanceState: Bundle?) {
        mBinding.load.setOnClickListener {
            mViewModel.getNews()
        }

        insert.setOnClickListener {
            mViewModel.insert(User(1, "", "", 22, ""))
        }

        update.setOnClickListener {

        }

        query.setOnClickListener {

        }

        delete.setOnClickListener {

        }

        login.setOnClickListener {
            RouterProvider.loginRouter?.showLoginUI(this, "我是参数")
        }
    }

    override fun initData() {
    }

    override fun addLiveData() {
        mViewModel.apply {
            newsLiveData.observe(this@NewsActivity, Observer {
                Log.d("News", "$it")
            })

            insertLiveData.observe(this@NewsActivity, Observer {
                Log.d("Insert", "$it")
            })
        }
    }
}