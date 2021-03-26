package com.jqk.baseapplication.hilt.news

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.jqk.common.base.BaseViewModel
import com.jqk.common.db.User
import com.jqk.common.network.retrofit.bean.HttpResult
import com.jqk.common.network.retrofit.bean.News
import kotlinx.coroutines.launch

class NewsViewModel @ViewModelInject constructor(private val newsModel: NewsModel) :
    BaseViewModel() {
    val newsLiveData: MutableLiveData<HttpResult<News>> = MutableLiveData()
    val insertLiveData: MutableLiveData<Long> = MutableLiveData()

    fun getNews() {
        viewModelScope.launch {
            newsLiveData.value = newsModel.getNews("top", "93ff5c6fd6dc134fc69f6ffe3bc568a6")
        }

    }

    fun insert(user: User) {
        viewModelScope.launch {
            insertLiveData.value = newsModel.insert(user)
        }
    }
}