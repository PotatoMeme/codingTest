import kotlin.math.absoluteValue

fun main() = with(System.`in`.bufferedReader()) {
    // (|N-M|)
    print(readLine().split(" ").map { it.toLong() }.let { (n, m) ->
        (n-m).absoluteValue
    })
}