package chapter07

/**
 * 不可变Set
 *
 * @author liweibo04 <liweibo04@58.com>
 * Created on 2022-07-18
 */
object SetTest {

  def main(args: Array[String]): Unit = {
    val set = Set(1, 2, 3)
    println(set)

    // 数据不可重复
    val set1 = Set(1, 1, 2, 3)
    println(set1)

    // 遍历
    for(ele <- set1) {
      println(ele)
    }
  }
}
