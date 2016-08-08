package com.example

package object common {

  case class Player(name: String)

  trait Shapes {
    def code: String

    // 상속받는 케이스 클래스의 멤버 접근을 위해서 이렇게 여기서 선언이 맞나?
    def isBeat(other: Shapes): Boolean
  }

  case class Rock(code: String = "R") extends Shapes {
    override def isBeat(other: Shapes): Boolean = if (other.code == "S") true else false
  }

  case class Scissors(code: String = "S") extends Shapes {
    override def isBeat(other: Shapes): Boolean = if (other.code == "P") true else false
  }

  case class Paper(code: String = "P") extends Shapes {
    override def isBeat(other: Shapes): Boolean = if (other.code == "R") true else false
  }

  def isInvalid(outcomes: List[(Player, Shapes)]): Boolean = outcomes.map(_._2).groupBy(_.code).toList.length == 3

  def getWinnerShapes(candidates: List[Shapes]): Shapes = {
    val s1 = candidates.head
    val s2 = candidates(1)
    if (s1.isBeat(s2)) s1 else s2
  }

  def takeWinner(outcomes: List[(Player, Shapes)]): List[Player] = {
    if (isInvalid(outcomes)) List.empty
    else {
      val candidates = outcomes.groupBy(_._2)
      val winner = getWinnerShapes(candidates.keySet.toList)
      candidates.filter(_._1 == winner).values.flatMap(_.map(_._1)).toList
    }
  }

  def takeOnlyWinner(outcomes: List[(Player, Shapes)]): Option[Player] = {
    val winners = takeWinner(outcomes)
    if (winners.length > 1) Option.empty
    else Some {
      winners.head
    }
  }
}
