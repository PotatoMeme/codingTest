fun main() {
    val line = readln()
    var happyCount = 0
    var sadCount = 0
    for (i in 0 until line.length - 2) {
        if (line[i] == ':' && line[i + 1] == '-') {
            if (line[i + 2] == '(') {
                sadCount++
            } else if (line[i + 2] == ')') {
                happyCount++
            }
        }
    }
    when{
        happyCount == 0 && sadCount == 0 -> print("none")
        happyCount > sadCount -> print("happy")
        sadCount > happyCount -> print("sad")
        else -> print("unsure")
    }
}