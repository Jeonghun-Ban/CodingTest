import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    public int solution(int[][] maps) {
        int[][] result = new int[maps.length][maps[0].length];
        
        Point start = new Point(0, 0);
        Point end = new Point(maps.length - 1, maps[0].length - 1);
        walk(maps, result, start, end);
        
        if (result[end.x][end.y] == 0) {
            return -1;
        }
        
        return result[end.x][end.y];
    }
    
    private void walk(int[][] maps, int[][] result, Point start, Point end) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        maps[start.x][start.y] = 0;
        result[start.x][start.y] = 1;
        
        while(!q.isEmpty()) {
            Point current = q.poll();
            
            for (int i=0; i<4; i++) {
                Point next = new Point(current.x + dx[i], current.y + dy[i]);
                
                if (next.isIn(end) && next.isStreet(maps)) {
                    q.offer(next);
                    maps[next.x][next.y] = 0;
                    result[next.x][next.y] = result[current.x][current.y] + 1;
                }
            }
        }
    }
    
    class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public boolean isIn(Point end) {
            return x >=0 && x <= end.x && y >= 0 && y <= end.y;
        }
        
        public boolean isStreet(int[][] maps) {
            return maps[x][y] == 1;
        }
    }
}
