class Solution {
    fun solution(x: Int): Boolean {
        return x % (x.toString().fold(0) { acc, char -> acc + (char - '0') }) == 0
    }
}