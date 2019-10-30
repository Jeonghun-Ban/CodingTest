import java.util.*;

class Solution {
    public int[] solution(int[] heights) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] answer = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        int pop = 0;
        int search=0;
        int i;
        int index=0;

        for(int height: heights){
            stack.push(height);
        }

        while(stack.size()>1){
            pop = stack.pop();
            i = stack.size()-1; // 배열접근자, size-1
            search = heights[i];
            index = 1+i--;

            while(search<pop && i>=0){
                search = heights[i];
                index = 1+i--;
            }
            if(pop>=search){
                index = 0;
            }
            ans.add(index);
        }
        ans.add(0);
        Collections.reverse(ans);

        for(int j=0; j<ans.size(); j++){
            answer[j] = ans.get(j);
        }

        return answer;
    }
}
