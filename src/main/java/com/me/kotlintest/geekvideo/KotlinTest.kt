package com.me.kotlintest.geekvideo

import java.io.File
import java.util.*
import kotlin.reflect.KClass

/**
 * @author liweibo
 * Created on 2020-08-31
 */


var age: Int = 18
var age1 = 18

var name: String = "zhang san"
var name2: String? = null

fun main(args: Array<String>) {
    // 强制转换
//    name = name2!!
//    name2 = name

    printLen(name)

    testClass(com.me.kotlintest.geekvideo.JavaMain::class.java)
    testClass(KotlinMain::class)

    var a = 10;
    println(a.unaryMinus())

    var str1 = java.lang.String("hello")
    var str2 = java.lang.String("hello")
    println(str1 == str2)
    var b: String? = null
    var c: String? = null
    println(str1?.equals(b))
    println(null == null)
    println(null === null)

    var closeRange = 1 .. 10;
    for (num in closeRange) {
        println(num)
    }
    println(closeRange)
    println(closeRange.count())
    println("==============================================1")
    for (index in 0 until closeRange.count()) {
        println(index)
    }

    println("==============================================2")
    // kotlin的break只break内层的循环
    for (i in 0 .. 10) {
        for (j in 0..10) {
            println("i = $i, j = $j")
            if (j == 1) {
                println("break")
                break;
            }
        }
    }
    println("==============================================3")
    for (i in 0 .. 10) {
        for (j in 0..10) {
            println("i = $i, j = $j")
            if (j == 1) {
                println("return")
                // return 执行完成后，整个方法就返回了
//                return
            }
        }
    }

    printTest("zhangsan", 18)

    println("==============================================4")
    defaultValue()

    println("==============================================5")
    // 无法访问内部函数
//    inner();
    outerFunTest();

    println("==============================================6")
    var file: File = File("/Users/liweibo03/Documents/code/Test/src/main/java/com/jvm/fangzhiming/TestClass.java")
    var readText = file.readText(Charsets.UTF_8)
    println(readText)
    println("==============================================7")

    // kotlin中匿名内部类
    val thread = Thread({ -> Unit })
    thread.start()
    // 如果lambda没有参数，可以省略箭头符号 ->
    var thread2 = Thread({})
    thread2.start()
    // 如果lambda是是函数最后一个参数
    var thread3 = Thread(){}
    thread3.start()

    // 函数只有一个参数且这个参数是lambda，则可以省略小括号
    var thread4 = Thread{}
    thread4.start()

    println("==============================================8")
    // 闭包
    print("hello")

    println("==============================================9")
    var arr1 = arrayOf("Java", "Kotlin")
    println(Arrays.toString(arr1))
    var param : (Int) -> Int = fun (a: Int): Int {
        return a + a
    }
    var arr2 = IntArray(5,  param)
    println(Arrays.toString(arr2))
    var arr3 = IntArray(5, fun (a : Int) : Int {
        return a * a
    })
    println(Arrays.toString(arr3))
    var arr4 = IntArray(5, {it -> it * 3})
    println(Arrays.toString(arr4))

    println("==============================================10")
    // 函数调用
    funcTest(1, 2)


    // 定义函数变量
    var lambdaTest2 : (a : Int, b : Int) -> Int
    lambdaTest2 = returnFunTest(10)
    var lambdaTest21 = lambdaTest2(1, 2)
    println(lambdaTest21)
    println("==============================================11")
    // kotlin中lambda表达式与局部函数存在如下的区别：
    // 1. lambda表达式总是被大括号括着
    // 2. 定义lambda表达式不需要fun关键字，无须指定函数名
    // 3. 形参列表（如果有的话）在->之前声明，参数类型可以省略（如果能推断出的话）
    // 4. 函数体（lambda表达式执行体）放在->之后
    // 5. 函数的最后一个表达式被作为lambda表达式的返回值，无须使用return关键字
    println("==============================================12")
    // 完整的lambda表达式需要定义形参类型，但是如果Kotlin可以根据lambda表达式上下文推断出形参类型，那么lambda表达式可以省略形参类型
    // 根据变量的类型可以推断出lambda参数的类型，因此lambda参数的类型可以省略
    var square : (Int) -> Int = {n -> n * n}
    println(square(2))
    // 由于变量没有显示声明类型，因此无法推断出lambda参数的类型，此时lambda参数的类型不能省略
    var square2 = {n : Int -> n * n};
    println(square2(2))
    println("==============================================13")
    // lambda表达式不仅可以省略参数类型，而且如果只有一个形参，那么Kotlin允许省略lambda表达式的形参名。如果lambda表达式省略了形参名，那么此时->也不需要了
    // 此时需要注意的当省略的参数名、参数类型和->后，在 默认的情况Kotlin会将形参的参数名命名成it，因此下面的lambda可以编译通过
    var square3 : (Int) -> Int = {it * it}
    println(square3(3))
    // 下面的无法编译通过
//    var square4 : (Int) -> Int = {itt * itt}
    println("==============================================14")
    // kotlin语言有一个约定：如果函数的最后一个参数是函数类型，而且你打算传入一个lambda表达式作为相应的参数，那么就允许在圆括号之外指定lambda表达式
    var list = listOf("Go", "Java", "Kotlin")
    list = list.dropWhile() { it.length < 5 }
    println(list)
    // 此外，如果lambda表达式是函数调用的唯一参数，则调用方法时，圆括号完全可以省略
    list = list.dropWhile { it.length < 4 }
    println("==============================================15")
    var arrayOf = arrayOf("Java", "Kotlin", "Go")
    for (ele in arrayOf) {
        println(ele)
    }
    for (i in arrayOf.indices) {
        println(arrayOf[i])
    }
    for (entity in arrayOf.withIndex()) {
        println("index: ${entity.index}, value: ${entity.value}")
    }
    println("==============================================16")
    // 默认创建的是LinkedHashSet
    var set = setOf("Java", "Kotlin")
    println(set)
    println(set.javaClass)
    // 默认创建的是LinkedHashSet
    var mutableSetOf = mutableSetOf("Java", "Kotlin")
    mutableSetOf.add("Go")
    println(mutableSetOf)
    println(mutableSetOf.javaClass)
    // 明确创建LinkedHashSet
    var linkedSetOf = linkedSetOf("Java", "Kotlin")
    // 创建的是HashSet
    var hashSetOf = hashSetOf("Java", "Kotlin")
    println(hashSetOf.javaClass)
    println("==============================================17")
    var mapOf = mapOf("Java" to 1, "Kotlin" to 2)
    println(mapOf.get("Java"))
    var p : (Map.Entry<String, Int>) -> Unit
    p = {it : Map.Entry<String, Int> -> println("${it.key} -> ${it.value}")}
    p = {it -> println("${it.key} -> ${it.value}")}
    p = {println("${it.key} -> ${it.value}")}
    //    p = {println("${it.key} -> ${it.value}")}
//    mapOf.forEach(p)
//    mapOf.forEach(){println("${it.key} -> ${it.value}")}
//    mapOf.forEach {println("${it.key} -> ${it.value}")}
    // 虽然p是lambda表达式但是下面的写法是错误的！虽然Kotlin中有这个约定：kotlin语言有一个约定：如果函数的最后一个参数是函数类型，而且你打算传入一个lambda表达式作为相应的参数，那么就允许在圆括号之外指定lambda表达式
//    mapOf.forEach(){p}
    println("==============================================18")
    noReturnVal(1, 2)
    noReturnVal2(3)
    println("==============================================19")
    var area = area(2.0, 3.0)
    println("==============================================20")
    varargFun("zhangsan", "lisi", age = 30)
    println("==============================================21")
    var myfun :  (m : Int) -> (Int) = outerFun2()
    var myfun1 = myfun(10)
    println(myfun1)

    println("==============================================22")
    fun add(x: Int, y: Int): Int {
        return x + y;
    }
    fun sub(x: Int, y: Int): Int {
        return  x - y
    }

    var arrayOf1 = arrayOf(1, 3);

    // 函数作为参数
    var result = funAsParam(arrayOf1, ::add)
    println(result)
    result = funAsParam(arrayOf1, ::sub)
    println(result)
    println("==============================================23")
    var returnFun = funAsReturn("add")
    println(returnFun(1, 2))
    returnFun = funAsReturn("sub")
    println(returnFun(1, 2))

}

// 函数作为返回值
fun funAsReturn(name: String): (Int, Int) -> Int {
    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun sub(x: Int, y: Int): Int {
        return x - y
    }

    when (name) {
        "add" -> return ::add
        "sub" -> return ::sub
        else -> return ::add
    }
}

// 函数作为参数
fun funAsParam(data : Array<Int>, funParam: (x: Int, y: Int) -> Int) : Int{
    return funParam(data[0], data[1])
}

// 外部函数
fun outerFun2(): (m : Int) -> (Int) {

    fun innerFunReturnFun(): (m : Int) -> (Int) {
        return {z -> z + 10}
    }

    // 返回的是 innerFunReturnFun 函数本身
//    return ::innerFunReturnFun;
    // 返回的是 (m : Int) -> (Int)类型的lambda表达式
    return innerFunReturnFun()
}

// 外部函数
fun outerFun(x: Int): Int {

    // 内部函数的作用域是外部函数outerFun的作用域
    fun innerFun(y: Int): Int {
        return y * y
    }

    var innerFun = innerFun(x)
    println(innerFun)

    return x + x
}

// vararg定义可变参数
fun varargFun(vararg names : String, age: Int) {
    println(names.javaClass)
    println(names.size)
}

// 在某些情况下，函数只是返回单个表达式，此时可以省略花括号在等号（=）后指定函数体即可。这种方式称之为表达式函数
fun area(x : Double, y : Double) : Double = x * y;

// 函数没有返回值定义两种形式，第一种 省略 : 类型
fun noReturnVal(x: Int, y: Int) {
    println("x = ${x}, y = ${y}")
}

// 函数没有返回值定义两种形式，第二种 使用 : Unit
fun noReturnVal2(x: Int): Unit {
    println(x)
}

fun returnFunTest(a: Int): (x : Int, y : Int) -> Int {


    fun add(x: Int, y: Int): Int {
        return x + y
    }

    return ::add


}

fun funcTest(a : Int, b : Int) : Int {
   return a * b
}

// 闭包
val print = {name: String ->
    println(name)
}

// 内部函数只能由外部函数访问，其他地方均不能访问到内部函数
fun outerFunTest() {
    var str = "hello"

    fun inner() {
        println(str)
    }
    inner();
}

// 函数参数默认值
fun defaultValue(name: String = "hello") {
    println(name)
}

fun printTest(name: String, age: Int) {
//    println("name = %name, age = %age", name, age)
    println("name = $name, age = $age")
}

fun printLen(str: String): String{

    println("这个字符串是：$str");

    return str
}

fun testClass(clazz: Class<com.me.kotlintest.geekvideo.JavaMain>) {
    println(clazz.simpleName)
}

fun testClass(clazz: KClass<KotlinMain>) {
    println(clazz.simpleName)
}