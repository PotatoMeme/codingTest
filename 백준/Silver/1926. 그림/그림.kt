data class PosData(
    val x: Int,
    val y: Int,
) {
    operator fun plus(posData: PosData): PosData {
        return PosData(this.x + posData.x, this.y + posData.y)
    }
}

val direction = arrayOf(
    PosData(1, 0),
    PosData(0, 1),
    PosData(-1, 0),
    PosData(0, -1),
)

fun main() = with(System.`in`.bufferedReader()) {
    //도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) {
        readLine().split(" ").map { it.toInt() }.toTypedArray()
    }

    var paintCount = 0
    var maxPaintArea = 0

    fun dfs(x: Int, y: Int) : Int{
        arr[x][y] = 0
        var result = 1
        direction.forEach {
            val nx = x + it.x
            val ny = y + it.y
            if (nx in 0 until n && ny in 0 until m && arr[nx][ny] == 1){
                result += dfs(nx, ny)
            }
        }
        return result
    }

    for (i in 0 until n){
        for (j in 0 until m){
            if (arr[i][j] == 1){
                maxPaintArea = maxOf(maxPaintArea, dfs(i,j))
                paintCount++
            }
        }
    }
    print("$paintCount\n$maxPaintArea")
}