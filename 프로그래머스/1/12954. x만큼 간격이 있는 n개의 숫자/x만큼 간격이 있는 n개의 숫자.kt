class Solution {
    fun solution(x: Int, n: Int): LongArray {
        val longX = x.toLong()
        var save = 0L
        return LongArray(n) {
            save += longX
            save
        }
    }
}