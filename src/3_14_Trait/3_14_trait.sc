
class ServiceImportante(name: String) {
  def work(i: Int): Int = {
    println(s"ServiceImportante: Doing important work! $i")
    i+1
  }
}

val service1 = new ServiceImportante("uno")
(1 to 3) foreach (i => println(s"Result: ${service1.work(i)}"))



trait Logging {
  def info   (message:String): Unit
  def warning(message:String): Unit
  def error  (message:String): Unit
}

trait StdoutLogging extends Logging {
  def info    (message:String) = println(s"INFO:    $message")
  def warning (message:String) = println(s"WARNING: $message")
  def error   (message:String) = println(s"ERROR    $message")
}

trait StdoutLoggin2 {
  def debug   (message:String) = println(s"DEBUG:   $message")
  def value   (message:String) = println(s"Value:   $message")
}


val service2 = new ServiceImportante("dos") with StdoutLogging with  StdoutLoggin2 {
  override def work(i: Int): Int = {
    info(s"String work: i = $i")
    val result = super.work(i)
    info(s"Ending work: i = $i, result = $result")
    debug(s"Debug")
    result
  }
}
(1 to 3) foreach (i => println(s"Result: ${service2.work(i)}"))

class LoggedServiceImportante(name: String)
  extends ServiceImportante(name) with StdoutLogging {
}