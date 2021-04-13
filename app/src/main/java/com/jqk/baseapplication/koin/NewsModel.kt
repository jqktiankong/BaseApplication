package com.jqk.baseapplication.koin

import android.util.Log
import com.jqk.common.base.BaseModel
import com.jqk.common.db.User
import com.jqk.common.db.UserDao
import com.jqk.common.network.retrofit.RetrofitService
import com.jqk.common.network.retrofit.bean.HttpResult
import com.jqk.common.network.retrofit.bean.News
import org.koin.java.KoinJavaComponent.inject

class NewsModel constructor(
    private val retrofitService: RetrofitService,
    private val userDao: UserDao
) : BaseModel() {

    suspend fun getNews(type: String, key: String): HttpResult<News> {
        return requestHttp {
            Log.d("news", "Thread name2 = ${Thread.currentThread().name}")
            retrofitService.getNew(type, key)
        }
    }

    suspend fun insert(user: User): Long {
        return userDao.insertUser(user)
    }
}