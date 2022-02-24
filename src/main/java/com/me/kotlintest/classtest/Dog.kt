package com.me.kotlintest.classtest

/**
 * this在方法中的使用
 * @author: weibo_li
 * @since: 2018-11-26 下午4:32
 */
class Dog {

    fun jump() {
        println("jump")
    }

    fun run () {
        println("run")
        this.jump();
    }
}