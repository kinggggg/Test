package com.me.kotlintest.zhangtao

/**
 *
 * @author: weibo_li
 * @since: 2019-02-19 下午7:19
 */
var age : Int = 18
var name : String = "zhang tao"
var name2 : String? = null
fun main(args: Array<String>) {

    //name = name2!!//两个!!代表强转，前提是name2确定不能为null
    //name2 = name //name2既可以为null也可以不为null，而name只能是字符串，name2所可以具备的值包含name，因此name可以直接赋值给name2

    printlen(name)

}

fun printlen(str: String): String {
    println("这个字符串是$str")

    return str
}