package chapter04

import scala.util.control.Breaks
import scala.util.control.Breaks.{break, breakable}

object FlowTest {

  def main(args: Array[String]): Unit = {
    println()
    printf("=========== %s ===============", "for循环")
    println()
    // 前后闭合
    for (i <- 1 to 3) {
      println(i)
    }
    println()
    // 前闭后开
    for (i <- 1 until 3) {
      println(i)
    }
    println()
    // 循环守卫
    for (i <- 1 to 3 if i != 2) {
      println(i)
    }
    println()
    // 循环步长
    for (i <- 1 to 3 by 2) {
      println(i)
    }
    println()
    // 循环中断
    // 1. 通过异常方式退出循环
    try {
      for (elem <- 1 to 10) {
        println(elem)
        if (elem == 5) throw new RuntimeException
      }
    }catch {
      case e =>
    }
    println("正常结束循环")
    println()
    // 2. 通过Scala自带的函数
    Breaks.breakable(
      for (elem <- 1 to 10) {
        println(elem)
        if (elem == 5) Breaks.break()
      }
    )
    println()
    // 3. 对break进行省略
    breakable {
      for (elem <- 1 to 10) {
        println(elem)
        if (elem == 5) break
      }
    }
    println()


  }

}
