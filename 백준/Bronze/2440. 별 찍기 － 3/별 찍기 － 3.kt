fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val n = readLine().toInt()
    repeat(n) {
        sb.appendLine("*".repeat(n-it))
    }
    print(sb)
}