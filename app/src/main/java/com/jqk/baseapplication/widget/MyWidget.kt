package com.jqk.baseapplication.widget

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.jqk.baseapplication.R
import com.jqk.baseapplication.databinding.WidgetMyWidgetBinding

/**
 *  author : jiqingke
 *  date : 2021/04/09 11:06
 *  description :
 */
class MyWidget @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    var mBinding: WidgetMyWidgetBinding

    init {
        val view = inflate(context, R.layout.widget_my_widget, this)
        mBinding = WidgetMyWidgetBinding.bind(view)
    }

    fun changeText() {
        mBinding.bt.text = "我是修改过的text"
    }
}