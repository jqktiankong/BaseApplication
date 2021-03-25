package com.jqk.common.base

import com.jqk.common.network.retrofit.bean.HttpResult

open class BaseModel {
    suspend fun <T> requestHttp(block: suspend () -> T): HttpResult<T> {
        kotlin.runCatching {
            block.invoke()
        }.onSuccess {
            return HttpResult("成功", it)
        }.onFailure {
            return HttpResult("报错", null)
        }

        return HttpResult("不会走到", null)
    }
}