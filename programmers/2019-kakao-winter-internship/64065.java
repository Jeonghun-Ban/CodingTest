import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        
        String[] tuples = tuplesFrom(s);
        for (String tuple: tuples) {
            String[] items = tuple.split(",");
            for(String item: items) {
                int num = Integer.parseInt(item);
                map.put(num, map.getOrDefault(num, 0)+1);
            }
        }
        
        List<Integer> result = new ArrayList<>(map.keySet());
        result.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        return result.stream()
            .mapToInt(i->i).toArray();
    }
    
    private String[] tuplesFrom(String s) {
        return s.substring(2, s.length()-2)
            .split("\\},\\{");
    }
}
