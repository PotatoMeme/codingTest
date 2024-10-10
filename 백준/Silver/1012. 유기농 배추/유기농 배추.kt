fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val (m, n, k) = readLine().split(" ").map { it.toInt() }
        val board = Array(m) { BooleanArray(n) }
        repeat(k) {
            val (x, y) = readLine().split(" ").map { it.toInt() }
            board[x][y] = true
        }
        var count = 0
        fun dfs(x: Int, y: Int) {
            if (x < 0 || x >= m || y < 0 || y >= n || !board[x][y]) return
            board[x][y] = false
            dfs(x + 1, y)
            dfs(x - 1, y)
            dfs(x, y + 1)
            dfs(x, y - 1)
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (board[i][j]) {
                    dfs(i, j)
                    count++
                }
            }
        }
        sb.appendLine(count)
    }
    print(sb.toString())
}