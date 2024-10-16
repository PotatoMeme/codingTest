fun main() = with(System.`in`.bufferedReader()) {
    val (r, c) = readLine().split(" ").map { it.toInt() }
    val board = Array(r) { readLine().toCharArray() }
    val visited = BooleanArray('Z' - 'A' + 1)
    val direction = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(0, 1),
        intArrayOf(-1, 0),
        intArrayOf(0, -1),
    )
    var answer = 0
    fun dfs(x: Int, y: Int, depth: Int) {
        if (depth > answer) {
            answer = depth
        }
        visited[board[x][y] - 'A'] = true
        direction.forEach {
            val nx = x + it[0]
            val ny = y + it[1]
            if (nx in 0 until r && ny in 0 until c && !visited[board[nx][ny] - 'A']) {
                dfs(nx, ny,depth+1)
            }
        }
        visited[board[x][y] - 'A'] = false
    }
    dfs(0,0,1)
    print(answer)
}
