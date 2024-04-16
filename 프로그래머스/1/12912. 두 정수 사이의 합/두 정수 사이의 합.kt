
class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        (if (a < b) a..b else b..a).forEach { answer += it }
        return answer
    }
}