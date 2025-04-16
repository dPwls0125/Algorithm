import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<>();
        /*
            입력 : 쇠막대기와 레이저 포인터의 위치가 ()로 주어진다. (최대 100,000개)
            레이저 시작점 = "(" , 레이저 끝점 = ")" , 레이저 포인터 쏘는 위치 = "( )"
            - 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
            - 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
            - 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 로직 :  레이저 () => stack 에 쌓여있는 ( 갯수만큼 잘린다.
        //        막대 끝점 ) => 막대 갯수 1 추가
        //        막대 시작점 ( => stack에 추가
        int cnt_sticks = 0;
        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '(') {
                stack.add(i);
            } else if (input.charAt(i) == ')') {
                int peek = stack.pop();
                // 레이저인 경우
                if (peek == i - 1) {
                    cnt_sticks += stack.size();
                } else { // 막대의 끝점인 경우
                    cnt_sticks += 1;
                }
            }
        }
        System.out.println(cnt_sticks);
    }
}




