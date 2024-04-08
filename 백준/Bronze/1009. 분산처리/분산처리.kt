fun main() = with(System.`in`.bufferedReader()) {
    val i = readLine().toInt()
    val sb = StringBuilder()
    repeat(i) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        var save = 1
        repeat(b){
           save = save*a%10
       }

        sb.appendLine(
            if(save == 0) 10 else save
        )
    }
    print(sb.toString())
}
