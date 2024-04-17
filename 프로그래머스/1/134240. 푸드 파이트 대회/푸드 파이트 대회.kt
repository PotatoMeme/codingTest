import java.util.Stack
class Solution {
    fun solution(food: IntArray): String {
        val sb = StringBuilder()
        val stack = Stack<Int>()
        food.forEachIndexed{ index, i ->
            repeat(i/2) {
                stack.add(index)
                sb.append(index)
            }
        }
        sb.append(0)
        while (stack.isNotEmpty()){
            sb.append(stack.pop())
        }
        return sb.toString()
    }
}