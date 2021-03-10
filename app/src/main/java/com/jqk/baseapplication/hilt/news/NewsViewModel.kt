package com.jqk.baseapplication.hilt.news

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.jqk.common.network.retrofit.bean.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsViewModel @ViewModelInject constructor(private val newsModel: NewsModel) : ViewModel(),
    LifecycleObserver {
    val newsLiveData: MutableLiveData<News> = MutableLiveData()

    fun getNews() {
        GlobalScope.launch(Dispatchers.Main) {
            newsLiveData.value = newsModel.getNews("top", "93ff5c6fd6dc134fc69f6ffe3bc568a6")
        }
    }
}