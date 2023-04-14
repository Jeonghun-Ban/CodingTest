import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
        int count;
        
        Queue<Integer> foods = new PriorityQueue<>();
        for(int s: scoville) {
            foods.offer(s);
        }
        
        for(count = 0; foods.peek() < K; count++) {
            if (count == scoville.length - 1) {
                return -1;
            }
            foods.offer(makeNewFood(foods));
        }
        
        return count;
    }
    
    private int makeNewFood(Queue<Integer> foods) {
        int firstFood = foods.poll();
        int secondFood = foods.poll();
        return firstFood + (secondFood * 2);
    }
}
