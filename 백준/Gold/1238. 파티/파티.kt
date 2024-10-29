import java.util.*
import kotlin.collections.ArrayList


fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, x) = StringTokenizer(readLine()).let {
        Triple(it.nextToken().toInt(), it.nextToken().toInt(), it.nextToken().toInt())
    }

    val adjArr = Array(2) { Array(n) { ArrayList<Pair<Int, Int>>() } }
    repeat(m) {
        val (start, end, weight) = StringTokenizer(readLine()).let {
            Triple(it.nextToken().toInt(), it.nextToken().toInt(), it.nextToken().toInt())
        }
        adjArr[0][end - 1].add(Pair(start - 1, weight))
        adjArr[1][start - 1].add(Pair(end - 1, weight))
    }

    val distArr = Array(2) { Array(n) { Int.MAX_VALUE } }
    val visitedArr = Array(2) { Array(n) { false } }

    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    repeat(2) { times ->
        distArr[times][x - 1] = 0
        pq.add(Pair(x - 1, 0))
        while (pq.isNotEmpty()) {
            val (node, dist) = pq.poll()!!
            if (visitedArr[times][node]) continue
            visitedArr[times][node] = true
            adjArr[times][node].forEach { (nextNode, adjDist) ->
                val nextDist = dist + adjDist
                if (nextDist < distArr[times][nextNode]) {
                    distArr[times][nextNode] = nextDist
                    pq.add(Pair(nextNode, nextDist))
                }
            }
        }
    }
    var max = -1
    for (i in 0 until n) {
        if (distArr[0][i] + distArr[1][i] > max) max = distArr[0][i] + distArr[1][i]
    }
    print(max)
}