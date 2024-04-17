import java.util.*
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
         var q: Queue<Pair<Int, Int>> = LinkedList()
        priorities.forEachIndexed { index, i ->
            q.offer(Pair(i, index))
        }
        var count = 0
        while (q.isNotEmpty()) {
            val print = q.poll()
            if (q.any { it.first > print.first }) {
                q.offer(print)
            } else {
                count++
                if (print.second == location) return count
            }
        }
        return 0
    }
}