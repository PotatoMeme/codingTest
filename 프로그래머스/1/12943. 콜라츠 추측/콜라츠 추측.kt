class Solution {
    fun solution(num: Int): Int {
        return collatz(0, num.toLong())
    }

    private fun collatz(depth: Int, num: Long): Int {
        if (num == 1L) {
            return depth
        }
        if (depth == 500) {
            return -1
        }
        if (num % 2 == 0L) {
            return collatz(depth + 1, num / 2)
        } else {
            return collatz(depth + 1, num * 3 + 1)
        }
    }
}