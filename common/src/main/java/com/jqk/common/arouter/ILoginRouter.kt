package com.jqk.common.arouter

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

interface ILoginRouter : IProvider {
    fun showLoginUI(context: Context, param: String)
}