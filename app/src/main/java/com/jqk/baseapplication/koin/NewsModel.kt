package com.jqk.baseapplication.koin

import android.util.Log
import com.jqk.common.base.BaseModel
import com.jqk.common.db.User
import com.jqk.common.db.UserDao
import com.jqk.common.network.retrofit.RetrofitService
import com.jqk.common.network.retrofit.bean.HttpResult
import com.jqk.common.network.retrofit.bean.News
import kotlinx.coroutines.flow.*

class NewsModel constructor(
    private val retrofitService: RetrofitService,
    private val userDao: UserDao
) : BaseModel() {

    suspend fun getNews(type: String, key: String): HttpResult<News> {
        return requestHttp {
            retrofitService.getNew(type, key)
        }
    }

    /**
     * 使用map包装数据
     */
    fun getNewsFlow(type: String, key: String): Flow<HttpResult<News>> {
        return flow {
            emit(retrofitService.getNew(type, key))
        }.map {
            return@map HttpResult("", it)
        }
    }

    suspend fun insert(user: User): Long {
        return userDao.insertUser(user)
    }
}