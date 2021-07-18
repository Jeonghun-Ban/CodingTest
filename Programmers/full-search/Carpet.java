class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown+yellow;
        int width = 3;
        int height = total/width; 
        
        while (width<=total/3){
            height=total/width;
            if (brown == 2*width+2*(height-2) && width >= height){
                break;
            }
            width++;
        }
        
        int[] answer = {width, height};
        return answer;
    }
}