fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val input = readLine()
        if (input == "0") break
        when(input.isPalindrome()){
            true -> sb.appendLine("yes")
            false -> sb.appendLine("no")
        }
    }
    print(sb)
}

fun String.isPalindrome() : Boolean{
    val len = this.length
    for (i in 0 until len / 2) {
        if (this[i] != this[len - i - 1]) {
            return false
        }
    }
    return true
}