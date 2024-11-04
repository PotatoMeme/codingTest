import java.util.StringTokenizer


fun main() {
    val (n, m) = StringTokenizer(readln()).let { it.nextToken().toInt() to it.nextToken().toInt() }
    var sixMin = Int.MAX_VALUE
    var oneMin = Int.MAX_VALUE
    repeat(m) {
        StringTokenizer(readln()).also {
            sixMin = minOf(sixMin, it.nextToken().toInt())
            oneMin = minOf(oneMin, it.nextToken().toInt())
        }
    }
    val sixOneMin = oneMin * 6
    // case 1
    // sixMin >= sixOneMin
    if (sixMin >= sixOneMin) {
        print(n * oneMin)
    }
    // case 2
    // sixMin < sixOneMin
    else {
        // case 2 - 1
        val n1 = (n / 6) * sixMin
        if (sixMin > (n % 6) * oneMin) {
            print(n1 + ((n % 6) * oneMin))
        }
        // case 2 - 2
        else {
            print(n1 + sixMin)
        }
    }
}