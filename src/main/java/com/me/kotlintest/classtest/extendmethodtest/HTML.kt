package com.me.kotlintest.classtest.extendmethodtest

/**
 *
 * @author: weibo_li
 * @since: 2019-01-07 下午2:33
 */
class HTML {

    fun body() {
        println("<body></body>")
    }

    fun head() {
        println("<head></head>")
    }


}

fun html(init : HTML.() -> Unit) {
    println("<html>")
    var html = HTML()
    html.init()
    println("</html>")
}

fun main(args: Array<String>) {
    val init: HTML.() -> Unit = {
        body()
        head()
    }
    html(init)
}