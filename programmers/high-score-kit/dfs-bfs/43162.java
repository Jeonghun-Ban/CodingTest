class Solution {
    public int solution(int n, int[][] computers) {
        int channel = 0;
        boolean[] checked = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!checked[i]) {
                dfs(i, computers, checked);
                channel++;
            }
        }
        return channel;
    }

    private void dfs(int i, int[][] computers, boolean[] checked) {
        checked[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if(i!=j && computers[i][j] == 1 && !checked[j]) {
                dfs(j, computers, checked);
            }
        }
    }
}
