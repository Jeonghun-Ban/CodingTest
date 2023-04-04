class Solution {
    private int count = 0;
    private int removedZero = 0;
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        String input = s;
        while(!input.equals("1")) {
            input = removeZero(input);
            input = Integer.toBinaryString(input.length());
            count++;
        }
        
        answer[0] = count;
        answer[1] = removedZero;
        return answer;
    }
    
    private String removeZero(String s) {
        String result = "";
        for (char c: s.toCharArray()) {
            if (c == '0') {
                removedZero++;
            }
            if (c == '1') {
                result+="1";
            }
        }
        return result;
    }
}
