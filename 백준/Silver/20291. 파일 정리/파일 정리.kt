fun main() {
    val n = readln().toInt()
    val map = mutableMapOf<String, Int>()
    repeat(n) {
        val file = readln()
        val fileNm = file.substringAfterLast(".")
        map[fileNm] = map.getOrDefault(fileNm, 0) + 1
    }
    map.toSortedMap().forEach { (k, v) ->
        println("$k $v")
    }
}