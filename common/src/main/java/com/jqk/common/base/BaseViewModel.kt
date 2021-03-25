package com.jqk.common.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel

/**
 * 这里可以对异步请求做一些统一处理，例如显示网络错误提示
 */
open class BaseViewModel : ViewModel(), LifecycleObserver {

}