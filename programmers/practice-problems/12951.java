import java.lang.Character;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String solution(String s) {
        String[] words = split(s);
        
        for (int i=0; i<words.length; i++){
            words[i] = jadonCase(words[i]);
        }
        
        return String.join(" ", words);
    }
    
    private String[] split(String s) {
        List<String> words = new ArrayList<>();
        String buffer = "";
        
        for (char c: s.toCharArray()) {
            if (c != ' ') {
                buffer += c;
            } else {
                words.add(buffer);
                buffer = "";
            }
        }
        words.add(buffer);
        
        String[] result = words.toArray(new String[words.size()]);
        return result;
    }
    
    private String jadonCase(String s) {
        if (s.equals("")) {
            return s;
        }
        
        String lowerCase = s.toLowerCase();
        char[] arr = lowerCase.toCharArray();
        
        if (Character.isAlphabetic(arr[0])) {
            arr[0] = Character.toUpperCase(arr[0]);
        }
        return String.valueOf(arr);
    }
}
