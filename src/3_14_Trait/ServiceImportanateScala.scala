package Trait3_14

/**
  * Created by Neo on 2016-08-22.
  */
class ServiceImportanteScala(name: String) {
  def work(i: Int, j: Int): Int = {
    println(s"ServiceImportante: Doing important work! $i")
    i+1
  }
}
