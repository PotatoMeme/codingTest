class Solution {
    fun solution(a: IntArray, b: IntArray): Int {
        return a.indices.map { a[it]*b[it] }.fold(0){ acc, num -> acc+num }
    }
}