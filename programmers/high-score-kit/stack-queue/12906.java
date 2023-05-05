import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int element: arr) {
            if (deque.isEmpty() || deque.peek() != element) {
                deque.push(element);
            }
        }
        
        int[] answer = new int[deque.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = deque.removeLast();
        }
        return answer;
    }
}
