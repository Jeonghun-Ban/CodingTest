import java.util.Deque;
import java.util.ArrayDeque;
import java.lang.Character;

class Solution {
    char LEFT_PARENTHESES = '(';
    char RIGHT_PARENTHESES = ')';
    
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        char firstElement = s.charAt(0);
        if (firstElement == RIGHT_PARENTHESES) {
            return false;
        }
        
        for (char element: s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(element);
            } else {
                next(stack, element);   
            }
        }

        return stack.isEmpty();
    }
    
    private void next(Deque<Character> stack, char element) {
        if (isClosed(stack.peek(), element)) {
            stack.remove();
        } else {
            stack.add(element);
        }
    }
    
    private boolean isClosed(char start, char end) {
        return start == LEFT_PARENTHESES &&
            end == RIGHT_PARENTHESES;
    }
}
