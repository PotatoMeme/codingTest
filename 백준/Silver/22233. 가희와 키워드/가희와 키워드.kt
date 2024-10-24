import java.util.StringTokenizer

fun main() {
    //메모장에 써진 키워드는 모두 서로 다르며, 총 N개가 존재
    //최대 10개의 키워드에 대해서 글을 작성
    //키워드들 중에 메모장에 있었던 키워드는 가희가 글을 쓴 이후, 메모장에서 지워짐
    //글을 쓰고 나서, 메모장에 있는 키워드 개수가 몇 개인지 알고 싶음

    //키워드 개수 N
    val input: String = readln()
    val (n, m) = input.split(" ").map { it.toInt() }

    //keywords
    val mutableSet = mutableSetOf<String>()
    repeat(n){
        mutableSet.add(readln())
    }

    val sb = StringBuilder()
    repeat(m){
        val st = StringTokenizer(readln(),",")
        while(st.hasMoreTokens()){
            mutableSet.remove(st.nextToken())
        }
        sb.appendLine(mutableSet.size)
    }
    print(sb)
}