package com.jqk.login

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import com.jqk.common.base.BaseViewModel

class NewsViewModel @ViewModelInject constructor(private val newsModel: NewsModel) :
    BaseViewModel() {

    fun getNews() {
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