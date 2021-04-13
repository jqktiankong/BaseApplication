package com.jqk.baseapplication.koin

import com.jqk.common.db.roomKoinModule
import com.jqk.common.network.retrofit.retrofitKoinModule

val appModule = listOf(
    newsModule,
    retrofitKoinModule,
    roomKoinModule
)