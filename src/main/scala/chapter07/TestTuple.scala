package chapter07

/**
 * 测试元组
 *
 * @author liweibo04 <liweibo04@58.com>
 * Created on 2022-07-18
 */
object TestTuple {

  def main(args: Array[String]): Unit = {
    // 多个无关的数据封装为一个整体,称之为元组
    val tuple: (Int, String, Boolean) = (40, "bobo", true)
    // 通过_顺序访问
    println(tuple._1)
    println(tuple._2)
    println(tuple._3)

    // 通过索引访问
    println(tuple.productElement(0))
    println(tuple.productElement(1))
    println(tuple.productElement(2))

    // 通过迭代器访问
    for(ele <- tuple.productIterator) {
      println(ele)
    }

    // Map中的键值对其实就是元组,只不过元组的元素个数为2,称之为对偶
    val map = Map("a" -> 1, "b" -> 2)
    val map1 = Map(("a", 1), ("b", 2))
    map.foreach(tuple => println(tuple._1 + " = " + tuple._2))
  }
}
