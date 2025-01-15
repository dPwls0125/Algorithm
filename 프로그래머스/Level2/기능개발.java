import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            int left_days = (int) Math.ceil((float) (100 - progresses[i]) / speeds[i]);
            q.add(left_days);
        }

        int front = q.poll();
        int once = 1;
        while(!q.isEmpty()){
            if(front >= q.peek()){
                once++;
                q.poll();
            }else{
                answer.add(once);
                once = 1;
                front = q.poll();
            }
            if(q.isEmpty()) answer.add(once);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
