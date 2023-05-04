import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        if (!contains(target, words)) {
            return 0;
        }
        
        boolean[] visited = new boolean[words.length];
        List<Integer> result = new ArrayList<>();

        dfs(begin, target, words, visited, result, 0);
        Collections.sort(result);
        return result.get(0);
    }

    private void dfs(String begin, String target, String[] words, boolean[] visited, List<Integer> result, int count) {
        if (begin.equals(target)) {
            result.add(count);
        }
        
        for (int i=0; i<words.length; i++) {
            if (!visited[i] && isOneDiffChar(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, visited, result, count+1);
                visited[i] = false;
            }
        }
    }
    
    private boolean isOneDiffChar(String origin, String target) {
        int result = 0;
        for (int i = 0; i<origin.length(); i++) {
            if (origin.charAt(i) != target.charAt(i)) {
                result++;
            }
        }
        return result == 1;
    }
    
    private boolean contains(String target, String[] words) {
        return Arrays.asList(words).contains(target);
    }
}
