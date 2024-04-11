import kotlin.math.max
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n)
    repeat(n){ arr[it] = readLine().toInt()}
    val s = Solution2156Try1(n,arr)
    print(s.result)
}

//try1
class Solution2156Try1(n:Int,arr:IntArray){
    val dp = IntArray(n)
    val result: Int

    init {
        dp[0] = arr[0]
        if (n > 1) {
            dp[1] = dp[0] + arr[1]
            if (n > 2) {
                dp[2] = maxOf((arr[0] + arr[2]), dp[1],(arr[1]+arr[2]))
                if (n > 3) {
                    for (i in 3 until n) {
                        dp[i] = maxOf(dp[i - 1],
                            (dp[i - 2] + arr[i]),
                            (dp[i - 3] + (arr[i - 1] + arr[i])))
                    }
                }
            }
        }

        result = dp[n - 1]
    }
}