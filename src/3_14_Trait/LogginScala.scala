package Trait3_14

/**
  * Created by Neo on 2016-08-22.
  */
trait LoggingScala {
  def info   (message:String): Unit
  def warning(message:String): Unit
  def error  (message:String): Unit
}