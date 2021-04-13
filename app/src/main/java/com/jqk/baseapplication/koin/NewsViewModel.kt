package com.jqk.baseapplication.koin

import android.util.Log
import androidx.lifecycle.*
import com.jqk.common.base.BaseViewModel
import com.jqk.common.base.onFailure
import com.jqk.common.base.onSuccess
import com.jqk.common.db.User
import com.jqk.common.network.retrofit.RetrofitService
import com.jqk.common.network.retrofit.bean.HttpResult
import com.jqk.common.network.retrofit.bean.News
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class NewsViewModel constructor(
    private val newsModel: NewsModel
) : BaseViewModel() {

    val newsLiveData: MutableLiveData<HttpResult<News>> = MutableLiveData()
    val insertLiveData: MutableLiveData<Long> = MutableLiveData()

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

    fun insert(user: User) {
        viewModelScope.launch {
            insertLiveData.value = newsModel.insert(user)
        }
    }
}