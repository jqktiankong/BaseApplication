package com.jqk.common.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewbinding.ViewBinding

/**
 *  author : jiqingke
 *  date : 2021/04/16 16:22
 *  description :
 */
abstract class BaseWidget<T : ViewBinding> constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    var binding: T
    var layoutId: Int
    var view: View

    init {
        layoutId = getLayoutResouseId()
        view = inflate(context, layoutId, this)
        binding = initViewBinding()
    }

    abstract fun getLayoutResouseId(): Int

    abstract fun initViewBinding(): T

}