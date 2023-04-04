import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] strNums = s.split(" ");
        Integer[] intNums = toIntegerArr(strNums);
        return getMinMax(intNums);
    }
    
    private Integer[] toIntegerArr(String[] strNums) {
        Integer[] intNums = new Integer[strNums.length];
        for (int i=0; i<strNums.length; i++) {
            intNums[i] = Integer.valueOf(strNums[i]);
        }
        return intNums;
    }
    
    private String getMinMax(Integer[] intNums) {
        Arrays.sort(intNums);
        return intNums[0] + " " + intNums[intNums.length-1];
    }
}
