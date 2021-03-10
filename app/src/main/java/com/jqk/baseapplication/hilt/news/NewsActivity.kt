package com.jqk.baseapplication.hilt.news

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.jqk.common.base.BaseVBVMActivity
import com.jqk.baseapplication.databinding.ActivityNewsBinding
import dagger.hilt.android.AndroidEntryPoint

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
    }

    override fun initData() {
        mViewModel.getNews()
    }

    override fun addLiveData() {
        mViewModel.newsLiveData.observe(this@NewsActivity, Observer {
            Log.d("News", "$it")
        })
    }
}