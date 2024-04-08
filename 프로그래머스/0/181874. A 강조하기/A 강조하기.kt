class Solution {
    fun solution(myString: String): String {
        val sb = StringBuilder().apply {
            myString.forEach {
                when (it) {
                    'a' -> append('A')
                    in 'B'..'Z' -> append('a' + (it - 'A'))
                    else -> append(it)
                }
            }
        }
        return sb.toString()
    }
}