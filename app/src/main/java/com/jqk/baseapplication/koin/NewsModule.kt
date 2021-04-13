package com.jqk.baseapplication.koin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *  author : jiqingke
 *  date : 2021/04/12 15:27
 *  description :
 */
val newsModule = module {
    factory { NewsModel(get(), get()) }

    viewModel { NewsViewModel(get()) }
}