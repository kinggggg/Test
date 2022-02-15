package com.me.kotlintest.classtest.chapter9.chapter91

/**
 * kotlin异常捕获
 * @author: weibo_li
 * @since: 2019-01-14 上午10:38
 */
fun main(args: Array<String>) {

    try {
        var a = Integer.parseInt(args[0]);
        var b = Integer.parseInt(args[1]);

        var c = a / b;
        println("两个数相除的结果是：${c}")
    }catch (e : RuntimeException) {
        println("Exception")
    }catch (ie : IndexOutOfBoundsException) {
        println("IndexOutOfBoundsException")
    }

}
