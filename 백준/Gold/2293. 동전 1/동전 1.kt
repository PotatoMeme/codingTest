fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val coins = IntArray(n) { readln().toInt() }
    val dp = IntArray(k + 1)
    dp[0] = 1

    for (coin in coins) {
        for (i in coin..k) {
            dp[i] += dp[i - coin]
        }
    }

    print(dp[k])
}