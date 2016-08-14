package com.usaim.hackerrank.functional

/*
 * Hackerrank
 * https://www.hackerrank.com/challenges/super-digit
 */
object SuperDigit {
  def sumOfDigit(s:String):String = s.map(_.asDigit).sum.toString
  
  def superDigit(str:String):String = if (str.length > 1) superDigit(sumOfDigit(str)) else str  

  def main(args: Array[String]) {
    //val input = io.StdIn.readLine.split(" ") toList
    //val input = "861568688536788 100000".split(" ") toList
    val input = "".split(" ") toList
    val (n,k) = (input(0) ,input(1) toLong)
    //val p = append(n,k,"")
    val p = (sumOfDigit(n).toLong * k) toString
    
    println(superDigit(p))
  }

}