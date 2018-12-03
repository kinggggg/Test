package com.zeek.kotlintest.classtest

/**
 * 定义属性和方法
 * @author: weibo_li
 * @since: 2018-11-26 下午3:31
 */
class Person {

    //定义两个属性
    //var 属性自动生成getter和setter
    var name : String = ""
    //val 属性只生成getter
    val age : Int = 0

    //定义一个方法
    fun say(content : String) {
        println(content)
    }

}

