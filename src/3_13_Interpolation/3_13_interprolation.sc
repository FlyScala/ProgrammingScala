/* 단순 참조
 */
//val name = "Buck Trends"
//println(s"Hello, $name")

//val number = 3.14
//println(s"Hello, $number")

//println("$") // $출력
println(s"$")  // s를 붙이면 $는 인터폴레이선 처리를 위해 에러가 발생
//println(s"$$")  // $를 사용하기 위해서는 $$를 사용해야한다.
//println(f"$$")  // $를 사용하기 위해서는 $$를 사용해야한다.

/* s 와 f의 차이 */
println(s"$number%.4f")
// 자바 println 의 인터폴레이션만 처리.

//println(f"$number%.4f")
// printf 형식화를 위해 자바의 Formatter를 사용.
//printf(f"$number%.4f\n") // printf로도 사용가능



//val fNum = f"$number%.4f"
//println(s"==> $fNum")


//val gross = 100000F
//val net = 64000F
//val percent = (net / gross * 100)
//println(f"$$${gross}%.2f vs. $$${net}%.2f or ${percent}%.1f%%")
//println(f"$$$gross%.2f vs. $$$net%.2f or $percent%.1f%%")


//val i = 200

//f"${i}%.2f" // i 는  Int형이나 암시적 변환이 적용되어 float형으로 포맷처

//val d = 100.22

//f"${d}%2d"  // Double을 Int로 표현하려고 시도해서 컴파일 오류

//val s = "%02d: name = %s".format(5, "Dean Wampler")


//val name = "Dean Wampler"
//
//s"123\n$name\n456"
//
//raw"123\n$name\n456"
