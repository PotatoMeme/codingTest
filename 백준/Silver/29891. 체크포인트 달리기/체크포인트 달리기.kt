fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val (_under, over) = IntArray(n) { readLine().toInt() }.sorted().partition { it < 0 }
    val under = _under.map { -it }.reversed()

    var result = 0L
    var count = 0
    for (i in over.indices) {
        count++
        if (count == k) {
            count = 0
            result += over[i] * 2
        }
    }
    if (count != 0) result += over.last() * 2
    count = 0
    for (i in under.indices) {
        count++
        if (count == k) {
            count = 0
            result += under[i] * 2
        }
    }
    if (count != 0) result += under.last() * 2
    print(result)
}