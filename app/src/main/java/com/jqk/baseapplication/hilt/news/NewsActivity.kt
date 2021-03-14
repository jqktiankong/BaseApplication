package com.jqk.baseapplication.hilt.news

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.LogUtils
import com.jqk.common.base.BaseVBVMActivity
import com.jqk.baseapplication.databinding.ActivityNewsBinding
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
    }

    override fun initData() {
    LogUtils.d("我是工具类")
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