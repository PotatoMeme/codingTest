fun main() = with(System.`in`.bufferedReader()) {
    //A+: 4.3, A0: 4.0, A-: 3.7
    //
    //B+: 3.3, B0: 3.0, B-: 2.7
    //
    //C+: 2.3, C0: 2.0, C-: 1.7
    //
    //D+: 1.3, D0: 1.0, D-: 0.7
    //
    //F: 0.0
    val input = readLine()
    when (input) {
        "A+" -> println("4.3")
        "A0" -> println("4.0")
        "A-" -> println("3.7")
        "B+" -> println("3.3")
        "B0" -> println("3.0")
        "B-" -> println("2.7")
        "C+" -> println("2.3")
        "C0" -> println("2.0")
        "C-" -> println("1.7")
        "D+" -> println("1.3")
        "D0" -> println("1.0")
        "D-" -> println("0.7")
        "F" -> println("0.0")
    }
}