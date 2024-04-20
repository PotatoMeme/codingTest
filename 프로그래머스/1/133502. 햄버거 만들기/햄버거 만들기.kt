class Solution {
     fun solution(ingredient: IntArray): Int {
        var answer = 0
        var list = arrayListOf<Int>()
        for (i in ingredient) {
            list.add(i)
            if (list.size > 3) {
                if ( list[list.size - 1] == 1&&list[list.size - 2]==3&&list[list.size - 3] == 2 &&list[list.size - 4] ==1){
                    answer++
                    list.removeLast()
                    list.removeLast()
                    list.removeLast()
                    list.removeLast()
                }
            }
        }
        return answer
    }
}