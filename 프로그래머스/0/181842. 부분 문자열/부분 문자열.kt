class Solution {
    fun solution(str1: String, str2: String): Int {
        loop@ for (index2 in 0..str2.length - str1.length) {
            for ((index1, c1) in str1.withIndex()) {
                if (c1 != str2[index2 + index1]) continue@loop
            }
            return 1
        }
        return 0
    }
}