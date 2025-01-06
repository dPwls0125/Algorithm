import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        int answer = 0;
        int[] current_cloths = new int[n+2];
        Arrays.fill(current_cloths,1);

        for(int i=0; i<reserve.length; i++){
            current_cloths[reserve[i]] = 2;
        }

        for(int i=0; i<lost.length; i++){
            current_cloths[lost[i]] --;
        }

        for(int i=1; i<=n; i++){
            if(current_cloths[i] == 0){
                if(i-1 >=0 && current_cloths[i-1]==2 ){
                    current_cloths[i] ++;
                    current_cloths[i-1]--;
                    continue;
                }
                if(i+1 <= n && current_cloths[i+1]==2){
                    current_cloths[i]++;
                    current_cloths[i+1]--;
                }
            }
        }

        for (int i=1; i<=n; i++){

            if(current_cloths[i] > 0){
                answer++;
            }
        }
        return answer;
    }
}
