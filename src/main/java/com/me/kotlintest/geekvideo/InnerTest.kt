package com.me.kotlintest.geekvideo

/**
 * @author liweibo03
 * Created on 2020-09-01
 */

fun main(args: Array<String>) {

    InnerTest.sayMessage("hello")
}

// kotlin中匿名内部类写法
object InnerTest {

    @JvmStatic
    fun sayMessage(msg: String) {
        println(msg)
    }
}