class Solution {
     fun solution(numbers: IntArray): String = numbers.map { it.toString() }
        .sortedWith { o1, o2 ->
            when (o1.length) {
                o2.length -> o2.compareTo(o1)
                else -> (o2 + o1).compareTo(o1 + o2)
            }
        }.run {
            val sb = StringBuilder()
            if (this[0] == "0") {
                sb.append(0)
            } else {
                this.forEach {
                    sb.append(it)
                }
            }
            return sb.toString()
        }
}