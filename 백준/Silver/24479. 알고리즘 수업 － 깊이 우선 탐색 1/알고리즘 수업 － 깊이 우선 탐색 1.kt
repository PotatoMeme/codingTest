import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m, r) = readLine()!!.split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visited = IntArray(n + 1) { 0 }

    repeat(m) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    graph.forEach { it.sort() } // 노드를 오름차순으로 방문하기 위해 정렬

    var i = 1
    fun dfs(node: Int) {
        visited[node] = i++
        for (j in graph[node]) {
            if (visited[j] == 0) {
                dfs(j)
            }
        }
    }

    dfs(r)
    print(buildString {
        for (j in 1..n) {
            appendLine(visited[j])
        }
    })
}