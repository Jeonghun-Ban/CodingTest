import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] split;
        HashMap<String , String> map = new HashMap<String , String>();
        List<String> list = new ArrayList();

        for(int i = 0; i < record.length; i++){
            if(!record[i].contains("Leave")){
                split = record[i].split(" ");
                map.put(split[1], split[2]); // hashmap
            }
        }

        for(int i = 0; i < record.length; i++){
            if(record[i].contains("Enter")){
                split = record[i].split(" ");
                list.add(map.get(split[1])+"님이 들어왔습니다.");
            }else if(record[i].contains("Leave")){
                split = record[i].split(" ");
                list.add(map.get(split[1])+"님이 나갔습니다.");
            }
        }
        String[] answer = new String[list.size()];
		for(int i = 0 ; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
}
