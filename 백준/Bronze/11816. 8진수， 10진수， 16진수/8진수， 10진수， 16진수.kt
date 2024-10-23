fun main() {
    //example input : 10 or 010 or 0x3f6
    //if start with 0 is octal number
    //if start with 0x is hexadecimal
    //changed to basic decimal
    val input = readln()
    if (input.startsWith("0")) {//8 or 16
        var sum = 0
        if (input[1] == 'x') { // 16
            for (i in 2 until input.length) {
                sum = (sum shl 4) or (input[i].charToInt())
            }
        } else {//8
            for (i in 1 until input.length) {
                sum = (sum shl 3) or (input[i] - '0')
            }
        }
        print(sum)
    } else {//10
        print(input)
    }
}

fun Char.charToInt(): Int {
    if (this in '0'..'9') {
        return this - '0'
    }
    return this - 'a' + 10
}