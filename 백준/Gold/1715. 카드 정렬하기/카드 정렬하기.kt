import java.util.PriorityQueue

fun main() {
    val n = readLine()!!.toInt()
    val pq = PriorityQueue<Int>()

    repeat(n) {
        pq.add(readLine()!!.toInt())
    }

    var totalComparisons = 0

    while (pq.size > 1) {
        val first = pq.poll()
        val second = pq.poll()
        val sum = first + second

        totalComparisons += sum
        pq.add(sum)
    }

    println(totalComparisons)
}