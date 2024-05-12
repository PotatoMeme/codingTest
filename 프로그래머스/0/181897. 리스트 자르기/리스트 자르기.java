class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer;
        switch (n) {
            case 1:
                answer = new int[slicer[1] + 1];
                for (int i = 0; i < answer.length; i++) {
                    answer[i] = num_list[i];
                }
                //System.arraycopy(num_list, 0, answer, 0, answer.length);
                break;
            case 2:
                answer = new int[num_list.length - slicer[0]];
                for (int i = 0; i < answer.length; i++) {
                    answer[i] = num_list[i + slicer[0]];
                }
                //System.arraycopy(num_list, 0 + slicer[0], answer, 0, answer.length);
                break;
            case 3:
                answer = new int[slicer[1] - slicer[0] + 1];
                for (int i = 0; i < answer.length; i++) {
                    answer[i] = num_list[i + slicer[0]];
                }
                //System.arraycopy(num_list, 0 + slicer[0], answer, 0, answer.length);
                break;
            case 4:
                answer = new int[(int) Math.ceil((slicer[1] - slicer[0] + 1) / ((double) slicer[2]))];
                for (int i = 0; i < answer.length; i++) {
                    answer[i] = num_list[i * slicer[2] + slicer[0]];
                }
                break;
            default:
                answer = new int[0];
                break;
        }
        return answer;
    }
}