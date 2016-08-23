//정수형 큐의 추상화 클래스
abstract class IntQueue {
  def get() : Int
  def put(x:Int)
}

//큐기능 구현
import scala.collection.mutable.ArrayBuffer
class BasicIntQueue extends IntQueue {
  private var buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) {buf += x}
}

/////실행부 q1
val q1 = new BasicIntQueue
q1.put(10)
q1.put(20)
q1.get()
q1.get()


// 더블링 트레이트 정의 ( *2 )
trait Doubling extends IntQueue {
  abstract override def put(x: Int) {super.put(2 * x)}
}

//기본 정수큐 상속 및 더블링큐 믹스
class MyQueue extends BasicIntQueue with Doubling {
}

//더블링 큐 실행테스트
val q2 = new MyQueue
q2.put(10)
q2.get()


//숫자 +1증가 트레이트 정의
trait Incrementing extends IntQueue {
  abstract override def put(x: Int): Unit = {super.put(x+1)}
}

// 음수 제거 트레이트 정의
trait Filtering extends IntQueue {
  abstract override def put(x: Int) {if (x >= 0) super.put(x)}
}

/// 기본정수큐 와 1증가, 필터링 트레이트 믹스 테스트
val q3 = (new BasicIntQueue with Incrementing with Filtering)
//q3.put(-1)
//q3.put(0)
//q3.put(1)
//q3.get()
//q3.get()


/// stack modification
// 값을 증가하고 필터링이 되었으면 값이 3개가 들어가야하나
// 필터링->숫자+1증가 순서로 진행
// trait가 stack modification 기능을 제공하는지 이해할 수 있음.


//추가 테스트
val q4 =(new BasicIntQueue with Incrementing with Doubling with Filtering)
q4.put(-10) //필터링
q4.put(0)  // 필터링 -> 더블링:0 -> 1증가:1 -> 큐삽입
q4.put(10) // 필터링 -> 더블링:20 -> 1증가:21 -> 큐삽입
q4.get() // 1
q4.get() // 21
q4.get() // 에러~ -10 필터링됨.
