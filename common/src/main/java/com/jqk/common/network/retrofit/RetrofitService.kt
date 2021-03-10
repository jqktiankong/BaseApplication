package com.jqk.common.network.retrofit

import com.jqk.common.network.retrofit.bean.News
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface RetrofitService {
    @GET("index")
    suspend fun getNew(
        @Query("type") type: String,
        @Query("key") key: String
    ): News
}