package com.jqk.baseapplication.koin

import android.util.Log
import androidx.lifecycle.*
import com.jqk.common.base.BaseViewModel
import com.jqk.common.db.User
import com.jqk.common.network.retrofit.bean.HttpResult
import com.jqk.common.network.retrofit.bean.News
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NewsViewModel constructor(
    private val newsModel: NewsModel
) : BaseViewModel() {
    private val _newsLiveData: MutableLiveData<HttpResult<News>> = MutableLiveData()
    val newsLiveData: LiveData<HttpResult<News>> = _newsLiveData

    private val _insertLiveData: MutableLiveData<Long> = MutableLiveData()
    val insertLiveData: LiveData<Long> = _insertLiveData

    private val _newStateFlow = MutableStateFlow(HttpResult<News>())
    val newStateFlow: StateFlow<HttpResult<News>> = _newStateFlow

    fun getNews() {
        request(
            block = {
                newsModel
                    .getNews("top", "93ff5c6fd6dc134fc69f6ffe3bc568a6")
            },
            success = {
                _newsLiveData.value = it
                Log.d("news", "onSuccess = $it")
            },
            error = {
                Log.d("news", "onFailure = $it")
            }
        )
    }

    fun getNewsByFlow() {
        launchOnIO {
            newsModel.getNewsFlow("top", "93ff5c6fd6dc134fc69f6ffe3bc568a6").collect {
                _newStateFlow.value = it
            }
        }
    }

    fun insert(user: User) {
        viewModelScope.launch {
            _insertLiveData.value = newsModel.insert(user)
        }
    }
}