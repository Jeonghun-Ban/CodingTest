import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> pm = new HashMap<>();
        for (String element: participant){
            pm.put(element, pm.getOrDefault(element, 0)+1);
        }
        for (String element: completion){
            pm.put(element, pm.get(element) - 1);
        }
        for (String key: pm.keySet()){
            if(pm.get(key) != 0){
                answer += key;
            }
        }

        return answer;
    }
}
