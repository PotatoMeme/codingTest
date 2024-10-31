import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val testCase = readLine().toInt()
    val sb = StringBuilder()
    repeat(testCase) {
        // (1 ≤ N ≤ 10^16)
        // Int.MaxValue = 2_147_483_647
        // long.MaxValue = 9_223_372_036_854_775_807
        // n.MaxValue = 10_000_000_000_000_000
        val n = readLine().toLong()
        var result = 0L
        var left = 0L
        var right = 1_000_000_000L
        while (left <= right) {
            val mid = (left + right) / 2
            val sum = (mid * (mid + 1)) / 2
            if (sum <= n) {
                result = Math.max(mid, result)
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        sb.appendLine(result)
    }
    print(sb)
}