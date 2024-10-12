import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { readLine().toCharArray().map { it == '1' }.toBooleanArray() }

    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    queue.add(Triple(0, 0, 1))
    board[0][0] = false

    val destination: Array<Pair<Int, Int>> = arrayOf(
        Pair(1, 0),
        Pair(0, 1),
        Pair(-1, 0),
        Pair(0, -1)
    )

    while (queue.isNotEmpty()) {
        val (i, j, k) = queue.poll()
        if (i < 0 || i >= n || j < 0 || j >= m) continue
        if (i == n - 1 && j == m - 1) {
            print(k)
            return
        }
        destination.forEach { (x, y) ->
            (i + x to j + y).let {
                if (!(it.first < 0 || it.first >= n || it.second < 0 || it.second >= m)
                    && board[it.first][it.second]
                ) {
                    board[it.first][it.second] = false
                    queue.add(Triple(it.first, it.second, k + 1))
                }
            }
        }
    }
}