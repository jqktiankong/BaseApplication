package com.jqk.baseapplication.navigation

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.jqk.common.base.BaseViewModel

class BlankViewModel : BaseViewModel {
    @ViewModelInject
    constructor()

    val stringLiveData: MutableLiveData<String> = MutableLiveData()
    val stringLiveData2: MutableLiveData<String> = MutableLiveData()

    fun getString() {
        stringLiveData.value = "我是字符串"
    }

    fun getString2() {
        Log.d("TAG", "getString2 = ${stringLiveData2.value}")
        stringLiveData2.value = "我是字符串2"
    }
}