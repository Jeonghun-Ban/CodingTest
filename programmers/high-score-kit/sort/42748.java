import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
    
        int i = 0;
        for (int[] command: commands) {
            int value = getValueFrom(array, command);
            answer[i++] = value;
        }
        
        return answer;
    }
    
    private int getValueFrom(int[] array, int[] command) {
        int start = command[0];
        int end = command[1];
        int findIndex = command[2];
        
        int[] temp = IntStream.range(start-1, end)
            .map(i -> array[i])
            .toArray();
        Arrays.sort(temp);
        
        return temp[findIndex-1];
    }
}
