package chap03

class Person(name: String, age: Int, private val weight: Int)
// 以下のようにクラスのフィールドをprivate[this]にするとアクセスできず、エラーとなる
// class Person(name: String, age: Int, private[this] val weight: Int)

object Person {
  def printWeight(): Unit = {
    val taro = new Person("Taro", 20, 70)
    println(taro.weight)
  }
}

