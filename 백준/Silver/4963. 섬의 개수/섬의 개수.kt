fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val direction = arrayOf(
        intArrayOf(1,0),
        intArrayOf(0,1),
        intArrayOf(1,1),
        intArrayOf(1,-1),
        intArrayOf(-1,1),
        intArrayOf(-1,0),
        intArrayOf(0,-1),
        intArrayOf(-1,-1),
    )
    while (true) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break
        val graph = Array(m) { readLine().split(" ").map { it.toInt() }.toTypedArray() }
        var count = 0
        fun dfs(x: Int, y: Int) {
            graph[x][y] = 0
            direction.forEach {
                val nx = x + it[0]
                val ny = y + it[1]
                if (nx in 0 until m && ny in 0 until n && graph[nx][ny] == 1) {
                    dfs(nx,ny)
                }
            }
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (graph[i][j] == 1) {
                    dfs(i,j)
                    count++
                }
            }
        }
        sb.appendLine(count)
    }
    println(sb)
}