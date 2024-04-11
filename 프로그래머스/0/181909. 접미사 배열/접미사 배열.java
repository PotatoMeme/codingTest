import java.util.stream.IntStream;

class Solution {
    public String[] solution(String myString) {
        return IntStream.range(0, myString.length()).mapToObj(myString::substring).sorted().toArray(String[]::new);
    }
}