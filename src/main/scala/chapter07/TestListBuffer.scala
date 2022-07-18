package chapter07

import scala.collection.mutable.ListBuffer

/**
 * 可变ListBuffer测试
 *
 * @author liweibo04 <liweibo04@58.com>
 * Created on 2022-07-18
 */
object TestListBuffer {

  def main(args: Array[String]): Unit = {
    val buffer0 = new ListBuffer[String]()
    println(buffer0)
    println(buffer0.getClass)

    println("====================")
    val buffer = ListBuffer(1, 2)
    println(buffer)

    println("====================")
    buffer += 5
    println(buffer)
    buffer.append(6)
    println(buffer)
    buffer.insert(0, 7)
    println(buffer)

    println("====================")
    // 删除数据
    buffer-=(5)
    println(buffer)


  }
}
