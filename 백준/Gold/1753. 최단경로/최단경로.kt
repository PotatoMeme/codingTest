import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

const val INF = 1000000

data class Node(val index: Int, val dist: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int = dist - other.dist
}


fun main() = with(System.`in`.bufferedReader()) {
    //line1
    var st = StringTokenizer(readLine())
    val v = st.nextToken().toInt()
    val e = st.nextToken().toInt()

    //line2
    val k = readLine().toInt()

    //use dijkstra algorithm
    val dis = Array(v + 1) { INF }
    val sb = StringBuilder()

    val adj = ArrayList<ArrayList<Node>>()
    for (i in 0..v) {
        adj.add(ArrayList())
    }

    for (i in 0 until e) {
        st = StringTokenizer(readLine())

        val index = st.nextToken().toInt()
        val des = st.nextToken().toInt()
        val w = st.nextToken().toInt()

        adj[index].add(Node(des, w))
    }

    fun dijkstra(srt: Int) {
        val queue = PriorityQueue<Node>()

        dis[srt] = 0
        queue.add(Node(srt, 0))

        while (queue.isNotEmpty()) {
            val (curIndex, curDist) = queue.poll()!!.run {
                index to dist
            }

            if (dis[curIndex] < curDist) continue

            for (i in 0 until adj[curIndex].size) {
                val nextIndex = adj[curIndex][i].index
                val nextDist = curDist + adj[curIndex][i].dist

                if (nextDist < dis[nextIndex]) {
                    dis[nextIndex] = nextDist
                    queue.add(Node(nextIndex, nextDist))
                }
            }
        }
    }

    dijkstra(k)

    for (i in 1..v) {
        if (dis[i] == INF) sb.append("INF\n")
        else sb.append("${dis[i]}\n")
    }

    print(sb)
}