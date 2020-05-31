package chap08

// 曜日のデータ型を簡単なケースクラスで定義
sealed abstract class DayOfWeek
case object Sunday extends DayOfWeek
case object Monday extends DayOfWeek
case object Tuesday extends DayOfWeek
case object Wednesday extends DayOfWeek
case object Thursday extends DayOfWeek
case object Friday extends DayOfWeek
case object Saturday extends DayOfWeek

import java.time.DayOfWeek

// 二分木を表す型TreeとBranch, Empty
sealed abstract class Tree
case class Branch(value: Int, left: Tree, right: Tree) extends Tree
case object Empty extends Tree

class CasePattern {

  // DayOfWeek型を用いてある日の次の曜日を返すメソッド
  def nextDayOfWeek(d: DayOfWeek): DayOfWeek = {
    d match {
      case Sunday => Monday
      case Monday => Tuesday
      case Tuesday => Wednesday
      case Wednesday => Thursday
      case Thursday => Friday
      case Friday => Saturday
      case Saturday => Sunday
    }
  }

  // 木構造に対して最大値を求めるmaxメソッド
  def max(tree: Tree): Int = tree match {
    case Branch(v, Empty, Empty) => v
    case Branch(v, Empty, r) =>
      val x = max(r)
      if(v > x) v else x
    case Branch(v, l, Empty) =>
      val x = max(l)
      if(v > x) v else x
    case Branch(v, l, r) =>
      val x = max(l)
      val y = max(r)
      if(x > y) {
        if(v > x) v else x
      } else {
        if (v > y) v else y
      }
  }

  // 木構造に対して最小値を求めるminメソッド
  def min(tree: Tree): Int = tree match {
    case Branch(v, Empty, Empty) => v
    case Branch(v, Empty, r) =>
      val x = min(r)
      if(v < x) v else x
    case Branch(v, l, Empty) =>
      val x = min(l)
      if(v < x) v else x
    case Branch(v, l, r) =>
      val x = min(l)
      val y = min(r)
      if(x < y) {
        if(v < x) v else x
      } else {
        if (v < y) v else y
      }
  }

  // 木構造に対して深さを求めるdepthメソッド
  def depth(tree: Tree): Int = tree match {
    case Empty => 0
    case Branch(_, l, r) =>
      val l_depth = depth(l)
      val r_depth = depth(r)
      (if(l_depth > r_depth) l_depth else r_depth) + 1
  }

  // 木構造を受け取ってInt型のListに変換するメソッド
  def toList(tree: Tree): List[Int] = tree match {
    case Empty => Nil
    case Branch(v, l, r) => toList(l) ++ List(v) ++ toList(r)
  }

  // 木構造に対して
  // 左の子孫の全ての値 <= 自分自身の値 < 右の子孫の全部の値
  // となるような木構造に変換するsortメソッド
  def sort(tree: Tree): Tree = {
    def fromList(list: List[Int]): Tree = {
      def insert(value: Int, t: Tree): Tree = t match {
        case Empty => Branch(value, Empty, Empty)
        case Branch(v, l, r) =>
          if(value <= v) Branch(v, insert(value, l), r)
          else Branch(v, l, insert(value, r))
      }
      list.foldLeft(Empty: Tree){case (t, v) => insert(v, t)}
    }
    fromList(toList(tree))
  }

}
