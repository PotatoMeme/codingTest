fun main() = with(System.`in`.bufferedReader()) {
    val arr: Array<String> = Array(readLine().toInt()) {
        readLine()
    }
    arr.sortWith { a, b ->
        if (a.length > b.length)
            1
        else if (a.length < b.length)
            -1
        else if (a.sumOf { it.digitToIntOrNull() ?: 0 } > b.sumOf { it.digitToIntOrNull() ?: 0 })
            1
        else if (a.sumOf { it.digitToIntOrNull() ?: 0 } < b.sumOf { it.digitToIntOrNull() ?: 0 })
            -1
        else
            a.compareTo(b)
    }
    print(buildString {
        arr.forEach {
            appendLine(it)
        }
    })
}