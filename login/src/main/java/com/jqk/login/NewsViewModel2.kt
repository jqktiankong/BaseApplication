package com.jqk.login

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import com.jqk.common.base.BaseViewModel
import com.jqk.common.base.onFailure
import com.jqk.common.base.onSuccess

class NewsViewModel2 @ViewModelInject constructor(private val newsModel: NewsModel) :
    BaseViewModel() {

    fun getNews() {
        launch {
            requestHttp {
                newsModel
                    .getNews("top", "93ff5c6fd6dc134fc69f6ffe3bc568a6")
            }.onSuccess {
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
                Log.d("news", "onSuccess = $it")
            },
            error = {
                Log.d("news", "onFailure = $it")
            }
        )
    }
}