package com.usaim.hackerrank.functional

import scala.io.Source

/*
 * HackerRank
 * https://www.hackerrank.com/challenges/rotate-string
 */

object RotateString {
  def rotateString(str: String) = {
    for (i <- 1 to str.length()) yield {
      s"${str.drop(i)}${str.take(i)}"
    }
  }
    
  def main(args: Array[String]) {
    //val numOfTestCases = scala.io.StdIn.readLine().toInt
    val numOfTestCases = 1
    val testString = "abcde"
    for (counter <- 1 to numOfTestCases) {
      //rotateString(scala.io.StdIn.readLine())
      println (rotateString(testString) mkString(" "))
    }

  }
}