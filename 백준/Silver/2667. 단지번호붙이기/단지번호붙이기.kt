import java.util.LinkedList
import java.util.Queue

data class PosData(
    val x: Int,
    val y: Int,
) {
    operator fun plus(posData: PosData): PosData {
        return PosData(this.x + posData.x, this.y + posData.y)
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    //지도의 크기 N
    val n = readLine().toInt()
    val board = Array(n) {
        readLine().toCharArray().map { it == '1' }.toBooleanArray()
    }
    val direction = arrayOf(
        PosData(1, 0),
        PosData(0, 1),
        PosData(-1, 0),
        PosData(0, -1),
    )

    fun bfs(x: Int, y: Int): Int {
        val q: Queue<PosData> = LinkedList()
        q.add(PosData(x, y))
        board[x][y] = false
        var count = 0
        while (q.isNotEmpty()) {
            val posData = q.poll()!!
            count++
            direction.forEach {
                (posData + it).let { pos ->
                    if (pos.x in 0 until n && pos.y in 0 until n && board[pos.x][pos.y]) {
                        board[pos.x][pos.y] = false
                        q.add(pos)
                    }
                }
            }
        }
        return count
    }

    val list = mutableListOf<Int>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (board[i][j]) list.add(bfs(i, j))
        }
    }

    print(buildString {
        appendLine(list.size)
        list.sorted().forEach {
            appendLine(it)
        }
    })
}