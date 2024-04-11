class Solution {
    fun solution(num_list: IntArray, n: Int): List<Int> =
        num_list.filterIndexed { index, _ -> index % n == 0 }
}