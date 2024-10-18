fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var count = 0
    for (i in 0 .. 6) {
        if (n and (1 shl i) > 0) count++
    }
    print(count)
}