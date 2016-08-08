package com.example.pkg


// 1. 패키지 선언 방식
import java.util.function._     // '_'는 자바의 '*'와 같은 와일드카드이다.
import java.io.File   // 자바와 같이 개별 스칼라 클래스 및 자바의 타입 선언 가능하다.
import java.io.File._ // 자바의 File 클래스 내 정적 메서드, 필드를 임포트 한다.
import scala.collection
import java.util.{Map, HashMap} // 패키지 내 특정 클래스 또는 클래스 내 정적 메서드,필드를 선택해서 임포틀 할 수 있다.
import com.example.common._

/**
  * PkgExample.scala
  *
  * @author woojin
  * @since 2016, 08. 07
  */
object PkgExample extends App {

  def testJavaFunc() = {
    //    val myConsumer: Consumer[Int] = (n: Int) => System.out.println("number: " + n)
    //    val myPredicate: Predicate[Int] = (n: Int) => n > 4
    //    val javaLists = util.Arrays.asList(1,2,3,4)

    //    javaLists.forEach(myConsumer)
  }

  testJavaFunc()

  def scalaPkg() = {
    println(AnyRef)
  }

  scalaPkg()

  def stuffWithBigInteger() = {
    import java.math.BigInteger.{TEN, ZERO => JAVAZERO, ONE => _}

    // println( "ONE: "+ONE )     // ONE is effectively undefined
    println("TEN: " + TEN)
    println("ZERO: " + JAVAZERO)
  }

  //  stuffWithBigInteger()


  // package object
  def runGame() = {
    val outcomes1 = List((Player("Foo"), new Scissors), (Player("Bar"), new Rock), (Player("Amy"), new Scissors))
    println(takeWinner(outcomes1))

    val outcomes2 = List((Player("Foo"), new Scissors), (Player("Bar"), new Rock), (Player("Amy"), new Rock))
    println(takeWinner(outcomes2))

    println(takeOnlyWinner(outcomes1).getOrElse(Player("None")))
    println(takeOnlyWinner(outcomes2).getOrElse(Player("None")))
  }

  runGame()

}
