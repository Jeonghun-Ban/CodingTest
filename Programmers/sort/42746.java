import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String num = "";
        String[] nums = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++){
            num = Integer.toString(numbers[i]);
            nums[i] = num;
        }

        Arrays.sort(nums, new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            return (s2+s1).compareTo(s1+s2);
            }
          });

        if (nums[0].equals("0")) return "0";

        for (int j = 0; j <nums.length; j++){
            answer += nums[j];
        }

        return answer;
    }
}
