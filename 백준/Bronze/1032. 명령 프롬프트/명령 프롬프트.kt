fun main() {
    val n = readln().toInt()
    val chars = readln().toCharArray()
    val length = chars.size
    repeat(n - 1) {
        val line = readln()
        for (i in 0 until length) {
            if (chars[i] == '?') {
                continue
            }
            if (line[i] != chars[i]) {
                chars[i] = '?'
            }
        }
    }
    print(chars.joinToString(""))
}