package com.me.kotlintest.classtest.chapter8.chapter87

/**
 * kotlin枚举类测试
 * @author: weibo_li
 * @since: 2019-01-11 下午4:49
 */
enum class Season {
    // 枚举类第一样列出四个实例
    SPRING, SUMMER, FALL, WINTER
}

fun main(args: Array<String>) {

    for (s in Season.values()) {
        println(s)
    }

    println("=====================")

    var seasonName : String = "SPRING"
    val s : Season = Season.valueOf(seasonName)
    println(s) // 实际上调用的是s.toString()
    println(s.toString())
    println(s.name)

}