class Solution {
    fun solution(a: Int, b: Int, c: Int): Int {
        if(a == b && b == c) return 27 * a*a*a*a*a*a
        if(a == b) return (2*a + c) * (2*a*a + c*c)
        if(a == c) return (2*a + b) * (2*a*a + b*b)
        if(b == c) return (2*b + a) * (2*b*b + a*a)
        return a+b+c
    }
}