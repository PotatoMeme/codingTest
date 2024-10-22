import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine()
    val bomb = readLine()

    val stack = StringBuilder()

    for (char in input) {
        stack.append(char)  

        if (stack.length >= bomb.length && stack.substring(stack.length - bomb.length) == bomb) {
            stack.delete(stack.length - bomb.length, stack.length)
        }
    }

    if (stack.isEmpty()) {
        println("FRULA")
    } else {
        println(stack.toString())
    }
}