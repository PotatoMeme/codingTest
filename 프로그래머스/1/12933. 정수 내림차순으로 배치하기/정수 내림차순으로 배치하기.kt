class Solution {
    fun solution(n: Long): Long {
        return buildString {
            val arr = IntArray(10)
            n.toString().forEach {
                arr[it.digitToInt()]++
            }
            for (i in 9 downTo 0){
                repeat(arr[i]){ append(i) }
            }
        }.toLong()
    }
}