fun main() {
    val n = readln().toInt()
    if (n % 2 != 0) {
        println(0)
    } else {
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[2] = 3
        for (i in 4..n step 2) {
            dp[i] = dp[i - 2] * 3
            for (j in 4..i step 2) {
                dp[i] += dp[i - j] * 2
            }
        }
        println(dp[n])
    }
}