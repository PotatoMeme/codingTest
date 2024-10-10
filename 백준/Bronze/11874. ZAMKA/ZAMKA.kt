fun main() = with(System.`in`.bufferedReader()) {
    val l = readLine().toInt()
    val d = readLine().toInt()
    val x = readLine().toInt()
    var n : Int = 0
    //simple get
    for (i in l..d){
        if(i.toString().toCharArray().sumOf { it - '0' }== x) {
            n = i
            break
        }
    }
    var m : Int = 0
    for (i in d downTo l){
        if(i.toString().toCharArray().sumOf { it - '0' } == x){
            m = i
            break
        }
    }
    println(n)
    println(m)
}