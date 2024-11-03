import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

val map = mutableMapOf(
    "STRAWBERRY" to 0, "BANANA" to 0, "LIME" to 0, "PLUM" to 0
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    repeat(n) {
        val (str, num) = StringTokenizer(readLine()).let {
            it.nextToken() to it.nextToken().toInt()
        }
        map[str] = map[str]!! + num
    }
    if (map.any { it.value == 5 })
        print("YES")
    else
        print("NO")
}