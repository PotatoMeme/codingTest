class Solution {
    fun solution(strArr: Array<String>): List<String> {
        return strArr.filter { !it.contains("ad") }
    }
}