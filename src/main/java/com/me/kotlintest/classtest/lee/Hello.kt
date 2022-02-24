package com.me.kotlintest.classtest.lee

import java.util.Date
//对同名类的不同包可以指定别名
import java.sql.Date as SData

/**
 * kotlin包考察
 * @author: weibo_li
 * @since: 2018-12-05 下午4:18
 */

public var bar : Int = 5
private set //啥意思？？？

fun test () {
    println("简单的test()函数")
}

class Foo(name : String) {
    var name = name
}

fun main(args: Array<String>) {
    println("带包的主函数")

    //使用java.util.Data
    var date = Date()
    var d2 = SData(System.currentTimeMillis())

    println(date)
    println(d2)


}

