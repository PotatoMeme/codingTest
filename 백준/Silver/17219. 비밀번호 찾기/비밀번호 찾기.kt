import java.io.BufferedReader
import java.io.InputStreamReader
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<String, String>()
    repeat(n) {
        readLine().split(" ").let { (site, pwd) ->
            map[site] = pwd
        }
    }
    val sb = StringBuilder()
    repeat(m) {
        sb.appendLine(map[readLine()])
    }
    print(sb)
}