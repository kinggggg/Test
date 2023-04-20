package chapter07

import scala.collection.mutable.ArrayBuffer

/**
 * 可变数组
 */
object TestArrayBuffer {

  def main(args: Array[String]): Unit = {
    // 创建并初始化
    var arr01 =  ArrayBuffer[Any](1, 2, 3)
    arr01.foreach(println)
    println("====================")

    // 追加元素
    arr01 += 4
    arr01.foreach(println)
    println(arr01.hashCode())

    println("====================")
    // 追加元素. 数组的末尾依次追加5和6
    arr01.append(5, 6)
    arr01.foreach(println)

    println("====================")
    // 向位置为0的位置插入元素7
    arr01.insert(0, 7)
    arr01.foreach(println)
    print(arr01.hashCode())

    println("====================")
    // 修改第2个元素
    arr01(1) = 9
    arr01.foreach(println)


  }
}
