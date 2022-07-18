package chapter07

/**
 * 不可变Map
 *
 * @author liweibo04 <liweibo04@58.com>
 * Created on 2022-07-18
 */
object TestMap {

  def main(args: Array[String]): Unit = {
    // 创建不可见集合Map
    val map = Map("a" -> 1, "b" -> 2, "c" -> 3)
    println(map)

    // 遍历Map
    for(ele <- map.keys) {
      println(ele + " = " + map.get(ele).get)
    }

    // 循环打印
    // (a,1)
    // (b,2)
    // (c,3)
    map.foreach((kv) => println(kv))

  }

}
