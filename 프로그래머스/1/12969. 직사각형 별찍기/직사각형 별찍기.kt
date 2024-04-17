fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    val sb = StringBuilder()
    repeat(b){
        repeat(a){
          sb.append('*')  
        }
        sb.appendLine()
    }
    print(sb.toString())
}