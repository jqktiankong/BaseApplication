package com.jqk.baseapplication.hilt.news

import com.jqk.common.base.BaseModel
import com.jqk.common.db.User
import com.jqk.common.db.UserDao
import com.jqk.common.network.retrofit.RetrofitService
import com.jqk.common.network.retrofit.bean.HttpResult
import com.jqk.common.network.retrofit.bean.News
import javax.inject.Inject

class NewsModel @Inject constructor(
    private val retrofitService: RetrofitService,
    private val userDao: UserDao
) : BaseModel() {

    suspend fun getNews(type: String, key: String): HttpResult<News> {
        return requestHttp {
            retrofitService.getNew(type, key)
        }
    }

    suspend fun insert(user: User): Long {
        return userDao.insertUser(user)
    }
}