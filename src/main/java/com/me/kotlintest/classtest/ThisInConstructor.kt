package com.me.kotlintest.classtest

/**
 * this在构造器中的使用
 * @author: weibo_li
 * @since: 2018-11-26 下午4:34
 */
class ThisInConstructor {

    var foo : Int

    constructor() {
        val foo = 0

        /**
         * 使用this代表正在初始化的对象
         * 局部变量和属性重名的话，必须使用this来访问属性
         */
        this.foo = 6;
    }
}

/**
 * 返回this
 */
class ReturnThis {
    var age : Int = 0

    fun grow() : ReturnThis{
        age++
        return this;
    }
}

class Cat {
    fun run () {
        println("Cat.run")
    }

    fun eat(someThing : String) {
        println("Cat.eat ${someThing}")
    }
}

/**
 * 定义中缀方法练习
 */
class ApplePack(weight : Double) {

    var weight = weight

    override fun toString(): String {
        return "AppPack[weight=${this.weight}]"
    }

}
class Apple(weight: Double) {

    var weight = weight

    override fun toString(): String {
        return "Apple[weight=${weight}]"
    }

    //定义中缀方法 infix修饰
    infix fun add(other : Apple) : ApplePack {
        return ApplePack(this.weight + other.weight)
    }

    //定义中缀方法 infix修饰
    infix fun drop(other: Apple) : Apple {
        return Apple(this.weight - other.weight)
    }

}

/**
 * componentN()方法与解构
 */
class User3(name : String, pass : String, age : Int) {
    var name = name;

    var pass = pass;

    var age = age;

    operator fun component1() : String {
        return this.name
    }

    operator fun component2() : String {
        return this.pass
    }

    operator fun component3() : Int {
        return this.age
    }
}

// 定义一个数据类
data class Result(val result : Int, val status : String)

fun factorial(n : Int) : Result {
    if(n == 1) {
        return Result(1, "成功")
    }else if( n > 1) {
        return Result(factorial(n - 1).result * n, "成功")
    }else {
        return Result(-1, "参数必须大于0")
    }
}

fun main(args: Array<String>) {
    println(ThisInConstructor().foo)

    var rt : ReturnThis = ReturnThis()
    rt.grow()
            .grow()
            .grow()
    println(rt.age)

    var rn : (Cat) -> Unit = Cat::run
    val c = Cat()
    rn(c)
    var et = Cat::eat
    et(c, "hello")

    var apple1 = Apple(10.0)
    var apple2 = Apple(20.0)
    println(apple1 add apple2)
    println(apple1 drop apple2)

    var user3 : User3
    user3 = User3("zhangsan", "111111", 18)
    // 全部解构
    var (name, pass, age) = user3
    println("name : ${name}, pass : ${pass}, age : ${age}")
    // fixme 部分解构 编译报错
    /*var (_, pass2, age2) = user3
    println("pass2 : ${pass2}, age : ${age2}")*/

    var (rt1, status) = factorial(6)
    println("rt : ${rt1}, status : ${status}")


}