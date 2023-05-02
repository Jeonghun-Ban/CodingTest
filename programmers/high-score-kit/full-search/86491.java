class Solution {
    public int solution(int[][] sizes) {
        swap(sizes);
        return minimum(sizes);
    }
    
    private void swap(int[][] sizes) {
        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
        }
    }
    
    private int minimum(int[][] sizes) {
        int w = 0;
        int h = 0;
        
        for (int[] size: sizes) {
            w = Math.max(w, size[0]);
            h = Math.max(h, size[1]);
        }
        
        return w * h;
    }
}
