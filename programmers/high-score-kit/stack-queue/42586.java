import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Work> workQueue = new LinkedList<>();
        
        for (int i=0; i<progresses.length; i++) {
            Work work = new Work(progresses[i], speeds[i]);
            workQueue.add(work);
        }
        
        while (!workQueue.isEmpty()) {
            int cnt = deploy(workQueue);
            if (cnt != 0) {
                result.add(cnt);
            }
            work(workQueue);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int deploy(Queue<Work> queue) {
        int cnt = 0;
        
        while(!queue.isEmpty()) {
            Work work = queue.peek();
            if (!work.isComplete()) {
                break;
            }
            queue.remove();
            cnt++;
        }
        
        return cnt;
    }
    
    public void work(Queue<Work> queue) {
        for(Work work: queue) {
            work.execute();
        }
    }
    
    class Work {
        private int progress = 0;
        private int speed = 0;
        
        Work(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
        
        public void execute() {
            if (this.progress + this.speed > 100) {
                this.progress = 100;
            } else {
                this.progress += speed;
            }
        }
        
        public boolean isComplete() {
            return this.progress == 100;
        }
    }
}
