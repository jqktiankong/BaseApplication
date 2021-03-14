package com.jqk.common.db

import androidx.room.*

@Dao
interface UserDao {
    // 插入
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long

    // 更新
    @Update
    suspend fun updateUsers(vararg users: User): Int

    // 删除
    @Delete
    suspend fun deleteUsers(vararg users: User): Int

    // 简单的查询
    @Query("SELECT * FROM db_user")
    suspend fun loadAllUsers(): Array<User>
}