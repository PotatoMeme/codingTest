import kotlin.math.pow
import kotlin.math.sqrt
class Solution {
    fun solution(n: Long): Long {
        val num = sqrt(n.toDouble())
        return if ((num-num.toInt())>0){
            -1
        } else {
            (num+1).pow(2).toLong()
        }
    }
}