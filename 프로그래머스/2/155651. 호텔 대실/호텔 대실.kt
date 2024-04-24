import java.util.StringTokenizer
class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        val convertTimes = book_time.map {
            intArrayOf(it[0].convertTime(),it[1].convertTime()+10)
        }.sortedBy {
            it[0]
        }
        val arr = mutableListOf<Int>()
        
        convertTimes.forEach { time ->
            var idx = -1
            var min = Int.MAX_VALUE

            arr.forEachIndexed { index, i ->
                if (time[0] in i until min) {
                    idx = index
                    min = time[0]
                }
            }

            if (idx == -1){
                arr.add(time[1])
            } else {
                arr[idx] = time[1]
            }
        }
        
        
        return arr.size
    }

    private fun String.convertTime() : Int{
        val st = StringTokenizer(this,":")
        return st.nextToken().toInt()*60 + st.nextToken().toInt()
    }
}