import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        
        for (String filename: files) {
            File file = new File(filename);
            fileList.add(file);
        }
        
        Collections.sort(fileList);
        
        String[] answer = new String[fileList.size()];
        for (int i=0; i<fileList.size(); i++) {
            File file = fileList.get(i);
            answer[i] = file.toString();
        }
        return answer;
    }
    
    class File implements Comparable<File> {
        private String head = "";
        private String number = "";
        private String tail = "";

        File(String filename) {
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(filename);
            
            if (m.find()) {
                number = m.group();
                int numberStart = filename.indexOf(number);
                int numberEnd = numberStart + number.length() - 1;

                head = filename.substring(0, numberStart);
                tail = filename.substring(numberEnd + 1);
            }
        }

        @Override
        public String toString() {
            return this.head + this.number + this.tail;
        }

        @Override
        public int compareTo(File f) {
            int result = this.head.toLowerCase()
                .compareTo(f.head.toLowerCase());

            if (result == 0) {
                result = Integer.valueOf(this.number)
                    .compareTo(Integer.valueOf(f.number));
            }

            return result;
        }
    }
}
