class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): List<Int> {
        val answer = IntArray(100)
        var day = 0
        for (i in progresses.indices) {
            while (progresses[i] + day * speeds[i] < 100) {
                day++
            }
            answer[day]++
        }
        return  answer.filter { it != 0 }
    }
}