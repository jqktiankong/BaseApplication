package com.jqk.common.network.retrofit.bean

data class News(
    var reason: String,
    var result: Result,
    var error_code: Int,
    val resultcode: String
) {
    data class Result(
            var stat: String,
            var data: List<Data>
    ) {
        data class Data(
                var uniquekey: String,
                var title: String,
                var date: String,
                var category: String,
                var author_name: String,
                var url: String,
                var thumbnail_pic_s: String,
                var thumbnail_pic_s02: String,
                var thumbnail_pic_s03: String
        )
    }
}