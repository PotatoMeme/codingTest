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
                sum = (sum shl 4) + (input[i].digitToInt(16))
            }
        } else {//8
            for (i in 1 until input.length) {
                sum = (sum shl 3) + (input[i].digitToInt(8))
            }
        }
        print(sum)
    } else {//10
        print(input)
    }
}