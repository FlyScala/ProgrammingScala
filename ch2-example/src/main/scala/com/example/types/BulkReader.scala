package com.example.types

import java.io.File

/**
  * BulkReader.scala
  *
  * @author woojin
  * @since 2016, 08. 05
  */
abstract class BulkReader {
  type In
  val source: In
  def read: String
}

class StringBulkReader(val source: String) extends BulkReader {
  override type In = String

  override def read: String = source
}

class FileBulkReader(val source: File) extends BulkReader {
  override type In = File

  override def read: String = {
    // 일부러 여기서 import 해 봄
    import java.io.FileInputStream
    import java.io.BufferedInputStream

    val in = new BufferedInputStream(new FileInputStream(source))
    val numBytes = in.available()
    val bytes = new Array[Byte](numBytes)
    in.read(bytes, 0, numBytes)
    new String(bytes)
  }

  def pkgScopeCheck = {

  }
}


