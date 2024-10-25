import java.util.LinkedList
import java.util.Queue


val dirX = intArrayOf(1, 2, -1, 2, -1, -2, -2, 1)
val dirY = intArrayOf(2, 1, 2, -1, -2, -1, 1, -2)

var board : Array<BooleanArray> = arrayOf()

val q: Queue<Pair<Int, Int>> = LinkedList()

fun bfs(start: Pair<Int, Int>, end: Pair<Int, Int>): Int {
    q.clear()
    q.add(start)
    board[start.first][start.second] = true
    var step = 0
    while (q.isNotEmpty()) {
        val size = q.size
        repeat(size) {
            val cur = q.poll()!!
            if (cur == end) return step
            repeat(8) {
                val x = cur.first + dirX[it]
                val y = cur.second + dirY[it]
                if (x in board.indices && y in board.indices && !board[x][y]) {
                    q.add(Pair(x, y))
                    board[x][y] = true
                }
            }
        }
        step++
    }
    return 0
}

fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()
    repeat(n) {
        val w = readln().toInt()
        board = Array(w) { BooleanArray(w) }
        val startPos = readln().split(" ").map { it.toInt() }.let { Pair(it[0], it[1]) }
        val endPos = readln().split(" ").map { it.toInt() }.let { Pair(it[0], it[1]) }
        sb.appendLine(bfs(startPos, endPos))
    }
    print(sb)
}