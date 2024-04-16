class Solution {
    fun solution(seoul: Array<String>): String {
        return buildString{
            append("김서방은 ")
            append(seoul.indexOfFirst { it == "Kim" })
            append("에 있다")
        }
    }
}