package chap07

class FuncLib {

  // 配列のi番目の要素とj番目の要素を入れ替えるメソッド
  def swapArray[T] (arr: Array[T])(i: Int, j: Int): Array[T] = {
    val tmp = arr(i)
    arr(i) = arr(j)
    arr(j) = tmp
    return arr
  }

  // RangeとmkStringを使って連続した数字の文字列を返すメソッド
  def joinByComma(start: Int, end: Int): String = {
    (start to end).mkString(",")
  }

  // foldLeftを用いてListの要素を反転させるメソッド
  def reverse[T](list: List[T]): List[T] = {
    list.foldLeft(Nil: List[T])((x, y) => y :: x)
  }

  // foldRightを用いてListの全要素を足し合わせるメソッド
  def sum(list: List[Int]): Int = {
    list.foldRight(0)((x, y) => x + y)
  }

  // foldRightを用いてListの全要素をかけ合わせる&Listが空であれば1を返すメソッド
  def mul(list: List[Int]): Int = {
    list.foldRight(1)((x, y) => x * y)
  }

  // mkStringを用いずにmkStringを実装
  def mkString[T](list: List[T])(sep: String): String = list match {
    case Nil => ""
    case x::xs => xs.foldLeft(x.toString){(x, y) => x + sep + y}
  }

  // foldLeftとreverseを用いてmapメソッドを実装
  def map[T, U](list: List[T])(f: T => U): List[U] = {
    list.foldLeft(Nil: List[U]){(x, y) => f(y) :: x}.reverse
  }

  // foldLeftとreverseを用いてfilterメソッドを実装
  def filter[T](list: List[T])(f: T => Boolean): List[T] = {
    list.foldLeft(Nil: List[T]){(x, y) => if(f(y)) y :: x else x}.reverse
  }

  // foldLeftまたは再帰を用いてfindメソッドを実装
  def find[T](list: List[T])(f: T => Boolean): Option[T] = list match {
    // foldLeftを使った方法が未解決(下行はエラー)
    //    list.foldLeft(Nil: List[T])((x, y) => if(f(y) && x == Nil) List(y) else Null)
    case x :: xs if f(x) => Some(x)
    case x :: xs => find(xs)(f)
    case _ => None
  }

  // ループまたは再帰を用いてtakeWhileメソッドを実装
  def takeWhile[T](list: List[T])(f: T => Boolean): List[T] = list match{
    case x :: xs if f(x) => x :: takeWhile(xs)(f)
    case _ => Nil
  }

  // foldLeftを用いてcountメソッドを実装
  def count[T](list: List[T])(f: T => Boolean): Int = {
    list.foldLeft(0)((x, y) => if(f(y)) x + 1 else x)
  }

  // 再帰やループでflatMapメソッドを実装
  def flatMap[T, U](list: List[T])(f: T => List[U]): List[U] = {
    list match {
      case Nil => Nil
      case x::xs => f(x) ::: flatMap(xs)(f)
    }
  }
}
