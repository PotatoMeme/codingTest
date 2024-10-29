import java.util.*
import kotlin.collections.ArrayList

fun main() = with(System.`in`.bufferedReader()) {
    val n = readln().toInt()
    val m = readln().toInt()

    val adj = Array(n) { ArrayList<Pair<Int, Int>>() }
    repeat(m) {
        val st = StringTokenizer(readln())
        val startCityNumber = st.nextToken().toInt()
        val endCityNumber = st.nextToken().toInt()
        val weight = st.nextToken().toInt()

        adj[startCityNumber - 1].add(Pair(endCityNumber - 1, weight))
    }
    val st = StringTokenizer(readln())
    val startCityNumber = st.nextToken().toInt()
    val endCityNumber = st.nextToken().toInt()

    val distanceArray = IntArray(n) { Int.MAX_VALUE }

    distanceArray[startCityNumber - 1] = 0
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    queue.add(Pair(startCityNumber - 1, 0))
    while (queue.isNotEmpty()) {
        val (cityNumber, distance) = queue.poll()!!
        if (distanceArray[cityNumber] < distance) continue
        for ((nextCityNumber, weight) in adj[cityNumber]) {
            val nextDistance = distance + weight
            if (nextDistance < distanceArray[nextCityNumber]) {
                distanceArray[nextCityNumber] = nextDistance
                queue.add(Pair(nextCityNumber, nextDistance))
            }
        }
    }
    print(distanceArray[endCityNumber - 1])
}