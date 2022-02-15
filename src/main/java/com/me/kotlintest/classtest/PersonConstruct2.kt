package com.me.kotlintest.classtest

/**
 * kotlin主构造器考察
 * @author: weibo_li
 * @since: 2018-12-05 下午5:08
 */
class PersonConstruct2(name : String){

    var name : String? = null;

    var age : Int = 0

    var address : String? = null;

    //定义初始化的块，和java不同的是，kotlin中的初始化块可以访问主构造器中的参数
    init {
        var a = 13

        this.name = name

        println("访问主构造器中的参数 name : ${name}")
    }

    init {
        println("kotlin中可以定义多个初始化块")
    }

    constructor(name : String, age : Int) : this(name) {
        this.age = age
    }

    constructor(name : String, age : Int, address : String): this(name, age) {
        this.address = address
    }


}

fun main(args: Array<String>) {

    var pc2 : PersonConstruct2 = PersonConstruct2("张三", 18)
    println("name : ${pc2.name}, age : ${pc2.age}")


}