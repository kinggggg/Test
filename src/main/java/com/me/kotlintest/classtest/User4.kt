package com.me.kotlintest.classtest

/**
 * kotlin中的属性相当于java中的field加上getter和setter
 * @author: weibo_li
 * @since: 2018-12-03 下午2:15
 */
class User4(first : String, last : String, age2 : Int) {


    //对于var修饰的属性属性kotlin会自动生成getter和setter
    var firstName : String = first

    var lastName : String = last

    //对于val修饰的属性只自动生成getter方法
    val age1 : Int  = age2;

    //延迟初始化属性，可以在定义该属性时和在构造器中不指定初始化的值
    lateinit var name: String

    //自定义getter方法
    val fullName : String get() {
        return "${firstName}.${lastName}" ;
    }


}

fun main(args: Array<String>) {

    var user4 : User4 = User4("hello", "world", 18)

    println(user4.fullName)

    //访问之前必须给延迟初始化属性赋值
    user4.name = "zhangsan"
    println(user4.name)


}