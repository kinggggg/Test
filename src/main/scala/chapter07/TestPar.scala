package chapter07

import scala.collection.parallel.CollectionConverters._

/**
 * Scala并行计算
 *
 * @author liweibo04 <liweibo04@58.com>
 * Created on 2022-07-18
 */
object TestPar {

  def main(args: Array[String]): Unit = {
    //val result1 = (0 to 100).map(_ => Thread.currentThread().getName)
    val result1 = (0 to 100).map{
      _ => Thread.currentThread().getName
    }.distinct
    println(result1)

    val result2 = (0 to 100).par.map(_ => Thread.currentThread().getName).distinct
    println(result2)

  }
}
