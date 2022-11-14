package chapter05

import java.util.Date

/**
 * 函数简化原则:
 * 1. return可以省略, Scala会使用函数体的最后一行代码作为返回值
 * 2. 如果函数体只有一行代码, 可以省略花括号
 * 3. 返回值类型如果能够推断出来, 那么可以省略(:和返回值类型一起省略)
 * 4. 如果有return, 则不能省略返回值类型, 必须指定
 * 5. 如果函数明确声明Unit, 那么即使函数体中使用return关键字也不起作用
 * 6. Scala如果期望是无返回值类型, 可以省略等号
 * 7. 如果函数无参, 但是声明了参数列表, 那么调用时, 小括号, 可加可不加
 * 8. 如果函数没有参数列表, 那么小括号可以省略, 调用时小括号必须省略
 * 9. 如果不关心名称, 只关心逻辑, 那么函数名(def)可以省略
 */
object TestFunction {

  def main(args: Array[String]): Unit = {
    val date = new Date()
    println(date)
    println()
    // 函数没有重载和重写的概念, 程序报错


    printf("=========== %s ===============", "函数赋值为变量")
    println()
    println("*******************1")
    // 将函数赋值给一个变量
    var f1 = foo
    println(f1)
    println("*******************2")
    // 在被调用函数的后面加上 _ 表明把整个函数体赋值给变量
    var f2 = foo _
    println(f2)
    println("*******************3")
    var f3: () => Int = foo _
    println(f3)
    println("*******************4")
    // 如果明确了变量的类型, _ 可以省略
    var f4: () => Int = foo
    println(f4)

    printf("=========== %s ===============", "把代码传递过去")
    println()
    def f = ()=>{
      println("f...")
      10
    }
    foo2(f())

    printf("=========== %s ===============", "Scala如果期望是无返回值类型, 可以省略等号")
    def f6() {
      "hanshu6"
    }
  }

  def foo(): Int = {
    println("foo")
    1
  }

  def foo2(a: =>Int):Unit = {//注意这里变量 a 没有小括号了
    println(a)
    println(a)
  }

}
