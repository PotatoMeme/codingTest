import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val tree = Array(n + 1) { mutableListOf<Int>() }
    val parent = IntArray(n + 1)

    repeat(n - 1) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        tree[a].add(b)
        tree[b].add(a)
    }

    bfs(1, tree, parent)

    for (i in 2..n) {
        println(parent[i])
    }
}

fun bfs(start: Int, tree: Array<MutableList<Int>>, parent: IntArray) {
    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    parent[start] = -1  

    while (queue.isNotEmpty()) {
        val node = queue.poll()

        for (child in tree[node]) {
            if (parent[child] == 0) {  
                parent[child] = node  
                queue.add(child) 
            }
        }
    }
}