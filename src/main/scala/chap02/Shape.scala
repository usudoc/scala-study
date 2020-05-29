package chap02

abstract class Shape {
  def area: Double
}

class Rectangle(val w: Double, val h: Double) extends Shape {
  override def area(): Double = {
    w * h
  }
}

class Circle(val r: Double) extends Shape {
  override def area(): Double = {
    r * r * math.Pi
  }

}