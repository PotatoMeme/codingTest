fun main() {
    val n = readln().toInt()
    val sb = StringBuilder().apply {
        repeat(n) {
            append(" ".repeat(it)).appendLine("*".repeat(n - it))
        }
    }
    print(sb)
}