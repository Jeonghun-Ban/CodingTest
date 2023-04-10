class Solution {
    public int[] solution(int n, long left, long right) {
        int[] arr = new int[(int)(right-left+1)];
        long searchIndex = left;
        
        for (int i = 0; i < arr.length; i++) {
            int row = (int)(searchIndex / n + 1);
            int column = (int)(searchIndex % n + 1);
            arr[i] = Math.max(row, column);
            searchIndex++;
        }
     
        return arr;
    }
}
