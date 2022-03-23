package com.cvnavi.settings.expand

import android.view.View
import kotlin.math.abs

/**
 *  author : jiqingke
 *  date : 2021/04/14 18:38
 *  description :
 */
inline var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

/**
 * 设置防抖动的点击事件
 *
 * 防抖动阈值，默认400ms
 */
fun View.setOnThrottledClickListener(
        intervalInMillis: Long = 400L,
        action: (View) -> Unit
) {
    setOnClickListener(
            object : View.OnClickListener {
                private var lastClickedTimeInMillis: Long = 0

                override fun onClick(v: View) {
                    if (abs(System.currentTimeMillis() - lastClickedTimeInMillis) >= intervalInMillis) {
                        lastClickedTimeInMillis = System.currentTimeMillis()
                        action.invoke(v)
                    }
                }
            }
    )
}