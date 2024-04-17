class Solution {
    fun solution(phone_number: String): String {
       var answer = StringBuilder()
        for (i in phone_number.indices){
            if (phone_number.length - i > 4){
                answer.append('*')
            }else{
                answer.append(phone_number[i])
            }
        }
        return answer.toString()
    }
}
