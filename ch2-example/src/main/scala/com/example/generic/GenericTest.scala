package com.example.generic

/**
  * GenericTest.scala
  *
  * @author woojin
  * @since 2016, 08. 07
  */
object GenericTest extends App {
  val strValues = List("ABC", "1234", "가나다라")
  val anyValues = List("ABC", 1234, 10.2)

  printEachAnyElem(strValues)
  printEachStringElem(strValues)

  printEachAnyElem(strValues)


  def printEachAnyElem(xs: List[Any]) = xs.foreach(println(_))

  def printEachStringElem(xs: List[String]) = xs.foreach(println(_))
}
