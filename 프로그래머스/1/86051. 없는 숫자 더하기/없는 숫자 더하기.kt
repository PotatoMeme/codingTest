class Solution {
    fun solution(numbers: IntArray): Int {
        var answer = 0
        val checkArr = BooleanArray(10)
        
        numbers.forEach { checkArr[it] = true }
        checkArr.forEachIndexed { index, b -> if (!b) answer += index }
        
        return answer
    }
}