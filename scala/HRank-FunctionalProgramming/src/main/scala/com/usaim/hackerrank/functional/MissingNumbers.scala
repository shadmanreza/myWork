package com.usaim.hackerrank.functional

/*
 * HackerRank
 * https://www.hackerrank.com/challenges/missing-numbers-fp
 */

object MissingNumbers {
  def missingNumbers(l1: String, l2: String) = {
    val map1 = l1.split(" ").map(_.toInt).groupBy(_.toInt).map(a => (a._1, a._2.length))

    val map2 = l2.split(" ").map(_.toInt).groupBy(_.toInt).map(a => (a._1, a._2.length))

    val masterSet = map1.keySet ++ map2.keySet

    val res = for (a <- masterSet; if ((map2.getOrElse(a, 0) - map1.getOrElse(a, 0)) > 0)) yield a
    res.toSeq.sorted
  }

  def main(args: Array[String]) {
    /*val list1Len = scala.io.StdIn.readInt()
    val list1Str = scala.io.StdIn.readLine()*/
    val list1Len = 0
    val list1Str = "203 204 205 206 207 208 203 204 205 206"

    /*val list2Len = scala.io.StdIn.readInt()
    val list2Str = scala.io.StdIn.readLine()*/
    val list2Len = 0
    val list2Str = "203 204 204 205 206 207 205 208 203 206 205 206 204"

    println(missingNumbers(list1Str, list2Str) mkString (" "))

  }
}
