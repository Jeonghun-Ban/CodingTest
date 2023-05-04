import java.util.Set;
import java.util.HashSet;

class Solution {

    public int solution(String numbers) {
        Set<Integer> result = new HashSet<>();
        char[] nums = numbers.toCharArray();
        boolean[] visited = new boolean[nums.length];
        
        for (int i=1; i<=nums.length; i++) {
            permutation(nums, visited, new char[i], result, 0, i);
        }
        
        return (int) result.stream()
            .filter(this::isPrime).count();
    }

    private boolean isPrime(int num) {
        if (num == 1 || num == 0) {
            return false;
        }
        
        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private void permutation(char[] numbers, boolean[] visited, char[] perm,
                            Set<Integer> result, int depth, int count) {
        
        if (depth == count) {
            result.add(Integer.parseInt(new String(perm)));
            return;
        }
        
        for (int i=0; i<numbers.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                perm[depth] = numbers[i];
                permutation(numbers, visited, perm, result, depth+1, count);
                visited[i] = false;
            }
        }
    }
}
