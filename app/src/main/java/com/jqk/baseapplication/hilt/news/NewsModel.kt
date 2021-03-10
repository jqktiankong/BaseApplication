package com.jqk.baseapplication.hilt.news

import com.jqk.common.network.retrofit.RetrofitService
import com.jqk.common.network.retrofit.bean.News
import javax.inject.Inject

class NewsModel @Inject constructor(private val retrofitService: RetrofitService) {

    suspend fun getNews(type: String, key: String): News {
        return retrofitService.getNew(type, key)
    }
}