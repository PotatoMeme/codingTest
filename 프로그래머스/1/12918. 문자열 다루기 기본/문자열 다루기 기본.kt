class Solution {
	fun solution(s: String): Boolean = (s.length == 4 || s.length == 6) && s.all { it.isDigit() }
}