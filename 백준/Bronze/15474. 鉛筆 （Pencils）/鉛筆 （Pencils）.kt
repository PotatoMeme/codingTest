data class Set(
    val count: Int,
    val price: Int,
)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, a, b, c, d) = readLine().split(" ").map { it.toInt() }
    val sets = listOf(
        Set(a, b),
        Set(c, d)
    )

    var minPrice = Int.MAX_VALUE
    sets.forEach { set ->
        for (i in 0..Int.MAX_VALUE) {
            if (n <= set.count * i) {
                if (minPrice > set.price * i) {
                    minPrice = set.price * i
                }
                break
            }
        }
    }
    print(minPrice)
}