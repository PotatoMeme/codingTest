import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    //첫째 줄에 유저의 수 N (2 ≤ N ≤ 100)과 친구 관계의 수 M (1 ≤ M ≤ 5,000)
    val (n, m) = StringTokenizer(readLine()).let {
        it.nextToken().toInt() to it.nextToken().toInt()
    }
    //둘째 줄부터 M개의 줄에는 친구 관계가 주어진다
    val friends = Array(n) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = StringTokenizer(readLine()).let {
            it.nextToken().toInt() to it.nextToken().toInt()
        }
        friends[a - 1].add(b - 1)
        friends[b - 1].add(a - 1)
    }

    var minSum = Int.MAX_VALUE
    var minIndex = -1

    for (i in 0 until n) {
        val visited = BooleanArray(n)
        val distances = IntArray(n)
        val queue: Queue<Int> = LinkedList()

        queue.add(i)
        visited[i] = true
        var sum = 0

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            for (friend in friends[current]) {
                if (!visited[friend]) {
                    visited[friend] = true
                    distances[friend] = distances[current] + 1
                    sum += distances[friend]
                    queue.add(friend)
                }
            }
        }

        if (sum < minSum) {
            minSum = sum
            minIndex = i
        }
    }

    print(minIndex + 1)
}