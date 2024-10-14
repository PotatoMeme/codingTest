fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val linkBoard = Array(n) { BooleanArray(n) }
    val visited = BooleanArray(n)

    repeat(m) {
        val (x, y) = readLine().split(" ").map { it.toInt() - 1 }
        linkBoard[x][y] = true
        linkBoard[y][x] = true
    }

    fun dfs(pos:Int){
        linkBoard[pos].forEachIndexed { index, b ->
            if (b && !visited[index]) {
                visited[index] = true
                dfs(index)
            }
        }
    }
    var result = 0
    for (i in 0 until n) {
        if (!visited[i]) {
            dfs(i)
            result++
        }
    }
    print(result)
}