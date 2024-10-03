package 프로그래머스.Level2;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<Integer>();

        // 가장 마지막 원소는 무조건 -1
        int last_index = numbers.length -1;
        stack.push(numbers[last_index]);
        answer[last_index] = -1;

        for(int i = numbers.length-2; i>=0; i--){
//            System.out.println("index: "+ i);
            int current = numbers[i];
            while(true){
                int stack_top = stack.peek();
                if( stack_top <= current ) {
                    stack.pop();
                    if(stack.empty()) {
                        answer[i] = -1;
                        break;
                    }
                }
                else {
                    answer[i] = stack_top;
                    break;
                }
            }
            stack.push(numbers[i]);
        }
        return answer;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] numbers = {9, 1, 5, 3, 6, 2};
//        int[] ss = s.solution(numbers);
//        System.out.println(Arrays.toString(ss));
//    }

}


