import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // 인형이 쌓일 stack
        Stack<Integer> doll_stack = new Stack<Integer>();
        for(int move : moves){
            for(int i = 0; i < board.length; i++) {
                int current_location_doll = board[i][move-1] ;
                // 인형이 있다면
                if(current_location_doll > 0){
                    // 해당 인형을 뽑을 것이기 때문에 헤당 위치를 0으로 초기화
                    board[i][move-1] = 0;
                    // stack이 비어있거나 top인형과 같지 않으면 쌓기
                    // stack.isEmpty() 문을 사용하는 대신 stack에 0을 처음부터 추가 해주면 쉬울것 같아요 => 인정
                    if( doll_stack.isEmpty() || doll_stack.peek() != current_location_doll){
                        doll_stack.push(current_location_doll);
                        break;
                    }
                    // stack이 비어있지 않고 top 인형과 동일하다면 두 인형 터뜨리기
                    if(doll_stack.peek() == current_location_doll){
                        doll_stack.pop();
                        answer += 2;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}