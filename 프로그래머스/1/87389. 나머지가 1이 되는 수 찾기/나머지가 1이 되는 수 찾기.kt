class Solution {
    fun solution(n: Int): Int {
        for(i in 2 until n){
            if(n%i == 1) return i
        }
        return 0
    }
}