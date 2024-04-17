class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        val totalPrice : Long = (price * (count + 1L)) * count / 2
        return if (money < totalPrice) totalPrice - money else 0L
    }
}