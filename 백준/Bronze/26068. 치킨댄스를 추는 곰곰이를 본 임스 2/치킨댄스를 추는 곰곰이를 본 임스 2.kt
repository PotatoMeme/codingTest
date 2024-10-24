fun main() {
    var count = 0
    repeat(readln().toInt()) {
        if (readln().substring(2).toInt() <= 90) count++
    }
    print(count)
}