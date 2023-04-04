class Solution {
    public int solution(int n) {
        
        String startBiNum = Integer.toBinaryString(n);
        int nextNum = n+1;
        String nextBiNum = Integer.toBinaryString(nextNum);
        
        while (!compareBiNum(startBiNum, nextBiNum)) {
            nextNum++;
            nextBiNum = Integer.toBinaryString(nextNum);
        }
        
        return nextNum;
    }
    
    private boolean compareBiNum(String find, String target) {
        return countOne(find) == countOne(target); 
    }
    
    private int countOne(String s) {
        int count = 0;
        for(char c: s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}
