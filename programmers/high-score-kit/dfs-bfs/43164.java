import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public String[] solution(String[][] tickets) {
        List<String[]> result = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];
        String[] current = new String[tickets.length + 1];
        
        String start = "ICN";
        current[0] = start;
        dfs(start, tickets, visited, 0, current, result);
        
        Collections.sort(result, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                return String.join("", s1).compareTo(String.join("", s2));
            }
        });
        
        return result.get(0);
    }
    
    private void dfs(String start, String[][] tickets, boolean[] visited,
                    int depth, String[] current, List<String[]> result) {

        if (depth==tickets.length) {
            result.add(current.clone());
            return;
        }
        
        for (int i=0; i<tickets.length; i++) {
            if (visited[i] == false && tickets[i][0].equals(start)) {
                visited[i] = true;
                current[depth+1] = tickets[i][1];
                dfs(tickets[i][1], tickets, visited, depth+1, current, result);
                visited[i] = false;
            }
        }
    }
}
