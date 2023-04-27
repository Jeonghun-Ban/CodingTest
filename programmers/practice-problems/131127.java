import java.util.Queue;
import java.util.LinkedList;

class Solution {
  public int solution(String[] want, int[] number, String[] discount) {
    int count = 0;
    Queue<String> queue = new LinkedList<>();

    for(int i=0; i<10; i++) {
      queue.offer(discount[i]);
      if (isValid(want, number, queue)) {
        count++;
      }
    }

    for (int i=10; i<discount.length; i++) {
      queue.poll();
      queue.offer(discount[i]);
      if (isValid(want, number, queue)) {
        count++;
      }
    }

    return count;
  }

  private boolean isValid(String[] want, int[] number, Queue<String> queue) {
    for(int i=0; i<want.length; i++) {
      int count = 0;
      for (String discount: queue) {
        if (discount.equals(want[i])) {
          count++;
        }
      }

      if (count < number[i]) {
        return false;
      }
    }
    return true;
  }
}