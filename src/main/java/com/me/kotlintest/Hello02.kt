package com.me.kotlintest

fun main(args: Array<String>) {

    println("===========================使用函数类型==========================")
    println("定义函数类型的变量")
    var myfun : (Int, Int) -> Int
    var test : (String)
    var multiVar : (Int, Int) -> Int
    multiVar = ::multi;

    // 只能用it不能用n
    var square: (Int) -> Int = { it * it }
//    square = { n * n}
    println("调用square函数${square(2)}")
    square = {n -> n * n}
    println("调用square函数${square(2)}")

    fun area(width : Int, height : Int) : Int {
        return width * height;
    }
    println("函数赋值给函数类型的变量")
    myfun = :: area;
    println(myfun(3, 4))

    println("===========================函数作为参数==========================")
    fun funArg(one : Int, two : Int, fn : (Int, Int) -> Int) : Int{
        return fn(one, two)
    }
    println("两个数相乘 : ${funArg(3, 4, ::multi)}")
    println("两个数相加 : ${funArg(3, 4, ::plus)}")

    println("===========================函数返回值为函数==========================")
    fun funRet(funName : String) : (Int, Int) -> Int {
        when(funName) {
            "multi" -> return ::multi;
            "plus" -> return ::plus;
            else -> return ::minus
        }
    }
    println(funRet("multi")(3, 4))
    println(funRet("plus")(3, 4))
    println(funRet("abc")(3, 4))

    println("===========================lambda表达式作为返回值==========================")
    println(getMathFun("multi")(3))
    println(getMathFun("plus")(3))
    println(getMathFun("abc")(3))

    collectFn({ n -> n * n })
    collectFn({ n -> n + n })
    println("函数集合的大小为 : ${lambdaList.size}")
    for (i in lambdaList.indices) {
        println("i : ${i}")
        println("i : ${lambdaList[i]}")
        println(lambdaList[i](5))
    }

    println("===========================变量捕获==========================")
    var add1 = makeList("孙悟空")
    println(add1())
    println(add1())
    var add2 = makeList("猪八戒")
    println(add2())
    println(add2())

}

/**
 * 变量捕获
 */
fun makeList(ele : String) : () -> List<String> {
    var list : MutableList<String> = mutableListOf()
    fun addElement() : List<String> {
        list.add(ele)
        return list
    }

    return ::addElement
}

var lambdaList = java.util.ArrayList<(Int) -> Int>();
fun collectFn(fn : (Int) -> Int) {
    lambdaList.add(fn)
}

/**
 * lambda表达式作为返回值
 */
fun getMathFun(type : String) : (Int) -> Int {
    when(type) {
        "multi" -> return { n : Int -> n * n}
        "plus" -> return {n : Int -> n + n}
        else -> return { n : Int -> n - n}
    }
}

/**
 * 两个数相乘
 */
fun multi(one : Int, two : Int) : Int {
    return one * two;
}

/**
 * 两个数相加
 */
fun plus(one : Int, two : Int) : Int {
    return one + two;
}

/**
 * 两个数相减
 */
fun minus(one : Int, two : Int) : Int {
    return one - two;
}