import java.util.LinkedList
import java.util.Queue

data class PosData(
    val x: Int,
    val y: Int,
    val w: Int = 0
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
    val board = Array(m) { readLine().split(" ").map { it.toInt() }.toTypedArray() }
    val queue: Queue<PosData> = LinkedList()
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (board[i][j] == 1) {
                queue.add(PosData(i, j))
            }
        }
    }

    var result = 0
    while (queue.isNotEmpty()) {
        val pos = queue.poll()!!
        for (dir in direction) {
            val nextPos = pos + dir
            if (nextPos.x in 0 until m && nextPos.y in 0 until n && board[nextPos.x][nextPos.y] == 0) {
                board[nextPos.x][nextPos.y] = nextPos.w
                queue.add(nextPos)
            }
        }
        result = pos.w
    }

    if (board.any { it.any { it == 0 } }) {
        print(-1)
    } else {
        print(result)
    }
}