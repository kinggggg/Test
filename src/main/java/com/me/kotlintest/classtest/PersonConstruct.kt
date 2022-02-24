package com.me.kotlintest.classtest

/**
 * kotlin主构造器考察
 * @author: weibo_li
 * @since: 2018-12-05 下午5:08
 */
class PersonConstruct(name : String){

    //定义初始化的块，和java不同的是，kotlin中的初始化块可以访问主构造器中的参数
    init {
        var a = 13
        println("访问主构造器中的参数 name : ${name}")
    }

    init {
        println("kotlin中可以定义多个初始化块")
    }
}

fun main(args: Array<String>) {
    var pc : PersonConstruct = PersonConstruct("张三")


}