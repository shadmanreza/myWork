package com.usaim.hackerrank.functional

object StringCompress {
  
  def compress(a:List[(Char,Int)], x:(Char,Int)):List[(Char,Int)] = a match {          
    case head::tail =>
      if(head._1 == x._1) (head._1,head._2 + 1)::tail else x::head::tail
    case Nil =>
      x::Nil
  }
  
  def main(args: Array[String]) {
    //val input = io.Source.stdin.getLines.toList
    //val msg = input(0)
    val msg = "aaabaaaaccaaaaba"
    val result = msg
      .map(x => (x,1))
      .toList
      .foldLeft(List[(Char,Int)]())((a,x:(Char,Int)) => compress(a, x))
      .reverse
    //println(result)
    result.foreach(f => if(f._2 != 1) print(f._1.toString + f._2.toString()) else print(f._1))
  }
}