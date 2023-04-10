import java.util.List;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        List<Character> list = new LinkedList<>();
        for (char c: s.toCharArray()) {
            list.add(c);
        }
        
        for (int i=0; i<list.size(); i++) {
            if (check(list)) {
                answer++;
            }
            spin(list);
        } 
        
        return answer;
    }
    
    private void spin(List<Character> list) {
        char lastElement = list.remove(list.size()-1);
        list.add(0, lastElement);
    }
    
    private boolean check(List<Character> list) {
        Deque<Character> temp = new ArrayDeque<>();
        
        for(int i=0; i<list.size(); i++) {
            char element = list.get(i);
            if (temp.isEmpty()) {
                temp.push(element);
            } else if (isCorrect(temp.peek(), element)) {
                temp.pop();
            } else {
                temp.push(element);
            }
        }
        
        return temp.isEmpty();
    }
    
    private boolean isCorrect(char s1, char s2) {
        if (s1 =='(' && s2 == ')') {
            return true;
        }
        if (s1 =='{' && s2 == '}') {
            return true;
        }
        if (s1 =='[' && s2 == ']') {
            return true;
        }
        return false;
    }
}
