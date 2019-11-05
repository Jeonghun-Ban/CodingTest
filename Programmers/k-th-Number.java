import java.util.*;

class Solution {
    int[] arr = {};

    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < commands.length; i++){
            arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(arr);

            list.add(arr[commands[i][2]-1]);
        }

        int[] answer = new int[list.size()];
        for(int j = 0; j < list.size(); j++){
            answer[j] = list.get(j);
        }
        return answer;
    }
}
