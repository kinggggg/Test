package chapter07

/**
 * Scala 不可变List 测试
 */
object TestList {

  def main(args: Array[String]): Unit = {

    // 创建一个集合, 并初始化
    val list: List[Int] = List(1, 2, 3, 4, 3)
    println("list = " + list)

    println("====================")

    // 空集合 Nil
    val list5 = 1::2::3::4::Nil
    // List(1, 2, 3, 4)
    println("list5 = " + list5)

    println("====================")
    // list增加数据. ::的运算规则从右到左. list中依次增加5, 6和7元素
    val list1 = 7::6::5::list
    println("list1 = " + list1)

    println("====================")
    val list3 = List(8, 9)
    println("list3 = " + list3)
    // 合并两个集合
    val list4 = list3:::list1
    println("list4 = " + list4)

    println("====================")
    // 遍历集合
    list4.foreach(println)

    println("====================")
    // 获取指定的数据
    println(list4(1))

  }
}
