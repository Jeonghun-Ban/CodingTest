import java.util.List;
import java.util.ArrayList;


class Solution {
    
    private int[] student1 = {1, 2, 3, 4, 5};
    private int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        
        scores[0] = calculateScore(answers, student1);
        scores[1] = calculateScore(answers, student2);
        scores[2] = calculateScore(answers, student3);
        
        int maxScore = getMax(scores);
        int[] answer = getWinners(maxScore, scores);
        return answer;
    }
    
    private int calculateScore(int[] answers, int[] student) {
        int score = 0;
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == student[i%student.length]) {
                score++;
            }
        }
        return score;
    }
    
    private int getMax(int[] scores) {
        int max = 0;
        for (int score: scores) {
            max = Math.max(score, max);
        }
        return max;
    }
    
    private int[] getWinners(int maxScore, int[] scores) {
        List<Integer> winners = new ArrayList<>();
        for (int i=0; i<scores.length; i++) {
            if (scores[i] == maxScore) {
                winners.add(i+1);
            }
        }
        
        int[] result = new int[winners.size()];
        for (int i=0; i<result.length; i++) {
            result[i] = winners.get(i);
        }
        
        return result;
    }
}
