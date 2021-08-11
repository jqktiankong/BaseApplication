package com.jqk.baseapplication.koin

import android.util.Log
import androidx.lifecycle.*
import com.jqk.common.base.BaseViewModel
import com.jqk.common.base.onFailure
import com.jqk.common.base.onSuccess
import com.jqk.common.db.User
import com.jqk.common.network.retrofit.bean.HttpResult
import com.jqk.common.network.retrofit.bean.News
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.launch

class NewsViewModel constructor(
    private val newsModel: NewsModel
) : BaseViewModel() {

    val newsLiveData: MutableLiveData<HttpResult<News>> = MutableLiveData()
    val insertLiveData: MutableLiveData<Long> = MutableLiveData()

    val newsLiveData2 = liveData {
        emit(
            newsModel
                .getNews("top", "93ff5c6fd6dc134fc69f6ffe3bc568a6")
        )

        emitSource(newsLiveData)
    }

    // 普通Flow
    val newsLiveData3 = newsModel.getNewsFlow("top", "93ff5c6fd6dc134fc69f6ffe3bc568a6")

    // SharedFlow
    val newSharedFlow = MutableSharedFlow<HttpResult<News>>(0, 0)
    val newSharedFlow2 = newsModel.getNewsFlow("top", "93ff5c6fd6dc134fc69f6ffe3bc568a6")
        .shareIn(viewModelScope, WhileSubscribed())

    // StateFlow
    val newStateFlow = MutableStateFlow(HttpResult<News>())
    val newStateFlow2 = newsModel.getNewsFlow("top", "93ff5c6fd6dc134fc69f6ffe3bc568a6")
        .stateIn(viewModelScope, WhileSubscribed(5000), HttpResult<News>())

    fun getNews() {
        launch {
            requestHttp {
                newsModel
                    .getNews("top", "93ff5c6fd6dc134fc69f6ffe3bc568a6")
            }.onSuccess {
                newsLiveData.value = it
                Log.d("news", "onSuccess = $it")
            }.onFailure {
                Log.d("news", "onFailure = $it")
            }
        }

        request(
            block = {
                newsModel
                    .getNews("top", "93ff5c6fd6dc134fc69f6ffe3bc568a6")
            },
            success = {
                newsLiveData.value = it
                Log.d("news", "onSuccess = $it")
            },
            error = {
                Log.d("news", "onFailure = $it")
            }
        )
    }

    suspend fun getNewsBySharedFlow() {
        newSharedFlow.emit(newsModel.getNews("top", "93ff5c6fd6dc134fc69f6ffe3bc568a6"))
    }

    fun insert(user: User) {
        viewModelScope.launch {
            insertLiveData.value = newsModel.insert(user)
        }
    }
}