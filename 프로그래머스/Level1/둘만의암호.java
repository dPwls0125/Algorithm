import java.util.HashSet;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            int temp_index = index;
            char char_askicode = s.charAt(i);

            while(temp_index > 0){
                // 아스키 코드를 한칸 증가시켰을때 z+1 이라면 'a'로 변경
                char_askicode = 'z' == char_askicode ? 'a' : (char)(char_askicode + 1);
                // skip에 포함된 문자라면 temp_index 감소 없이 건너뜀
                if(!skip.contains(String.valueOf(char_askicode))) {
                    temp_index++;
                }
            }
            // 변형된 알파벳을 추가
            answer.append(char_askicode);
        }
        return answer.toString();
    }
}