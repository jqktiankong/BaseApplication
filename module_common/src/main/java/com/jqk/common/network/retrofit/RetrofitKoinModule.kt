package com.jqk.common.network.retrofit

import com.jqk.common.network.retrofit.RetrofitUtil
import org.koin.dsl.module

/**
 *  author : jiqingke
 *  date : 2021/04/12 15:36
 *  description :
 */
val retrofitKoinModule =  module{
    single { RetrofitUtil.createRetrofitService() }
}