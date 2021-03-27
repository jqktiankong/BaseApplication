package com.jqk.common.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.jqk.common.network.retrofit.bean.HttpResult

/**
 * 这里可以对异步请求做一些统一处理，例如捕获异常
 */
open class BaseViewModel : ViewModel(), LifecycleObserver {
    suspend fun <T> requestHttp(request: suspend () -> HttpResult<T>): HttpResult<T> {
        val httpResult = HttpResult<T>()
        kotlin.runCatching {
            request.invoke()
        }.onSuccess {
            httpResult.data = it.data
        }.onFailure {
            httpResult.throwable = it
        }
        return httpResult
    }
}


inline fun <T> HttpResult<T>.onSuccess(action: (value: HttpResult<T>) -> Unit): HttpResult<T> {
    this.data?.let {
        action(this)
    }
    return this
}

inline fun <T> HttpResult<T>.onFailure(action: (value: Throwable) -> Unit): HttpResult<T> {
    this.throwable?.let {
        action(it)
    }
    return this
}