import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;        
        Deque<Integer> deque= new ArrayDeque<>(people.length);
        
        Arrays.sort(people);
        
        for (int p: people) {
            deque.add(Integer.valueOf(p));
        }
                
        while(!deque.isEmpty()) {
            rideBoat(deque, limit);
            answer++;
        }
        
        return answer;
    }
    
    private void rideBoat(Deque<Integer> deque, int limit) {
        int lastPeople = deque.pollLast();
        if (!deque.isEmpty() && lastPeople + deque.peekFirst() <= limit) {
            deque.pollFirst();
        }
    }
}
