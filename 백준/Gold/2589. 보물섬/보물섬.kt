import java.util.LinkedList
import java.util.Queue

data class PosData(
    val x: Int,
    val y: Int,
    val w: Int = 0, // 이동 거리를 추적하기 위한 필드
) {
    operator fun plus(posData: PosData): PosData {
        return PosData(this.x + posData.x, this.y + posData.y, this.w + 1)
    }
}

val direction = arrayOf(
    PosData(1, 0),
    PosData(0, 1),
    PosData(-1, 0),
    PosData(0, -1),
)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    
    // 육지 여부를 나타내는 지도 정보
    val graph = Array(n) { readLine().toCharArray().map { it == 'L' }.toBooleanArray() }
    var maxDistance = 0

    fun bfs(startX: Int, startY: Int): Int {
        val visited = Array(n) { BooleanArray(m) { false } }
        val q: Queue<PosData> = LinkedList()
        var maxDist = 0

        q.add(PosData(startX, startY))
        visited[startX][startY] = true

        var l1Pos = PosData(startX, startY)

        // 첫 번째 BFS로 가장 먼 지점(L1)을 찾음
        while (q.isNotEmpty()) {
            val pos = q.poll()
            l1Pos = pos // 가장 먼 지점을 갱신
            for (d in direction) {
                val next = pos + d
                if (next.x in 0 until n && next.y in 0 until m && !visited[next.x][next.y] && graph[next.x][next.y]) {
                    q.add(next)
                    visited[next.x][next.y] = true
                }
            }
        }

        // 두 번째 BFS로 L1에서 가장 먼 지점(L2) 찾기
        q.add(l1Pos.copy(w = 0)) // L1에서 시작
        visited.forEach { it.fill(false) } // 방문 배열 초기화
        visited[l1Pos.x][l1Pos.y] = true

        while (q.isNotEmpty()) {
            val pos = q.poll()
            maxDist = pos.w // 최종 거리를 갱신
            for (d in direction) {
                val next = pos + d
                if (next.x in 0 until n && next.y in 0 until m && !visited[next.x][next.y] && graph[next.x][next.y]) {
                    q.add(next)
                    visited[next.x][next.y] = true
                }
            }
        }

        return maxDist
    }

    // 모든 육지에서 BFS 시작
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j]) { // 육지일 경우
                val bfsResult = bfs(i, j)
                maxDistance = maxOf(maxDistance, bfsResult)
            }
        }
    }

    println(maxDistance)
}