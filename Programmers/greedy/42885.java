import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        List<Integer> list = new ArrayList<>(people.length);
        for (int person : people) list.add(person);
        Collections.sort(list);
        
        Deque<Integer> dq = new ArrayDeque<>(people.length);
        for (int person : list) dq.add(person);
        
        int boatNumber = 0;
        
        while(dq.isEmpty() == false) {
            int heaviest = dq.pollLast();
            if(dq.isEmpty() == false && heaviest + dq.peekFirst() <= limit) dq.remove();
            boatNumber++;
        }
        
        return boatNumber;
    }
}