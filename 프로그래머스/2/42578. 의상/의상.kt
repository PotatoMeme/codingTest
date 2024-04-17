class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        var map = HashMap<String, Int>()
        clothes.forEach { map[it[1]] = (map[it[1]] ?: 1) + 1 }
        map.forEach {
            answer *= it.value
        }
        return answer-1
    }
}