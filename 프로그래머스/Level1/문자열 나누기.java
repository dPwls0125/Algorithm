import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Queue<String> q = new LinkedList<String>();
        // s의 스펠링을 분해하여 queue에 넣습니당
        for(int i=0; i<s.length(); i++){
            q.add(s.substring(i,i+1));
        }
        // 조건에 따라 x를 갱신하며 문자열 분리
        String x = q.poll();
        int numberOfX = 1;
        int numberOfDiff = 0;

        while(true){

            if(q.isEmpty()){
                answer++;
                System.out.println("isEmpty++");
                break;
            }

            if(numberOfX == numberOfDiff && numberOfDiff != 0){
                answer++;
                System.out.println("same++");
                numberOfDiff = 0;
                x = q.poll();
                numberOfX = 1;
                continue;
            }


            if(!q.peek().equals(x)){
                numberOfDiff++;
            }

            else {
                numberOfX++;
            }

            q.remove();

        }
        return answer;
    }
}
