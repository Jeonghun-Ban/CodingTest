import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(participant).forEach(s -> map.put(s, map.getOrDefault(s, 0)+1));
        Arrays.stream(completion).forEach(s -> map.put(s, map.get(s)-1));
        Optional<String> answer = map.keySet().stream().filter(k -> map.get(k)!=0).findFirst();
        return answer.get();
    }
}
