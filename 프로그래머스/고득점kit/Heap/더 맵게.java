import java.util.*;

class Solution {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        // The head of this queue is the least element with respect to the specified ordering.
        PriorityQueue<Integer> priority_queue = new PriorityQueue<Integer>(); 

        for (int scoville_each : scoville){
            priority_queue.add(scoville_each);
        }

        while (priority_queue.peek() < K){

            if( priority_queue.size() <=1) return -1; 


            ++answer; 

            int current_peek = priority_queue.peek();
            priority_queue.remove();
            int second_peek = priority_queue.peek();
            priority_queue.remove();


            int scov = current_peek + second_peek*2;
            priority_queue.add(scov);
        }

        return answer;
    }
}
