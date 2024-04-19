import java.util.*
class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        val pq = PriorityQueue<Int>()
        for(item in score) {
            if(pq.size < k) {
                pq.add(item)
            }
            else {
                if(pq.peek() < item) {
                    pq.add(item)
                    pq.poll()
                }
            }
            answer.add(pq.peek())
        }
        return answer.toIntArray()
    }
}