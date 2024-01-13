package chapter01

object HelloScala {
  def main(args: Array[String]): Unit = {
    println("Hello World")
    println(null)
    println("-------")
    // 空指针异常
    //println(null.toString)
    // 将Scala null值赋值给一个变量
    var a: String = null
    println(a)
    // 将Scala null值赋值给一个Long类型变量
    //var b: Long = null
    //println(b)


  }
}
