package com.jqk.baseapplication.hilt.news

import com.jqk.common.db.AppDB
import com.jqk.common.db.User
import com.jqk.common.db.UserDao
import com.jqk.common.network.retrofit.RetrofitService
import com.jqk.common.network.retrofit.bean.News
import javax.inject.Inject

class NewsModel @Inject constructor(
    private val retrofitService: RetrofitService,
    private val userDao: UserDao
) {

    suspend fun getNews(type: String, key: String): News {
        return retrofitService.getNew(type, key)
    }

    suspend fun insert(user: User): Long {
       return userDao.insertUser(user)
    }
}