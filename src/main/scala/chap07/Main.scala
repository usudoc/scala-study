package chap07

object Main {

  def main(args: Array[String]): Unit = {
    var func_lib = new FuncLib()

    // 与えた引数の要素同士を入れ替える
    println("-swapArray")
    var arr = Array(1, 2, 3, 4, 5)
    println(arr.mkString(" "))
    var swap_arr = func_lib.swapArray(arr)(0, 4)
    println(arr.mkString(" "))
    println(swap_arr.mkString(" "))
    swap_arr = func_lib.swapArray(arr)(1, 3)
    println(arr.mkString(" "))
    println(swap_arr.mkString(" "))

    // startからendまでの連続した数字の文字列に","を付け足す
    println("-joinByComma")
    var str_comma = func_lib.joinByComma(1, 5)
    println(str_comma.mkString)

    // 逆順
    println("-reverse")
    var reverse_list = func_lib.reverse((1 to 5).toList)
    println(reverse_list.mkString(" "))

    // Listのすべての要素を足し合わせる
    println("-sum")
    var sum_list = func_lib.sum((1 to 5).toList)
    println(sum_list)

    // Listのすべての要素を掛け合わせる
    println("-mul")
    var mul_list = func_lib.mul((1 to 5).toList)
//    var mul_list = func_lib.mul(Nil)
    println(mul_list)

    // 自作のmkString実行
    println("-mkString")
    var str = func_lib.mkString((1 to 5).toList)(",")
    println(str)

    // 自作のmap実行
    println("-map")
    var map_result = func_lib.map((1 to 3).toList)(x => x + 1)
    println(map_result)
    assert(List(2, 3, 4) == func_lib.map(List(1, 2, 3))(x => x + 1))
    assert(List(2, 4, 6) == func_lib.map(List(1, 2, 3))(x => x * 2))
    assert(Nil == func_lib.map(List[Int]())(x => x * x))
    assert(List(0, 0, 0)  == func_lib.map(List(1, 2, 3))(x => 0))

    // 自作のfilter実行
    println("-filter")
    var filtered_list = func_lib.filter((1 to 5).toList)(x => x % 2 == 1)
    println(filtered_list)
    assert(List(2) == func_lib.filter(List(1, 2, 3))(x => x % 2 == 0))
    assert(List(1, 3) == func_lib.filter(List(1, 2, 3))(x => x % 2 == 1))
    assert(Nil == func_lib.filter(List(1, 2, 3))(x => x > 3))
    assert(List(1) == func_lib.filter(List(1))(x => x == 1))
    assert(Nil == func_lib.filter(List[Int]())(x => false))

    // 自作のfind実行
    println("-find")
    var find_val = func_lib.find((1 to 5).toList)(x => x % 2 == 1)
    println(find_val)
    assert(Some(2) == func_lib.find(List(1, 2, 3))(x => x == 2))
    assert(None == func_lib.find(List(1, 2, 3))(x => x > 3))
    assert(Some(1) == func_lib.find(List(1))(x => x == 1))
    assert(None == func_lib.find(List(1))(x => false))
    assert(None == func_lib.find(List[Int]())(x => x == 1))

    // 自作のtakeWhile実行
    println("-takeWhile")
    var tw_list = func_lib.takeWhile((1 to 5).toList)(x => x != 5)
    println(tw_list)
    assert(List(1, 2, 3) == func_lib.takeWhile(List(1, 2, 3, 4, 5))(x => x <= 3))
    assert(List(1) == func_lib.takeWhile(List(1, 2, 3, 3, 4, 5))(x => x == 1))
    assert(List(1, 2, 3, 4)  == func_lib.takeWhile(List(1, 2, 3, 4, 5))(x => x < 5))
    assert(Nil == func_lib.takeWhile(List(1, 2, 3, 3, 2, 2))(x => false))

    // 自作のcount実行
    println("-count")
    var count_val = func_lib.count((1 to 5).toList)(x => x % 2 == 0)
    println(count_val)
    assert(3 == func_lib.count(List(1, 2, 3, 3, 2, 2))(x => x == 2))
    assert(1 == func_lib.count(List(1, 2, 3, 3, 2, 2))(x => x == 1))
    assert(2 == func_lib.count(List(1, 2, 3, 3, 2, 2))(x => x == 3))
    assert(0 == func_lib.count(List(1, 2, 3, 3, 2, 2))(x => x == 5))

    // 自作のflatMap実行
    println("-flapMap")
    var flatmap_list = func_lib.flatMap((1 to 5).toList)(x => List(x))
    println(flatmap_list)
    assert(List(1, 2, 3) == func_lib.flatMap(List(1, 2, 3))(x => List(x)))
    assert(List(3, 4, 6, 8) == func_lib.flatMap(List(1, 2))(x => func_lib.map(List(3, 4))(y => x * y)))
  }
}
