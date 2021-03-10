package com.jqk.baseapplication

import android.os.Bundle
import android.widget.TextView
import com.jqk.common.base.BaseCommonActivity

class MainActivity : BaseCommonActivity() {
    private lateinit var text: TextView

    override fun initContentViewID(): Int {
        return R.layout.activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        text = findViewById(R.id.text)

        text.text = "哈哈"
    }

    override fun initData() {

    }

}