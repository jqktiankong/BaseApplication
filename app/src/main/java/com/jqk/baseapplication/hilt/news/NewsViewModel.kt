package com.jqk.baseapplication.hilt.news

import android.util.Log
import androidx.lifecycle.*
import com.jqk.common.base.BaseViewModel
import com.jqk.common.base.onFailure
import com.jqk.common.base.onSuccess
import com.jqk.common.db.User
import com.jqk.common.network.retrofit.bean.HttpResult
import com.jqk.common.network.retrofit.bean.News
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsModel: NewsModel) :
    BaseViewModel() {
    private val _newsLiveData: MutableLiveData<HttpResult<News>> = MutableLiveData()
    val newsLiveData: LiveData<HttpResult<News>> = _newsLiveData

    private val _insertLiveData: MutableLiveData<Long> = MutableLiveData()
    val insertLiveData: LiveData<Long> = _insertLiveData

    fun getNews() {
        launch {
            requestHttp {
                newsModel
                    .getNews("top", "93ff5c6fd6dc134fc69f6ffe3bc568a6")
            }.onSuccess {
                _newsLiveData.value = it
                Log.d("news", "onSuccess = $it")
            }.onFailure {
                Log.d("news", "onFailure = $it")
            }
        }
    }

    fun insert(user: User) {
        viewModelScope.launch {
            _insertLiveData.value = newsModel.insert(user)
        }
    }
}