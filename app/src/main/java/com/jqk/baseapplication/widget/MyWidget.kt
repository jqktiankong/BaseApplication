package com.jqk.baseapplication.widget

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.jqk.baseapplication.R
import com.jqk.baseapplication.databinding.WidgetMyWidgetBinding
import com.jqk.common.base.BaseWidget

/**
 *  author : jiqingke
 *  date : 2021/04/09 11:06
 *  description :
 */
class MyWidget @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseWidget<WidgetMyWidgetBinding>(context, attrs, defStyleAttr) {

    override fun getLayoutResouseId() = R.layout.widget_my_widget

    override fun initViewBinding() = WidgetMyWidgetBinding.bind(view)

    fun changeText() {
        binding.bt.text = "我是修改过的text"
    }
}