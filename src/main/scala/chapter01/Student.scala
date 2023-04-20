package chapter01

class Student(name: String, age: Int) {

  def printInf(): Unit = {
    println(name + " " + age + " " + Student.school);
  }
}

// 引入伴生对象
object Student {

  val school: String = "atguigu"
}
