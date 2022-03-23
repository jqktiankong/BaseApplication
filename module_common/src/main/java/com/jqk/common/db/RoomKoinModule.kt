package com.jqk.common.db

import androidx.room.Room
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext

/**
 *  author : jiqingke
 *  date : 2021/04/12 15:39
 *  description :
 */
val roomKoinModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDB::class.java, "database-name").build()
            .userDao()
    }

}