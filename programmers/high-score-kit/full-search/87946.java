class Solution {
    private int max = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited);
        return max;
    }

    private void dfs(int heart, int[][] dungeons, boolean[] visited) {

        int count = 0;
        for (int i=0; i<visited.length; i++) {
            if (visited[i]) {
                count++;
            }
        }

        max = Math.max(max, count);
    
        for (int i=0; i<dungeons.length; i++) {
            if (!visited[i] && heart >= dungeons[i][0]) {
                visited[i] = true;
                heart -= dungeons[i][1];
                dfs(heart, dungeons, visited);
                heart += dungeons[i][1];
                visited[i] = false;
            }
        }
    }
}
