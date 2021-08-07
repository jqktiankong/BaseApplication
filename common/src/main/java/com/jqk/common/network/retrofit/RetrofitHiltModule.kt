package com.jqk.common.network.retrofit

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitHiltModule {
    @Singleton
    @Provides
    fun provideRetrofitService(): RetrofitService {
        return RetrofitUtil.createRetrofitService()
    }
}