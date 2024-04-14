class Solution {
    fun solution(n: Long): List<Int> {
        return n.toString().reversed().toCharArray().map { it.digitToInt() }
    }
}