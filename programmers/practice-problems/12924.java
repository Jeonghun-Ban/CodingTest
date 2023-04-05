class Solution {
    public int solution(int n) {
        int cnt = 0;
        
        for (int i=1; i<=n; i++) {
            if (consecutive(i, n)) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private boolean consecutive(int start, int target) {
        int sum = 0;
        
        for(int i = start; i<=target; i++) {
            sum+=i;
            if (sum==target) {
                return true;
            }
            if (sum>target) {
                return false;
            }
        }
        
        return false;
    }
}
