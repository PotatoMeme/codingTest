fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val n = readLine().toInt()
    sb.appendLine(String.format("%.6f",n*n*Math.PI))
    sb.appendLine(String.format("%.6f",n*n*2.0))
    print(sb.toString())
}