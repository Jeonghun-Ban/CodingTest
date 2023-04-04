import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int food: scoville) q.offer(food);
        
        int count;
        for (count=0; q.peek() < K; count++){
            // return -1; If the scoville of all foods does not exceed K
            if (count == scoville.length -1){ count = -1; break; }
            q.offer(q.poll() + 2*q.poll());
        }
        return count;
    }
}