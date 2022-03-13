package com.jqk.jni

object NDKTools {
    init {
        System.loadLibrary("native-lib")
    }

    // 静态注册
    external fun stringFromJNI(): String

    // 动态注册
    external fun getHello(): String
}