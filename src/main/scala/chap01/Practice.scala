package chap01

class Practice {
  // if文
  def if_formula(): Unit = {
    var age: Int = 5
    var isSchoolStarted: Boolean = false
    if (1 <= age && age <= 6 && !isSchoolStarted) {
      println("Toddler")
      //    println("幼児です")
    } else {
      println("Not toddler")
    }
  }

  //  while
  def loopFrom0To8(): Unit = {
    var i = 0
    do {
      print(i)
      i = i + 1
    } while(i < 10)
  }

  //  for
  def triangle(): Unit = {
    for(a <- 1 to 1000; b <- 1 to 1000; c <- 1 to 1000 if a * a == b * b + c * c) {
      println(a, b, c)
    }
  }

  // match
  def randomString(): Unit = {
    for(i <- 1 until 10){
      var str_list = new scala.util.Random(new java.security.SecureRandom()).alphanumeric.take(5).toList
      var str_first = str_list.head
      str_list match {
        case str_first :: b :: c :: d :: e :: _ =>
          println(str_first, b, c, d, str_first)
        case _ =>
          println("error")
      }
    }

//    * 解答例 *
//    for(i <- 1 to 10) {
//      val s = new scala.util.Random(new java.security.SecureRandom()).alphanumeric.take(5).toList match {
//        case List(a,b,c,d,_) => List(a,b,c,d,a).mkString
//      }
//      println(s)
//    }
  }
}
