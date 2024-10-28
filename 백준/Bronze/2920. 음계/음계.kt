val ascending = listOf(1, 2, 3, 4, 5, 6, 7, 8)
val descending = listOf(8, 7, 6, 5, 4, 3, 2, 1)
fun main() {
    val input = readln().split(" ").map { it.toInt() }
    when (input) {
        ascending -> {
            print("ascending")
        }
        descending -> {
            print("descending")
        }
        else -> {
            print("mixed")
        }
    }
}