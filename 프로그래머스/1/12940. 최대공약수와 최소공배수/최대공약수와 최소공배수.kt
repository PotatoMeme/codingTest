class Solution {
     fun solution(n: Int, m: Int): IntArray {
        val gcd = gcd(n, m)
        return intArrayOf(gcd, lcm(n, m, gcd))
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    private fun lcm(a: Int, b: Int, gcd: Int): Int = a * b / gcd
}