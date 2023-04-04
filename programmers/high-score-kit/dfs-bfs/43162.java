class Solution {
    public int solution(int n, int[][] computers) {
        int channel = 0;
        int[] checked = new int[n];
        
        for(int i=0; i<n; i++) {
            if(checked[i] == 0) {
                dfs(i, computers, checked);
                channel++;
            }
        }
        return channel;
    }
    
    
    private void dfs(int i, int[][] computers, int[] checked) {
        checked[i] = 1;
        
        for (int j = 0; j < computers.length; j++) {
            if(i!=j && computers[i][j] == 1 && checked[j] == 0) {
                dfs(j, computers, checked);
            }
        }
    }
}
