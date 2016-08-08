package com.example

import com.example.types._
import java.io.File
import java.io.File.listRoots

object Ch2Example extends App {
//  testFileClassImport()
//  stuffWithBigInteger()

  println(new StringBulkReader("Hello Scala!").read)
  println(new FileBulkReader(new File("src/main/scala/com/example/types/BulkReader.scala")).read)

  def testFileClassImport() {
    listRoots().map(println(_))
  }

  def stuffWithBigInteger() = {
    import java.math.BigInteger.{TEN, ZERO => JAVA_ZERO, ONE => _}

    // println(ONE)
    println(TEN)
    println(JAVA_ZERO)

  }

  def testParallelStreamInJava(): Unit = {
    val nums = 0 to 1000
    nums.toStream
  }

}
