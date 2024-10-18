val direction = arrayOf(
    intArrayOf(1,0),
    intArrayOf(-1,0),
    intArrayOf(0,1),
    intArrayOf(0,-1),
)

fun main() = with(System.`in`.bufferedReader()) {
    val (m,n,k) = readLine().split(" ").map { it.toInt() }
    val map = Array(m) { BooleanArray(n) }
    repeat(k) {
        val (startX,startY,endX,endY) = readLine().split(" ").map { it.toInt() }
        for (i in startX until endX) {
            for (j in startY until endY) {
                map[j][i] = true
            }
        }
    }

    fun dfs(x: Int, y: Int) :Int {
        map[x][y] = true
        var cnt = 1
        direction.forEach {
            val nx = x + it[0]
            val ny = y + it[1]
            if (nx in 0 until m && ny in 0 until n && !map[nx][ny]) {
                cnt += dfs(nx,ny)
            }
        }
        return cnt
    }
    val mutableList = mutableListOf<Int>()
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (!map[i][j]) {
                mutableList.add(dfs(i,j))
            }
        }
    }
    println(mutableList.size)
    print(mutableList.sorted().joinToString(" "))
}