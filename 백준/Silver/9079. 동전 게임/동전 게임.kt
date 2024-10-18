import java.util.LinkedList
import java.util.Queue

private val directions = arrayOf(
    intArrayOf(1, 2, 4), // row 1
    intArrayOf(8, 16, 32), // row 2
    intArrayOf(64, 128, 256), // row 3
    intArrayOf(1, 8, 64), // col 1
    intArrayOf(2, 16, 128), // col 2
    intArrayOf(4, 32, 256), // col 3
    intArrayOf(1, 16, 256), // diag 1
    intArrayOf(4, 16, 64)  // diag 2
)

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        //board setting
        var start = 0
        repeat(3) { x ->
            readLine().split(" ").forEachIndexed { y, s ->
                if (s == "H") start = start or (1 shl (x * 3 + y))
            }
        }
        sb.appendLine(bfs(start))
    }
    print(sb)
}
fun bfs(start: Int) : Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val visited = BooleanArray(512)//2^9=512 나올수있는 모든 경우의 수
    queue.add(start to 0)
    while (queue.isNotEmpty()) {
        val (state, depth) = queue.poll()!!
        if (state == 0 || state == 511) return depth
        visited[state] = true
        for (dir in directions) {
            var nextState = state
            for (d in dir) {
                nextState = nextState xor d
            }

            if (!visited[nextState]) {
                visited[nextState] = true
                queue.add(nextState to depth + 1)
            }
        }
    }
    return -1
}