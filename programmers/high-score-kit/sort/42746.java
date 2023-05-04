import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = Arrays.stream(numbers)
            .mapToObj(i -> String.valueOf(i)).toArray(String[]::new);

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        if (nums[0].equals("0")) { 
            return "0";
        }

        return String.join("", nums);
    }
}
