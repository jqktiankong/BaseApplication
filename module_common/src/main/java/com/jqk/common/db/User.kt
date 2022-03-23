package com.jqk.common.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "db_user")
data class User(
        @PrimaryKey
        val id: Int,
        // 列名称
        @ColumnInfo(name = "first_name")
        val firstName: String?,
        @ColumnInfo(name = "last_name")
        val lastName: String?,
        val age: Int,
        val region: String
)