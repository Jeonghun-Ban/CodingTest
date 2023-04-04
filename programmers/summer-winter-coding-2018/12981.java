import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> wordDict = new ArrayList<>();
        
        int people = 0;
        int round = 1;

        for (String word: words) {
            people++;
            System.out.print(people + "/" + round);
            
            if (isInvalidWord(word, wordDict)) {
                answer[0] = people;
                answer[1] = round;
                return answer;
            }
            
            wordDict.add(word);
            
            if (people==n) {
                people = 0;
                round++;
            }
        }

        answer[0] = 0;
        answer[1] = 0;
        return answer;
    }
    
    private boolean isInvalidWord(String word, List<String> dict) {
        if (word.length() == 1 || dict.contains(word)) {
            return true;
        }
        
        if (dict.size() != 0) {
            String lastItem = dict.get(dict.size() - 1);
            return word.charAt(0) != lastItem.charAt(lastItem.length() - 1);
        }
        
        return false;
    }
}
