import java.io.BufferedReader
import java.util.*

fun main() = println(No2589().solve(System.`in`.bufferedReader()))

class No2589 {
    private val directions = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    fun solve(input: BufferedReader): String {
        val (n, m) = input.readLine().split(" ").map { it.toInt() }
        val map = Array(n) { input.readLine().toCharArray() }
        var maxDistance = 0

        // L1 찾기 (모든 육지에서 가장 먼 육지를 L1으로 설정)
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (map[i][j] == 'L') {
                    val l1Pos = bfs(map, i, j)  // L1 찾기
                    val l2Distance = bfsDistance(map, l1Pos.first, l1Pos.second) // L1에서 L2로의 거리 찾기
                    maxDistance = maxDistance.coerceAtLeast(l2Distance)
                }
            }
        }

        return maxDistance.toString()
    }

    // L1에서 L2까지의 거리만 계산
    private fun bfsDistance(map: Array<CharArray>, x: Int, y: Int): Int {
        val visited = Array(map.size) { BooleanArray(map[0].size) }
        val queue = ArrayDeque<Triple<Int, Int, Int>>()  // 좌표와 거리 저장
        var maxDistance = 0

        visited[x][y] = true
        queue.add(Triple(x, y, 0))

        while (queue.isNotEmpty()) {
            val (curX, curY, dist) = queue.removeFirst()
            maxDistance = dist

            for ((dx, dy) in directions) {
                val nx = curX + dx
                val ny = curY + dy

                if (nx !in map.indices || ny !in map[0].indices) continue
                if (map[nx][ny] == 'W' || visited[nx][ny]) continue

                visited[nx][ny] = true
                queue.add(Triple(nx, ny, dist + 1))
            }
        }

        return maxDistance
    }

    // BFS로 L1 좌표 찾기
    private fun bfs(map: Array<CharArray>, x: Int, y: Int): Pair<Int, Int> {
        val visited = Array(map.size) { BooleanArray(map[0].size) }
        val queue = ArrayDeque<Pair<Int, Int>>()
        var l1Pos = x to y

        visited[x][y] = true
        queue.add(x to y)

        while (queue.isNotEmpty()) {
            val (curX, curY) = queue.removeFirst()
            l1Pos = curX to curY  // 마지막에 남은 좌표가 가장 먼 좌표 (L1)

            for ((dx, dy) in directions) {
                val nx = curX + dx
                val ny = curY + dy

                if (nx !in map.indices || ny !in map[0].indices) continue
                if (map[nx][ny] == 'W' || visited[nx][ny]) continue

                visited[nx][ny] = true
                queue.add(nx to ny)
            }
        }

        return l1Pos  // 가장 먼 좌표 (L1) 반환
    }
}