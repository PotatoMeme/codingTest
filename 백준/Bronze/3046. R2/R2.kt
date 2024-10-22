fun main() = with(System.`in`.bufferedReader()) {
    //(x+y)/2 = s
    //y = 2s -x
    print(readLine().split(" ").map { it.toInt() }.let { (x, s) ->
        2 * s - x
    })
}