package com.jqk.common.koin

import com.jqk.baseapplication.koin.newsModule
import com.jqk.common.db.roomKoinModule
import com.jqk.common.network.retrofit.retrofitKoinModule

val appModule = listOf(
    newsModule,
    retrofitKoinModule,
    roomKoinModule
)