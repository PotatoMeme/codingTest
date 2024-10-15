import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer


data class PosData(
    val x: Int,
    val y: Int,
    val z: Int,
    val weight: Int = 0
) {
    operator fun plus(posData: PosData): PosData {
        return PosData(this.x + posData.x, this.y + posData.y, this.z + posData.z, this.weight + 1)
    }
}

val direction = arrayOf(
    PosData(1, 0, 0),
    PosData(0, 1, 0),
    PosData(0, 0, 1),
    PosData(-1, 0, 0),
    PosData(0, -1, 0),
    PosData(0, 0, -1),
)

fun main() = with(System.`in`.bufferedReader()) {
    //M,N과 쌓아올려지는 상자의 수를 나타내는 H
    val (m, n, h) = readLine().split(" ").map { it.toInt() }
    val queue: Queue<PosData> = LinkedList<PosData>()
    var zeroCount = 0
    //h*n*m ex) board[h][n][m]
    val board = Array(h) { z ->
        Array(n) { y ->
            val st = StringTokenizer(readLine())
            IntArray(m) { x ->
                val num = st.nextToken().toInt()
                if (num == 1) {
                    queue.add(PosData(x, y, z))
                } else if (num == 0) {
                    zeroCount++
                }
                num
            }
        }
    }
    var maxDay = 0
    while (queue.isNotEmpty()) {
        val posData = queue.poll()!!
        direction.forEach {
            val nextPosData = posData + it
            if (nextPosData.x in 0 until m
                && nextPosData.y in 0 until n
                && nextPosData.z in 0 until h
                && board[nextPosData.z][nextPosData.y][nextPosData.x] == 0
            ) {
                board[nextPosData.z][nextPosData.y][nextPosData.x] = nextPosData.weight
                maxDay = nextPosData.weight
                zeroCount--
                queue.add(nextPosData)
            }
        }
    }

    if (zeroCount != 0) {
        print(-1)
    } else {
        print(maxDay)
    }
}