import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String element = clothes[i][1];
            hm.put(element, hm.getOrDefault(element, 0)+1);
        }
        for (String key : hm.keySet()) {
            int value = hm.get(key);
	        answer = answer*(value+1);
	    }
        return answer-1;
    }
}
