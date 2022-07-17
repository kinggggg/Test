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

  // 1. 在伴生对象中定义的属性 address 类似Java中的静态属性
  // 2. 反编译后 address 属性是伴生对象的静态属性
  // 3. 因此可以通过类名直接访问
  var address: String = "北京"

  def main(args: Array[String]): Unit = {

    var person = new Person()
    println(person.name)

    println(person.getSex)

    println(Person.address)
  }
}
