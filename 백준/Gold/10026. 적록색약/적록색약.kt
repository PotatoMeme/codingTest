import java.util.LinkedList
import java.util.Queue


const val RED = 1
const val GREEN = 2
const val BLUE = 3
const val CHECKED = -1

val dirX = intArrayOf(-1, 0, 1, 0)
val dirY = intArrayOf(0, 1, 0, -1)

var normalBoard: Array<IntArray> = arrayOf()
var blindnessBoard: Array<IntArray> = arrayOf()

val q: Queue<Pair<Int, Int>> = LinkedList()

fun normalBfs(x: Int, y: Int, color: Int) {
    q.add(Pair(x, y))
    normalBoard[x][y] = CHECKED
    while (q.isNotEmpty()) {
        val (x, y) = q.poll()!!
        for (i in 0 until 4) {
            val nx = x + dirX[i]
            val ny = y + dirY[i]
            if (nx in normalBoard.indices && ny in normalBoard.indices && normalBoard[nx][ny] == color) {
                normalBoard[nx][ny] = CHECKED
                q.add(Pair(nx, ny))
            }
        }
    }
}

fun blindBfs(x: Int, y: Int, color: Int) {
    q.add(Pair(x, y))
    blindnessBoard[x][y] = CHECKED
    while (q.isNotEmpty()) {
        val (x, y) = q.poll()!!
        for (i in 0 until 4) {
            val nx = x + dirX[i]
            val ny = y + dirY[i]
            if (nx in blindnessBoard.indices && ny in blindnessBoard.indices && blindnessBoard[nx][ny] == color) {
                blindnessBoard[nx][ny] = CHECKED
                q.add(Pair(nx, ny))
            }
        }

    }
}

fun main() {
    val n = readln().toInt()
    normalBoard = Array(n) { IntArray(n) }
    blindnessBoard = Array(n) { IntArray(n) }
    repeat(n) { i ->
        val line = readln()
        for (j in line.indices) {
            when (line[j]) {
                'R' -> {
                    normalBoard[i][j] = RED
                    blindnessBoard[i][j] = RED
                }

                'G' -> {
                    normalBoard[i][j] = GREEN
                    blindnessBoard[i][j] = RED
                }

                'B' -> {
                    normalBoard[i][j] = BLUE
                    blindnessBoard[i][j] = BLUE
                }
            }
        }
    }

    var normalCount = 0
    var blindCount = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (normalBoard[i][j] != CHECKED) {
                normalBfs(i, j, normalBoard[i][j])
                normalCount++
            }
            if (blindnessBoard[i][j] != CHECKED) {
                blindBfs(i, j, blindnessBoard[i][j])
                blindCount++
            }
        }
    }

    print("$normalCount $blindCount")
}