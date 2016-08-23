package Trait3_14

/**
  * Created by Neo on 2016-08-22.
  */
trait StdoutLoggingScala extends LoggingJava {
  def info    (message:String) = println(s"INFO:    $message")
  def warning (message:String) = println(s"WARNING: $message")
  def error   (message:String) = println(s"ERROR    $message")
}
