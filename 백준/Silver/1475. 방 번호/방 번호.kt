fun main() = with(System.`in`.bufferedReader()) {
    val numberCount = IntArray(10)
    readLine().toCharArray().forEach {
        numberCount[it-'0']++
    }
    (numberCount[6]+numberCount[9]).let{
        val avg =(it / 2.0)
        if (avg % 1 != 0.0){
            numberCount[6] = avg.toInt()+1
            numberCount[9] = avg.toInt()+1
        }else{
            numberCount[6] = avg.toInt()
            numberCount[9] = avg.toInt()
        }
    }
    print(numberCount.max())
}