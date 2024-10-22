fun main() = with(System.`in`.bufferedReader()) {
    //대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
    val c = readLine()!!.toInt()
    val sbResults = StringBuilder()
    repeat(c) {
        val percent = readLine().split(" ").map { it.toInt() }.let { arr ->
            val n = arr[0]//0보다 크거나 같고, 100보다 작거나 같은 정수
            val average = with(arr){
                var sum = 0f
                for (i in 1 .. n) {
                    sum += this[i]
                }
                sum / n
            }
            var count = 0
            for (i in 1 .. n) {
                if (arr[i] > average) {
                    count++
                }
            }
            count.toFloat() / n.toFloat() * 100
        }
        sbResults.appendLine(String.format("%.3f%%", percent))
    }
    print(sbResults)
}