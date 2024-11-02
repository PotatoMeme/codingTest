import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    //첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)
    val (n, m, r) = StringTokenizer(readLine()).let {
        Triple(it.nextToken().toInt(), it.nextToken().toInt(), it.nextToken().toInt())
    }
    val linked = Array(n) { mutableListOf<Int>() }
    val visited = IntArray(n) { 0 }
    repeat(m) {
        val (a, b) = StringTokenizer(readLine()).let {
            Pair(it.nextToken().toInt(), it.nextToken().toInt())
        }
        linked[a - 1].add(b - 1)
        linked[b - 1].add(a - 1)
    }
    linked.forEach { it.sort() }
    val q: Queue<Int> = LinkedList()
    q.add(r - 1)
    var i = 1
    visited[r - 1] = i++
    while (q.isNotEmpty()) {
        linked[q.poll()!!].forEach {
            if (visited[it] == 0) {
                visited[it] = i++
                q.add(it)
            }
        }
    }
    print(visited.joinToString("\n"))
}