class Solution {
    public int solution(int n, int a, int b) {
        
        int round = 1;
        
        while(!isFight(a, b)) {
            a = nextRoundNumber(a);
            b = nextRoundNumber(b);
            round++;
        }
        
        return round;
    }
    
    private int nextRoundNumber(int current) {
        if (current%2 == 1) {
            return (current+1)/2;
        }
        return current/2;
    }
    
    private boolean isFight(int a, int b) {
        return Math.abs(a - b) == 1 
            && Math.max(a, b) % 2 == 0;
    }
}
