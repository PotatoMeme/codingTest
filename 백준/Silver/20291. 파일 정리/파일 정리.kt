fun main() {
    val n = readln().toInt()
    val map = mutableMapOf<String, Int>()
    repeat(n) {
        val file = readln()
        val fileNm = file.substringAfterLast(".")
        map[fileNm] = map.getOrDefault(fileNm, 0) + 1
    }
    val sb = StringBuilder()
    map.map { "${it.key} ${it.value}" }.sorted().forEach { sb.appendLine(it) }
    print(sb)
}