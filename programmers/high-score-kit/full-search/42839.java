import java.util.*;

class Solution {
    List<String> PNums = new ArrayList<>();
    boolean overlap = false;

    public int solution(String numbers) {
        int answer = 0;
        // 배열에 숫자 저장
        String[] nums = numbers.split("");

        for(int i=1; i<=nums.length; i++){
            permutation(nums, 0, nums.length, i);
        }

        System.out.println(PNums.toString());

        // 정렬된 수 가져와서 소수 찾기
        boolean sosu = true;
        for(String PNum: PNums){
            int intPNum = Integer.parseInt(PNum);
            for(int j=2; j<=intPNum-1; j++){
                if(intPNum%j==0){
                    sosu = false;
                }
            }
            if(sosu){
                answer++;
            }
            sosu = true;
        }

        return answer;
    }

    public void permutation(String[] arr, int depth, int n, int r){
        if(depth==r){
            String PNum = "";

            for(int i=0; i<r; i++){
                PNum += arr[i];
            }
            if(Integer.parseInt(PNum)!=0&&Integer.parseInt(PNum)!=1){

                // 중복 검사
                for (String num : PNums){
                    if(Integer.parseInt(num)==Integer.parseInt(PNum)){
                        overlap = true;
                    }
                }
                if(!overlap){
                    PNums.add(PNum);
                }
                overlap = false;

            }
        }

        for(int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

}
