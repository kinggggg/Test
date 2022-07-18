package chapter07

import scala.collection.mutable

/**
 * 测试可变Map
 *
 * @author liweibo04 <liweibo04@58.com>
 * Created on 2022-07-18
 */
object TestMutableMap {

  def main(args: Array[String]): Unit = {

    val map = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    println(map)
    // class scala.collection.mutable.HashMap
    println(map.getClass)

  }
}
