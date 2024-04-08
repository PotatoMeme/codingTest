class Solution {
    fun solution(num_list: IntArray): Int {
        num_list.forEachIndexed { index, i ->  
            if (i < 0) return index
        }
        return -1
    }
}