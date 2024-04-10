class Solution {
    fun solution(myString: String, pat: String): Int {
        val str = StringBuilder().apply {
            myString.forEach {
                when(it){
                    'A' -> append('B')
                    'B' -> append('A')
                    else -> append(it)
                }
            }
        }.toString()

        loop@for (i in 0..str.length-pat.length){
            for ((index,c1) in pat.withIndex()){
                if (str[i+index] != c1) continue@loop
            }
            return 1
        }
        return 0
    }
}