package com.usaim.hackerrank.functional

/*
 * Hackerrank
 * https://www.hackerrank.com/challenges/filter-elements
 */
object FilterElements {

  def process(a:List[Int], b:List[Int]) = {
    val rep = a(1)
    val dis = b.distinct
    val countMap = b groupBy(x => x) mapValues(_.size)
    //val result = for (e <- dis) yield (if (countMap.getOrElse(e, -1) == rep) e else 0)
    val result = for {
      e <- dis
      if (countMap.getOrElse(e, -1) >= rep)
    } yield e
      
    println( if (result isEmpty) "-1" else result mkString(" "))
  }
  
  def main(args: Array[String]) {
    //val num_test_case = readInt
    val num_test_case = 1
    
    for (e <- 1 to num_test_case) {
      //val test_parms = readLine split(" ") map(_.toInt) toList
      val test_parms = List(9,2)
      
      //val test_list = readLine split(" ") map(_.toInt) toList
      val test_list = "4 5 2 5 4 3 1 3 4" split(" ") map(_.toInt) toList
      
      process(test_parms,test_list)
    }
  }

}