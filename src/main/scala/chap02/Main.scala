package chap02

object Main {

  def main(args: Array[String]): Unit = {
    val p = new Point3D(10, 20, 30)
    println(p.x)
    println(p.y)
    println(p.z)

    var shape: Shape = new Rectangle(10.0, 20.0)
    println(shape.area)
    shape = new Circle(2.0)
    println(shape.area)
  }
}
