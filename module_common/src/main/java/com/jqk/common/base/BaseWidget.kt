package com.jqk.common.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewbinding.ViewBinding

/**
 *  author : jiqingke
 *  date : 2021/04/16 16:22
 *  description :
 */
abstract class BaseWidget<VB : ViewBinding> constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    var binding: VB

    @LayoutRes
    var layoutId: Int
    var view: View

    init {
        layoutId = getLayoutResouseId()
        view = inflate(context, layoutId, this)
        binding = initViewBinding()
    }

    @LayoutRes
    abstract fun getLayoutResouseId(): Int

    abstract fun initViewBinding(): VB

}