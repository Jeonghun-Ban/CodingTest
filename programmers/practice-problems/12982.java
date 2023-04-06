import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int key: tangerine) {
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((key1, key2) -> map.get(key2).compareTo(map.get(key1)));
        
        for (int key: keySet) {
            if (k<=0) {
                return answer;
            }
            k -= map.get(key);
            answer++;
        }
        
        return answer;
    }
}
