package com.usaim.hackerrank.functional

import scala.util.Random

object SumOfPowers {
  def myPower(num: Int, pow: Int): Int = math.pow(num.toDouble, pow.toDouble) toInt
  
  def CalculateSum (x: Stream[Int], l: List[Int]) = {    
    
  }
    
  def numberOfWays(X: Int, N: Int) = {    
    var sum = 0
    val rand = Random
    
    while (sum <= X) {
      
    }
    
  }

  def main(args: Array[String]) {    
    //val input1 = readInt()    
    //val input2 = readInt()
    
    val input1 = 100
    val input2 = 2
    
    println(numberOfWays(input1, input2))
  }
}