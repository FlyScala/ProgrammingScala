package ex.scala.nested

import ex.scala.nested.Database.{MyQuery, SelectQuery, _}

/**
  * AppMain.scala
  *
  * @author woojin
  * @since 2016, 10. 17
  */
object AppMain extends App {
  println("Test Nested Type")
  val db = new Database

  db.connect("127.0.0.1")

  db.query("SELECT 1")

  db.query("GET 1") match {
    case QuerySucceeded(r) => println("Success Querying!")
    case QueryFailed(e) => println("Failed to Query: ", e)
  }

  val resultVal: MyQuery = db.foo()


  db.disconnect()

  println("Case Object hash equal")

  case object MyObj

  println(MyObj.hashCode)
  println("MyObj".hashCode)

  println("equal result: " +  (MyObj.hashCode == "MyObj".hashCode))
}
