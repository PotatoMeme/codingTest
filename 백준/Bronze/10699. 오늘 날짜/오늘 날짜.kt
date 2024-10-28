import java.util.Date

fun main() {
    val curDate : Date = Date()
    // "YYYY-MM-DD" 형식으로 출력
    print(String.format("%tF", curDate))
}