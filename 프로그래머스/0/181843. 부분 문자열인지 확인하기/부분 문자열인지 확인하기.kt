class Solution {
    fun solution(myString: String, target: String): Int {
            var index = 0
            val scanLength = target.length - 1
            val targetFirstChar = target[0]
            while (index < myString.length) {
                if (myString[index] == targetFirstChar && index + scanLength < myString.length) {
                    var state = true
                    for ((scanState, i) in (index..index + scanLength).withIndex()) {
                        if (myString[i] != target[scanState]) {
                            state = false
                            break
                        }
                    }
                    if (state) {
                        return 1
                    }
                }
                index++
            }
        return 0
    }
}