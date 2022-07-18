package chapter01

/**
 * object: 声明一个单例对象(伴生对象)
 */
object HelloWorld {
  def main(args: Array[String]): Unit = {
    /**
     * main 方法: 从外部可以直接调用执行的方法
     * def  方法名称(参数名称: 参数类型): 返回值类型 = { 方法体 }
     */
    println("Hello World")
    System.out.println("Hello World")

    // 5. 空类型
    // 5.1 空值Unit
    def m1(): Unit = {
      println("Hello World");
    }
    val a: Unit = m1()
    println("a: " + a)
    // 5.2 空引用Null
    //val n: Int = null // 值类型不能被赋值为null
    // 5.3 Nothing
    def m2_1(n: Int): Nothing = {
      // 返回值是Nothing的话, 必须抛出异常
        throw new NullPointerException
    }
    // 返回值的类型是Int, 因为Nothing类型是所有子类型的子类
    def m2(n: Int): Int = {
      if(n == 1) {
        throw new NullPointerException
      }else {
        return n
      }
    }
    val b = m2(0)
    println(b)

    println("============================")
    // 函数作为参数传递
    def f1(f: (Int, Int) => Int): Int = {
      f(2, 4)
    }
    def add(a: Int, b: Int): Int = a + b
    println(f1(add))
    println(f1(add _))

    println("============================")
    def f = () => {
      println("f...")
      10
    }
    // 将f()的执行结果作为参数传递给foo1
    foo1(f())
    // 将f自身作为参数传递给foo2
    foo2(f())
    // 传值函数
    def foo1(a: Int): Unit = {
      println("foo1")
      println(a)
    }
    // 传名函数
    def foo2(a: =>Int): Unit = {
      println("foo2")
      println(a)
    }
  }
}
