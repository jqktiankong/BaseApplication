package com.jqk.common.base

import com.jqk.common.db.bean.DatabaseResult
import com.jqk.common.network.retrofit.bean.HttpResult

// 对数据进行统一封装
open class BaseModel {
    suspend fun <T> requestHttp(block: suspend () -> T): HttpResult<T> {
        val data = block.invoke()
        return HttpResult("", data)
    }

    suspend fun <T> reqeustLocal(block: suspend () -> T): DatabaseResult<T> {
        val data = block.invoke()
        return DatabaseResult("", data)
    }
}