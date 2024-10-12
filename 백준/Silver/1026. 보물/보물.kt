fun main() = with(System.`in`.bufferedReader()) {
    readLine()
    val sortedA = readLine().split(" ").map { it.toInt() }.sortedDescending()
    val arr = ByteArray(101) { 0 }
    readLine().split(" ").map { it.toInt() }.forEach {
        arr[it]++
    }
    var sum = 0
    var sortedAIdx = 0
    arr.forEachIndexed { index, byte ->
        if (byte > 0) {
            repeat(byte.toInt()) {
                sum += (index) * sortedA[sortedAIdx++]
            }
        }
    }
    print(sum)
}