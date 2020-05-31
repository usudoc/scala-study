package chap08

import java.time.DayOfWeek

object Main {

  def main(args: Array[String]): Unit = {
    var case_pattern = new CasePattern()

    // ある日の次の曜日を表示
    println("-nextDayOfWeek")
    var next_day = case_pattern.nextDayOfWeek(Sunday)
    println(next_day)
    next_day = case_pattern.nextDayOfWeek(Thursday)
    println(next_day)

    // 木構造に対して最大値を求める
    println("-max")
    var max_val = case_pattern.max(Branch(1, Branch(2, Empty, Empty), Branch(3, Empty, Empty)))
    println(max_val)

    // 木構造に対して最小値を求める
    println("-min")
    var min_val = case_pattern.min(Branch(1, Branch(2, Empty, Empty), Branch(3, Empty, Empty)))
    println(min_val)

    // 木構造に対して深さを求める
    println("-depth")
    var depth_val = case_pattern.depth(Branch(1, Branch(2, Empty, Empty), Branch(3, Empty, Empty)))
    println(depth_val)

    // 値の大小関係を元に木構造の構成を変換する
    println("-sort")
    var sorted_tree = case_pattern.sort(Branch(1, Branch(2, Empty, Empty), Branch(3, Empty, Empty)))
    println(sorted_tree)
  }
}