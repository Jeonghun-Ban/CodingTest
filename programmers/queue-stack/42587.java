import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = location+1;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> prio = new ArrayList<>();

        // 큐에 프린터 요청 순차대로 넣기
        for(int priority: priorities){
            q.add(priority);
            prio.add(priority);
        }

        // 출력되는 순서
        Collections.sort(prio);
        Collections.reverse(prio);
        System.out.println(prio.toString());

        int i = 0;
        while(!q.isEmpty()){
            if(q.peek()==prio.get(i)){
                q.poll();
                if(answer==i+1){
                    break;
                }
                i++;
            } else{
                q.add(q.poll());
                if(answer==i+1){
                    answer = priorities.length;
                } else{
                    answer--;
                }
            }
        }

        return answer;
    }
}
