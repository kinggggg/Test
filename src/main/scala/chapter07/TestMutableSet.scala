package chapter07

import scala.collection.mutable

/**
 * 可变集合 Muteble Set
 *
 * @author liweibo04 <liweibo04@58.com>
 * Created on 2022-07-18
 */
object TestMutableSet {

  def main(args: Array[String]): Unit = {

    val set = mutable.Set(1, 2, 3)
    // class scala.collection.mutable.HashSet
    println(set.getClass)
  }
}
