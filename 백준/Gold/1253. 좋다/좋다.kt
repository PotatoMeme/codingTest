import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }.sorted()
    var goodCount = 0

    for (k in 0 until n) {
        val target = list[k]
        var i = 0
        var j = n - 1

        while (i < j) {
            if (i == k) i++ 
            else if (j == k) j-- 
            else {
                val sum = list[i] + list[j]
                when {
                    sum == target -> {
                        goodCount++
                        break
                    }
                    sum < target -> i++
                    else -> j--
                }
            }
        }
    }
    print(goodCount)
}