package com.me.kotlintest.classtest.chapter12

/**
 *
 * @author: weibo_li
 * @since: 2019-01-28 下午3:49
 */
fun main(args: Array<String>) {

    val str = "Kotlin" ;
    var f : (CharSequence, Boolean) -> Boolean = str::endsWith
    println(f("lin", true))

}