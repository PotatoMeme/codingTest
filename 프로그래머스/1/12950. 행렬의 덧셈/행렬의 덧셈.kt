class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        return Array(arr1.size) { idx1 ->
            IntArray(arr1[0].size) { idx2 ->
                arr1[idx1][idx2] + arr2[idx1][idx2]
            }
        }
    }
}