class Solution {
    fun solution(n: Int): Int  = if (n >= 10) n % 10 + solution(n / 10) else n
}