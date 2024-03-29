package com.me.kotlintest.classtest.chapter10

/**
 * kotlin使用处型变
 * @author: weibo_li
 * @since: 2019-01-14 下午4:14
 */
fun copy(from : Array<out Any>, to : Array<Any>){
    val len = if(from.size < to.size) from.size else to.size
    for (i in 0 until len) {
        to[i] = from[i]
    }
}

fun main(args: Array<String>) {
    var arr1 = arrayOf(2, 3, 15, 26)
    var arr2 : Array<Any> = arrayOf(4, 13, 25, 74, 34)
    copy(arr1, arr2)
    println(arr2.contentToString())
}