import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Deque<Integer> basket = new ArrayDeque<>();
        int cnt = 0;
        
        for (int move: moves) {
            int item = draw(board, move-1);
            
            boolean result = false;
            if (item!=0) {
                result = push(basket, item);
            }
            
            if (result) {
                cnt += 2;
            }
        }
        
        return cnt;
    }
    
    private boolean push(Deque<Integer> basket, int item) {
        if (!basket.isEmpty() && basket.peek() == item) {
            basket.pop();
            return true;
        }
        
        basket.push(item);
        return false;
    }
    
    private int draw(int[][] board, int col) {
        for (int i=0; i<board.length; i++) {
            int item = board[i][col];
            if (item != 0) {
                board[i][col] = 0;
                return item;
            }
        }
        
        return 0;
    }
}
