class Solution {
    public int solution(String skill, String[] skillTrees) {
        int cnt = 0;
        
        for (String skillTree: skillTrees) {
            if (verify(skill, skillTree)) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private boolean verify(String skill, String skillTree) {
        int before = 0;
        
        for (char s: skill.toCharArray()) {
            int current = skillTree.indexOf(s);
            
            if (before == -1 && current != -1) {
                return false;
            }
            
            if (current != -1 && current < before) {
                return false;
            }
            
            before = current;
        }
        
        return true;
    }
}
