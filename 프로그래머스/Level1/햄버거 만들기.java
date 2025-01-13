import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        // 햄버거 패턴: [1, 2, 3, 1]
        for (int part : ingredient) {
            stack.push(part);

            // 스택의 끝 4개 요소가 [1, 2, 3, 1]인지 확인
            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 4) == 1 &&
                        stack.get(size - 3) == 2 &&
                        stack.get(size - 2) == 3 &&
                        stack.get(size - 1) == 1) {

                    // 패턴이 맞으면 제거
                    for (int i = 0; i < 4; i++) {
                        stack.pop();
                    }
                    answer++;
                }
            }
        }
        return answer;
    }
}
