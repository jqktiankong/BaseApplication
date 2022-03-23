package com.cvnavi.settings.expand

import kotlin.Byte

/**
 *  author : jiqingke
 *  date : 2021/05/27 09:18
 *  description :
 */

fun Byte.asInt(): Int {
    return this.toInt().and(0xFF)
}
