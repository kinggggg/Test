package com.me.kotlintest.classtest.lee

/**
 * kotlin中的data class自动为主构造器的中的参数生成生成getter和setter
 * var 参数生成getter和setter val 属性生成getter
 * @author: weibo_li
 * @since: 2018-12-05 下午5:25
 */
data class DataClass(var name : String, val age : Int)

fun main(args: Array<String>) {
    var d1 : DataClass = DataClass("zhangsan", 18)

}