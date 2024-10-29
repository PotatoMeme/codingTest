import java.util.*
import kotlin.collections.ArrayList

const val INFF = 300_000_000
fun main() = with(System.`in`.bufferedReader()) {
    val (n, e) = StringTokenizer(readln()).let { it.nextToken().toInt() to it.nextToken().toInt() }
    val graph = Array(n) { ArrayList<Pair<Int, Int>>() }
    repeat(e) {
        val (a, b, c) = StringTokenizer(readln()).let {
            Triple(
                it.nextToken().toInt() - 1,
                it.nextToken().toInt() - 1,
                it.nextToken().toInt()
            )
        }
        graph[a].add(b to c)
        graph[b].add(a to c)
    }

    val (v1, v2) = StringTokenizer(readln()).let {
        it.nextToken().toInt() - 1 to it.nextToken().toInt() - 1
    }

    val priorityQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val distance = Array(3) { IntArray(n) { INFF } }
    val visited = BooleanArray(n)
    val start = listOf(0, v1, v2)

    repeat(3) { times ->
        visited.fill(false)

        priorityQueue.add(start[times] to 0)
        distance[times][start[times]] = 0
        while (priorityQueue.isNotEmpty()) {
            val (u, dist) = priorityQueue.poll()!!
            if (visited[u]) continue
            visited[u] = true
            for ((v, w) in graph[u]) {
                val curW = dist + w
                if (distance[times][v] > curW) {
                    distance[times][v] = curW
                    priorityQueue.add(v to curW)
                }
            }
        }
    }

    val min = minOf(
        (distance[0][v1] + distance[1][v2] + distance[2][n - 1]),
        (distance[0][v2] + distance[2][v1] + distance[1][n - 1])
    )
    if (min >= INFF) {
        print(-1)
    } else {
        print(min)
    }
}