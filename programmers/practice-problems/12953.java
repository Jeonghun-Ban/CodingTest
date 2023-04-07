class Solution {
    public int solution(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            arr[i+1] = lcm(arr[i], arr[i+1]);
        }
        
        return arr[arr.length-1];
    }
    
    private int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        int remain = a % b;
        
        if (remain == 0) {
            return b;
        }
        
        return gcd(b, remain);
    }
    
    private int lcm(int a, int b) {
        return a*b/gcd(a,b);
    }
}
