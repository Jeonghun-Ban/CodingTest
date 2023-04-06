import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()) {
            removePair(stack, c);
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
    
    private void removePair(Deque<Character> stack, char c) {
        if (stack.isEmpty()) {
            stack.push(c);
            return;
        }
        
        if (stack.peek() == c) {
            stack.pop();
            return;
        }
        
        stack.push(c);
    }
}
