import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    val stack = Stack<Int>()
    var current = 1

    fun checkStack() : Boolean{
        if (stack.isNotEmpty() && stack.peek() == current){
            stack.pop()
            current++
            return true
        }else {
            return false
        }
    }

    for (i in list){
        var check = true
        do{
            if (check && i == current){
                current++
                check = false
            }
        }while (checkStack())
        if (check) stack.add(i)
    }
    
    if (current <= n) println("Sad") else println("Nice")
}