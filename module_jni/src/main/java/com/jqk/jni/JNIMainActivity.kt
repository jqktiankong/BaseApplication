package com.jqk.jni

import android.annotation.SuppressLint
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.jqk.common.base.BaseVBActivity
import com.jqk.jni.databinding.ActivityJniMainBinding

@Route(path = JNIMainActivity.PATH)
class JNIMainActivity : BaseVBActivity<ActivityJniMainBinding>() {
    companion object {
        const val PATH = "/jni/main"
    }
    override fun initViewBinding(): ActivityJniMainBinding {
        return ActivityJniMainBinding.inflate(layoutInflater)
    }

    @SuppressLint("SetTextI18n")
    override fun initView(savedInstanceState: Bundle?) {
        binding.tvJni.text = NDKTools.stringFromJNI() + NDKTools.getHello()
    }

    override fun initData() {

    }

    override fun addLiveData() {

    }
}