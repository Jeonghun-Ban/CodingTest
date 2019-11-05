import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};

        int count[] = {0, 0, 0};
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<answers.length; i++){
            if(student1[i%5]==answers[i]){
                count[0]++;
            }
            if(student2[i%8]==answers[i]){
                count[1]++;
            }
            if(student3[i%10]==answers[i]){
                count[2]++;
            }
        }

        // 최고점수
        int win = count[0];
        if (count[1]>win){
            win = count[1];
        }
        if (count[2]>win){
            win = count[2];
        }

        // 최고 점수에 해당하는 학생
        for(int i=0; i<3; i++){
            if(win==count[i]){
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
