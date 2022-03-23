package com.jqk.common.network.retrofit.bean

data class HttpResult<T>(
    var code: String = "",
    var data: T? = null,
    var throwable: Throwable? = null
) {

}