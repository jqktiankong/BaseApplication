package com.jqk.baseapplication.hilt.news

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jqk.common.base.BaseVBVMActivity
import com.jqk.baseapplication.databinding.ActivityNewsBinding
import com.jqk.common.arouter.RouterProvider
import com.jqk.common.arouter.bean.ParamData
import com.jqk.common.db.User
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_news.*

@AndroidEntryPoint
@Route(path = NewsActivity.PATH)
class NewsActivity : BaseVBVMActivity<ActivityNewsBinding, NewsViewModel>() {
    companion object {
        const val PATH = "/app/news"
    }

    override fun initViewBinding() = ActivityNewsBinding.inflate(layoutInflater)

    override fun initViewModel(): NewsViewModel {
        return defaultViewModelProviderFactory.create(NewsViewModel::class.java)
    }

    override fun initView(savedInstanceState: Bundle?) {
        ARouter.getInstance().inject(this)

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
            RouterProvider.loginRouter?.showLoginUI("我是参数", ParamData("我是参数2"))
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