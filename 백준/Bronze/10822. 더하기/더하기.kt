import java.util.StringTokenizer

fun main() {
    //example input : 10,20,30,50,100
    val input = readlnOrNull()
    //convert input to list of integers
    val st = StringTokenizer(input, ",")
    var sum = 0
    while (st.hasMoreTokens()) {
        sum += st.nextToken().toInt()
    }
    print(sum)
}