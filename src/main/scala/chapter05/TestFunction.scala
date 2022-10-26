package chapter05

object TestFunction {

  def main(args: Array[String]): Unit = {
    var f1 = foo
    // 在被调用函数的后面加上 _ 表明把整个函数体赋值给变量
    var f2 = foo _
    var f3: () => Int = foo _
    // 如果明确了变量的类型, _ 可以省略
    var f4: () => Int = foo
  }

  def foo(): Int = {
    print("foo")
    1
  }

}