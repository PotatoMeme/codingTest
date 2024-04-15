class Solution {
    public long solution(long n) {
        char[] chars = Long.toString(n).toCharArray();
        int[] arr = new int[10];
        for (char i : chars){
            arr[i - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >=0;i--){
            for (int j = 0; j < arr[i];j++){
                sb.append(i);
            }
        }
        return Long.parseLong(sb.toString());
    }
}