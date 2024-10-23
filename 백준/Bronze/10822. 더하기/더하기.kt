fun main() {
    //example input : 10,20,30,50,100
    val input = readlnOrNull()
    val numbers = input?.split(",")?.map { it.toInt() }
    print(numbers?.sum() ?: 0)
}