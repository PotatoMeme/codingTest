class Solution {
    fun solution(my_string: String): List<String> {
        return my_string.indices
            .map { my_string.substring(it) }
            .distinct()
            .sorted()
    }
}