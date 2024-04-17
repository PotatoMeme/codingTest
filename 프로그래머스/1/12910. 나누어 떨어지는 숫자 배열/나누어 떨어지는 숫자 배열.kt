class Solution {
    fun solution(arr: IntArray, divisor: Int): List<Int> {
        return arr.filter { it % divisor == 0 }.let {
            if (it.isEmpty()) listOf(-1) else it.sorted()
        }
    }
}