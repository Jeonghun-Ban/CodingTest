import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<>();
        
        for (int i=0; i<priorities.length; i++) {
            queue.offer(new Document(priorities[i], i));
        }
        
        int cnt = 0;
        
        while (!queue.isEmpty()) {
            Document firstDucument = queue.poll();
            boolean isPrint = true;
            
            for (Document otherDucument: queue) {
                if (firstDucument.priority < otherDucument.priority) {
                    queue.offer(firstDucument);
                    isPrint = false;
                    break;
                }
            }
            
            if (isPrint) {
                cnt++;
                
                if (firstDucument.isLocation(location)) {
                    return cnt;
                }
                
                isPrint = true;
            }
        }
        
        return 0;
    }

    class Document {
        int priority;
        int location;
        
        public boolean isLocation(int location) {
            return this.location == location;
        }
        
        public Document(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
}
