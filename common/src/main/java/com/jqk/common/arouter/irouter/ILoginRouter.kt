package com.jqk.common.arouter.irouter

import com.alibaba.android.arouter.facade.template.IProvider
import com.jqk.common.arouter.bean.ParamData

interface ILoginRouter : IProvider {
    fun showLoginUI(param: String, param2: ParamData)
}