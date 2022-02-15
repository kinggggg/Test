package com.me.kotlintest.classtest.extendmethodtest

/**
 * 扩展方法
 * @author: weibo_li
 * @since: 2019-01-07 下午12:39
 */
// 定义一个扩展方法
fun Raw.info() {
    println("===扩展info方法===")
}

fun main(args: Array<String>) {
    var t = Raw()
    // 调用成员方法
    t.test()
    // 调用扩展方法
    t.info()

    var rs = RawSub()
    // 调用成员方法
    rs.test()
    // 调用扩展方法
    rs.info()
}