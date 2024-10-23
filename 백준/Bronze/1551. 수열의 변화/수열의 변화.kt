fun main() {
    // N과 K
    val (n, k) = readln().split(" ").map{it.toInt()}
    val list = readln().split(",").map{it.toInt()}.toMutableList()
    repeat(k) {
        for (i in 0 until list.size-it-1) {
            list[i] = list[i+1] - list[i]
        }
    }
    val sb = StringBuilder()
    for (i in 0 until n-k) {
        sb.append("${list[i]},")
    }
    sb.deleteCharAt(sb.length-1)
    print(sb.toString())
}