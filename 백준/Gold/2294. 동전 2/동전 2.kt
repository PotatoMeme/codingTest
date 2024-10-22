fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val coins = IntArray(n) { readln().toInt() }
    val dp = IntArray(k + 1)
    for (coin in coins) {
        if (coin > k) continue
        dp[coin] = 1
    }

    for (i in 1..k) {
        for (coin in coins){
            if (i - coin <= 0 || dp[i - coin] == 0) continue
            if (dp[i] != 0) {
                dp[i] = minOf(dp[i], dp[i - coin] + 1)
            }else{
                dp[i] = dp[i - coin] + 1
            }
        }
    }

    if (dp[k]==0) {
        print(-1)
    } else {
        print(dp[k])
    }
}