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

    println("====================")
    println("list5 = " + list5)
    // 集合初始化数据,不包含最后一个
    println("list5 init " + list5.init)
    println("list5 take(3) " + list5.take(3))
    println("list5 takeRight(3) " + list5.takeRight(3))
    // 第一个参数是size, 第二个参数是step
    val s1 = list5.sliding(2, 1)
    s1.foreach(println)

    val list6: List[Int] = List(1, 2, 3)
    // 求和
    println(list6.sum)
    // 乘积
    println(list6.product)
    // 最大值
    println(list6.max)
    // 最小值
    println(list6.min)
    // 排序
    // 按照元素大小排序
    println("按照元素大小排序: " + list6.sortBy(x => x))
    // 按照元素大小升序排序
    println("按照元素大小升序排序: " + list.sortWith((x, y) => x < y))

    // 集合计算高级函数
    val listAdvanced: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val nestedListAdvanced: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
    val wordList: List[String] = List("hello world", "hello atguigu", "hello scala")
    println("filter = " + listAdvanced.filter(x => x % 2 == 0))
    println("map = " + listAdvanced.map(x => x + 1))
    println("flat = " + nestedListAdvanced.flatten)
    // 扁平化+映射
    println("flatMap = " + wordList.flatMap(x => x.split(" ")))
    // 分组
    println(listAdvanced.groupBy(x => x % 2))
    // 归约 reduce
    println(listAdvanced.reduce((x, y) => x + y))
  }
}
