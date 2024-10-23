import java.util.Stack
import java.util.StringTokenizer

fun main() {
    //example input : 3
    val input = readln().toInt()
    val stack = Stack<String>()
    val resultSb = StringBuilder()
    repeat(input) {
        //example input : this is a test
        val str = readln()
        val st = StringTokenizer(str)
        while (st.hasMoreTokens()) {
            stack.push(st.nextToken())
        }
        resultSb.append("Case #").append(it + 1).append(": ")
        while (stack.isNotEmpty()) {
            resultSb.append(stack.pop()).append(" ")
        }
        resultSb.appendLine()
    }
    print(resultSb.toString())
}