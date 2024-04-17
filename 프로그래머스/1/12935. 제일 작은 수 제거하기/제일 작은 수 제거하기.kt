class Solution {
    fun solution(arr: IntArray): List<Int> {
        if(arr.size == 1) return listOf(-1)
        var min = arr[0]
        var minIndex = 0
        for (i in 1 until arr.size){
            if (arr[i] < min){
                min = arr[i]
                minIndex = i
            }
        }
        return arr.filterIndexed { index, _ -> (index != minIndex) }
    }
}