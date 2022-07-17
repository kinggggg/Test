package chapter06

import scala.beans.BeanProperty

class Person {

  var name: String = "Bob"

  // _ 表示给属性一个默认值
  var age:Int = _

  // @BeanProperty 可以自动生成符合规范的getter和setter方法
  @BeanProperty var sex: String = "男性"
}

object Person {
  def main(args: Array[String]): Unit = {
    var person = new Person()
    println(person.name)

    println(person.getSex)
  }
}
