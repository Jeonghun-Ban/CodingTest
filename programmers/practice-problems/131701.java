import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> cases = new HashSet<>();
        
        for (int i=0; i<elements.length; i++) {
            List<Integer> sumList = getSumList(elements, i+1);
            
            for (int sum: sumList) {
                cases.add(sum);
            }
        }
        
        return cases.size();
    }
    
    private List<Integer> getSumList(int[] elements, int size) {
        List<Integer> sumList = new ArrayList<>();
        
        for(int i=0; i<elements.length; i++) {
            int sum = 0;
            for(int j=0; j<size; j++) {
                sum+=elements[(i+j)%elements.length];
            }
            sumList.add(sum);
        }
        
        return sumList;
    } 
}