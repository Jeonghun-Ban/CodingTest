import java.lang.Math;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> ans = new ArrayList();
        int publish; // 배포일
        int temp;
        int count;
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<progresses.length; i++){
            double progress = progresses[i];
            double speed = speeds[i];
            int day = (int)Math.ceil((100-progress)/speed); // 처리일
            q.add(day);
        }
        publish = q.poll();
        count = 1;
        while(!q.isEmpty()){
            temp = q.poll(); // 임시저장
            if (publish >= temp){
                count++;
            } else {
                ans.add(count);
                publish = temp;
                count = 1;
            }
        }
        ans.add(count);

        // 배열 출력
        int size = ans.size();
        int[] answer = new int[size];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
