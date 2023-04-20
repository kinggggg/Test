package chapter06.extend

class Person {

  val name: String = "Person"

  def hello(): Unit = {
    println("hello person")
  }
}

class Teacher extends Person {
  override val name: String = "Teacher"

  override def hello(): Unit = {
    println("hello teacher")
  }
}

object Test {
  def main(args: Array[String]): Unit = {
    var teacher: Teacher = new Teacher()
    println(teacher.name)
    teacher.hello()

    var teacher1: Person = new Person
    println(teacher1.name)
    teacher1.hello()
  }
}
