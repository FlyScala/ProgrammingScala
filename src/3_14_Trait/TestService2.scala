package Trait3_14

/**
  * Created by Neo on 2016-08-22.
  */

object TestService2 {
  def main(args: Array[String]): Unit = {
    val service2 = new ServiceImportanteScala("dos") with StdoutLoggingScala {
      override def work(i: Int, j:Int): Int = {
        info(s"String work: i = $i")
        val result = super.work(i,3)
        info(s"Ending work: i = $i, result = $result")
        result
      }
    }
    (1 to 3) foreach (i => println(s"Result: ${service2.work(i,3)}"))
  }

}
