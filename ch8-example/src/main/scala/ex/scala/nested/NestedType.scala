package ex.scala.nested

import java.sql.SQLException

/**
  * NestedType.scala
  *
  * @author woojin
  * @since 2016, 10. 17
  */
object Database {

  case class ResultSet(/*...*/)

  case class Connection(/*...*/)

  case class DatabaseException(message: String, cause: Throwable) extends
    RuntimeException(message, cause)

  sealed trait Status

  case object Disconnected extends Status

  case class Connected(connection: Connection) extends Status

  case class QuerySucceeded(results: ResultSet) extends Status

  case class QueryFailed(e: DatabaseException) extends Status



}

class Database {
  import Database._

  sealed trait MyQuery
  case object NoQuery extends MyQuery
  case class SelectQuery(query: String) extends MyQuery
  case class UpdateQuery(query: String) extends MyQuery

  def foo(): MyQuery = {
    NoQuery
  }

  def connect(server: String): Status = {
    println(s"connected: $server")

    new Connected(new Connection)
  }

  def disconnect(): Status = {
    println("Disconeted...")
    Disconnected
  }

  def query(query: String): Status = {
    println("querying...")
    if (query.contains("SELECT")) {
      new QuerySucceeded(new ResultSet)
    }
    else {
      new QueryFailed(new DatabaseException("test", new UnsupportedOperationException("can't use 'get'")))
    }
  }
}
