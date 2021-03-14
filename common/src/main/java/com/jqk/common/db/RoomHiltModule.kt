package com.jqk.common.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomHiltModule {
    @Singleton
    @Provides
    fun provideUserDao(@ApplicationContext context: Context): UserDao {
        return Room.databaseBuilder(context, AppDB::class.java, "database-name").build().userDao()
    }
}