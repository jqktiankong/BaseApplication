package com.jqk.common.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jqk.common.network.retrofit.bean.HttpResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 这里可以对异步请求做一些统一处理，例如捕获异常
 */
open class BaseViewModel : ViewModel(), LifecycleObserver {
    suspend fun <T> requestHttp(request: suspend () -> HttpResult<T>): HttpResult<T> {
        val httpResult = HttpResult<T>()
        kotlin.runCatching {
            withContext(Dispatchers.IO) {
                request.invoke()
            }
        }.onSuccess {
            httpResult.data = it.data
        }.onFailure {
            httpResult.throwable = it
        }
        return httpResult
    }

    fun <T> request(
        block: suspend () -> HttpResult<T>,
        success: (HttpResult<T>) -> Unit,
        error: (Throwable) -> Unit = {}
    ) {
        viewModelScope.launch {
            runCatching {
                withContext(Dispatchers.IO) {
                    block()
                }
            }.onSuccess {
                success(it)
            }.onFailure {
                error(it)
            }
        }
    }

    fun <T> launch(block: suspend CoroutineScope.() -> T) {
        viewModelScope.launch {
            block()
        }
    }

    fun <T> launchOnIO(block: suspend CoroutineScope.() -> T) {
        viewModelScope.launch(Dispatchers.IO) {
            block()
        }
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