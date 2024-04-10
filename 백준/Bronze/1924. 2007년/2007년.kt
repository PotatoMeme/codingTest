fun main() = with(System.`in`.bufferedReader()) {
    val arr = arrayOf(
        31,28,31,30,31,30,31,31,30,31,30,31
    )

    val (x,y) = readLine().split(" ").map { it.toInt() }
    var save = 0
    for (i in 0 until x -1){
        save += arr[i]
    }
    save += y
    when(save%7){
        0 -> print("SUN")
        1 -> print("MON")
        2 -> print("TUE")
        3 -> print("WED")
        4 -> print("THU")
        5 -> print("FRI")
        6 -> print("SAT")
    }
}