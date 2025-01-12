import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String X, String Y) {

        StringBuilder answer = new StringBuilder();
        int[] numberX = new int[10];
        int[] numberY = new int[10];

        for(int i=0; i<X.length(); i++){
            int num = Integer.parseInt(X.substring(i,i+1));
            numberX[num] ++;
        }
        for(int i=0; i<Y.length(); i++){
            int num = Integer.parseInt(Y.substring(i,i+1));
            numberY[num]++;
        }

        ArrayList<Integer> num_list = new ArrayList<Integer>();

        for(int i=0; i<=9; i++){
            if(numberX[i] == 0 || numberY[i]==0){
                continue;
            }
            int correspond_number = Math.min(numberX[i],numberY[i]);
            for(int j=0; j<correspond_number;j++){
                num_list.add(i);
            }
        }

        if(num_list.size() == 0) return "-1";

        Collections.sort(num_list,Collections.reverseOrder());


        if(num_list.get(0) == 0){
            return "0";
        }
        for(int i=0; i<num_list.size(); i++){
            answer.append(num_list.get(i));
        }


        return answer.toString();
    }
}