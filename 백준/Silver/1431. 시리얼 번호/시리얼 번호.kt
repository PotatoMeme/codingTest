import java.util.Arrays
fun main() = with(System.`in`.bufferedReader()) {
    val arr: Array<String> = Array(readLine().toInt()) {
        readLine()
    }
    Arrays.sort(arr, compareBy<String> {
        it.length
    }.thenBy {
        it.sumOf { it.digitToIntOrNull() ?: 0 }
    }.thenBy {
        it
    })
    print(buildString {
        arr.forEach {
            appendLine(it)
        }
    })
}