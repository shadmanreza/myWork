package com.usaim.hackerrank.functional

/*
 * HackerRank
 * https://www.hackerrank.com/challenges/remove-duplicates
 */

object RemoveDuplicates {
  def removeDuplicates(s: String) = {
    val a = s.zipWithIndex
    a.groupBy(_._1).map(f => (f._1 , f._2.head._2)).map(f => (f._2,f._1)).toSeq.sortWith(_._1 < _._1).map(_._2)     
  }
  

  def main(args: Array[String]) {
    //val input = scala.io.StdIn.readLine()
    val input = "ccbabacc"

    //println(removeDuplicates(input,)
    println(removeDuplicates(input) mkString)

  }
}