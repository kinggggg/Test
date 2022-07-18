package chapter07

object TestArray {

  def main(args: Array[String]): Unit = {
    // 数组定义
    var arr01 = new Array[Int](4);
    println(arr01.length)

    // 数组元素赋值
    arr01(3) = 10
    // 采用方法的形式给数组赋值
    arr01.update(0, 1)

    // 查看数组
    println(arr01.mkString(","))

    println("====================")

    // 遍历数组
    for(i <- arr01) {
      println(i)
    }

    println("====================")
    // 简化遍历
    def printx(ele: Int): Unit = {
      println(ele)
    }
    arr01.foreach(printx)
    // 直接传入函数. 传入函数有一个参数(x), 函数体为 {println(x)}
    arr01.foreach((x) => {println(x)})
    // 简化. 函数体只有一行代码,省略大括号
    arr01.foreach((x) => println(x))
    // 简化. 参数只有一个,并且只使用一次, 参数可以用_代替
    arr01.foreach(println(_))
    // 简化. 这种写法先记住吧
    arr01.foreach(println)

    println("====================")
    // 增加元素
    var ints: Array[Int] = arr01 :+ 5
    ints.foreach(println)

    println("====================")
    // 定义数组时,给默认值
    val arr1 = Array(1,2)




  }

}
